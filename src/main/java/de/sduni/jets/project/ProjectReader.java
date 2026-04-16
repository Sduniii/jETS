package de.sduni.jets.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import de.sduni.jets.model.v20.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import java.util.List;
import java.util.ArrayList;
import java.util.Collection;
import java.lang.reflect.Method;

public class ProjectReader {
    private static final Logger logger = LoggerFactory.getLogger(ProjectReader.class);
    private final XmlMapper xmlMapper;

    public static class EncryptedProjectException extends Exception {
        public EncryptedProjectException(String message) { super(message); }
    }

    public ProjectReader() {
        xmlMapper = new XmlMapper();
        xmlMapper.registerModule(new JavaTimeModule());
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        xmlMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
        // Important: Ignore namespaces to be compatible with different project versions (11, 12, 13, 14, 20)
        xmlMapper.getFactory().getXMLInputFactory().setProperty(javax.xml.stream.XMLInputFactory.IS_NAMESPACE_AWARE, false);
    }

    public static char[] deriveEtsPassword(char[] rawPassword) throws Exception {
        if (rawPassword == null || rawPassword.length == 0) return null;
        String passwordStr = new String(rawPassword);
        byte[] salt = "21.project.ets.knx.org".getBytes(StandardCharsets.US_ASCII);
        byte[] passBytes = passwordStr.getBytes(StandardCharsets.UTF_16LE);

        Mac mac = Mac.getInstance("HmacSHA256");
        mac.init(new SecretKeySpec(passBytes, "HmacSHA256"));

        byte[] derivedKey = new byte[32];
        byte[] currentBlock = new byte[salt.length + 4];
        System.arraycopy(salt, 0, currentBlock, 0, salt.length);
        
        currentBlock[salt.length] = 0;
        currentBlock[salt.length + 1] = 0;
        currentBlock[salt.length + 2] = 0;
        currentBlock[salt.length + 3] = 1;

        byte[] u = mac.doFinal(currentBlock);
        byte[] blockResult = u.clone();

        for (int j = 1; j < 65536; j++) {
            u = mac.doFinal(u);
            for (int k = 0; k < blockResult.length; k++) {
                blockResult[k] ^= u[k];
            }
        }
        System.arraycopy(blockResult, 0, derivedKey, 0, 32);
        return Base64.getEncoder().encodeToString(derivedKey).toCharArray();
    }

    public KNX readProject(Path knxprojPath) throws Exception { return readProject(knxprojPath, null); }

    public KNX readProjectAny(Path path, char[] rawPassword) throws Exception {
        if (Files.isDirectory(path)) {
            return readProjectFromDirectory(path);
        } else {
            return readProject(path, rawPassword);
        }
    }

    public KNX readProject(Path knxprojPath, char[] rawPassword) throws Exception {
        KNX rootKnx = new KNX();
        char[] derivedPassword = (rawPassword != null) ? deriveEtsPassword(rawPassword) : null;

        try (ZipFile zipFile = new ZipFile(knxprojPath.toFile())) {
            if (derivedPassword != null) zipFile.setPassword(derivedPassword);
            else if (zipFile.isEncrypted()) throw new EncryptedProjectException("Project is encrypted.");

            for (FileHeader entry : zipFile.getFileHeaders()) {
                String name = entry.getFileName();
                if (name.equals("knx_master.xml") || (name.startsWith("M-") && name.endsWith(".xml")) ||
                    (name.startsWith("M-") && (name.endsWith("/Hardware.xml") || name.endsWith("/Catalog.xml")))) {
                    try (InputStream is = zipFile.getInputStream(entry)) {
                        KNX part = xmlMapper.readValue(is, KNX.class);
                        mergeManufacturerData(rootKnx, part);
                    } catch (Exception e) {
                        if (e.getMessage() != null && e.getMessage().contains("password") && derivedPassword == null)
                            throw new EncryptedProjectException("Manufacturer data is encrypted.");
                        logger.debug("Skipping file {}: {}", name, e.getMessage());
                    }
                }

                if (name.startsWith("P-") && name.endsWith(".zip")) {
                    Path temp = Files.createTempFile("jets_inner_", ".zip");
                    try (InputStream is = zipFile.getInputStream(entry)) {
                        Files.copy(is, temp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                        try (ZipFile innerZip = new ZipFile(temp.toFile())) {
                            if (derivedPassword != null) innerZip.setPassword(derivedPassword);
                            else if (innerZip.isEncrypted()) throw new EncryptedProjectException("Inner project is encrypted.");
                            
                            for (FileHeader ie : innerZip.getFileHeaders()) {
                                String iname = ie.getFileName();
                                if (iname.endsWith("project.xml") || iname.endsWith("0.xml")) {
                                    try (InputStream iis = innerZip.getInputStream(ie)) {
                                        byte[] content = iis.readAllBytes();
                                        processInnerXml(rootKnx, content, iname);
                                    } catch (Exception e) {
                                        logger.warn("Could not read inner file {}: {}", iname, e.getMessage());
                                    }
                                }
                            }
                        }
                    } finally { Files.deleteIfExists(temp); }
                }
            }
        }
        return rootKnx;
    }

    public KNX readProjectFromDirectory(Path baseDir) throws Exception {
        KNX rootKnx = new KNX();
        logger.info("Reading project from directory: {}", baseDir);
        
        Files.walk(baseDir).forEach(path -> {
            String name = baseDir.relativize(path).toString();
            if (name.equals("knx_master.xml") || (name.startsWith("M-") && name.endsWith(".xml")) ||
                (name.startsWith("M-") && (name.endsWith("/Hardware.xml") || name.endsWith("/Catalog.xml")))) {
                if (Files.isRegularFile(path)) {
                    try (InputStream is = Files.newInputStream(path)) {
                        KNX part = xmlMapper.readValue(is, KNX.class);
                        mergeManufacturerData(rootKnx, part);
                    } catch (Exception e) {
                        logger.debug("Skipping file {}: {}", name, e.getMessage());
                    }
                }
            }
            // Unpacked project data (P-xxxx/0.xml and project.xml)
            String fileName = path.getFileName().toString();
            if (fileName.equals("project.xml") || fileName.equals("0.xml")) {
                if (Files.isRegularFile(path)) {
                    try {
                        byte[] content = Files.readAllBytes(path);
                        processInnerXml(rootKnx, content, name);
                    } catch (Exception e) {
                        logger.warn("Could not read inner file {}: {}", name, e.getMessage());
                    }
                }
            }
        });
        
        return rootKnx;
    }

    private void processInnerXml(KNX rootKnx, byte[] content, String filename) throws Exception {
        String xmlStr = new String(content, StandardCharsets.UTF_8);
        if (xmlStr.contains("project/11")) logger.info("Detected KNX Project Version 1.1 (ETS3)");
        else if (xmlStr.contains("project/12")) logger.info("Detected KNX Project Version 1.2 (ETS4)");
        else if (xmlStr.contains("project/13")) logger.info("Detected KNX Project Version 1.3 (ETS5)");
        else if (xmlStr.contains("project/14")) logger.info("Detected KNX Project Version 1.4 (ETS5.7)");
        else if (xmlStr.contains("project/20")) logger.info("Detected KNX Project Version 2.0 (ETS6)");
        
        KNX innerKnx = xmlMapper.readValue(content, KNX.class);
        if (innerKnx.getProject() != null && !innerKnx.getProject().isEmpty()) {
            Project p = innerKnx.getProject().get(0);
            logger.debug("Read Project from {}: ID={}, Name={}", filename, p.getId(), 
                (p.getProjectInformation() != null ? p.getProjectInformation().getName() : "N/A"));
            if (p.getInstallations() != null && !p.getInstallations().getInstallation().isEmpty()) {
                Project_Installations_Installation inst = p.getInstallations().getInstallation().get(0);
                if (inst.getTopology() != null) {
                    logger.debug("  Topology found with {} areas.", inst.getTopology().getArea().size());
                } else {
                    logger.debug("  No Topology found in this file.");
                }
            }
        }
        mergeKnxData(rootKnx, innerKnx);
    }

    public void unpackKnxProject(Path knxprojPath, Path outputDir, char[] rawPassword) throws Exception {
        char[] derivedPassword = (rawPassword != null) ? deriveEtsPassword(rawPassword) : null;
        
        if (Files.exists(outputDir)) {
            Files.walk(outputDir).sorted(java.util.Comparator.reverseOrder()).map(Path::toFile).forEach(java.io.File::delete);
        }
        Files.createDirectories(outputDir);

        try (ZipFile zipFile = new ZipFile(knxprojPath.toFile())) {
            if (derivedPassword != null) zipFile.setPassword(derivedPassword);
            zipFile.extractAll(outputDir.toString());
        }

        // Unpack nested ZIPs
        for (Path path : Files.walk(outputDir).filter(p -> p.toString().endsWith(".zip")).toList()) {
            try {
                String fileName = path.getFileName().toString();
                Path nestedDir = path.getParent().resolve(fileName.substring(0, fileName.length() - 4));
                try (ZipFile nestedZip = new ZipFile(path.toFile())) {
                    if (nestedZip.isEncrypted() && derivedPassword == null) {
                        throw new EncryptedProjectException("Inner project zip is encrypted.");
                    }
                    if (derivedPassword != null) nestedZip.setPassword(derivedPassword);
                    nestedZip.extractAll(nestedDir.toString());
                }
            } catch (EncryptedProjectException e) {
                throw e;
            } catch (Exception e) {
                logger.warn("Failed to unpack nested zip {}: {}", path, e.getMessage());
            }
        }
    }

    private void mergeManufacturerData(KNX root, KNX source) {
        if (source == null || source.getManufacturerData() == null) return;
        if (root.getManufacturerData() == null) {
            root.setManufacturerData(source.getManufacturerData());
            return;
        }
        List<ManufacturerData_Manufacturer> rList = root.getManufacturerData().getManufacturer();
        List<ManufacturerData_Manufacturer> sList = source.getManufacturerData().getManufacturer();
        if (sList != null) {
            for (ManufacturerData_Manufacturer sm : sList) {
                String sId = sm.getId() != null ? sm.getId() : sm.getRefId();
                if (sId == null) continue;

                ManufacturerData_Manufacturer rm = rList.stream()
                        .filter(m -> {
                            String rId = m.getId() != null ? m.getId() : m.getRefId();
                            return sId.equals(rId);
                        })
                        .findFirst().orElse(null);

                if (rm == null) {
                    rList.add(sm);
                } else {
                    if (sm.getHardware() != null) {
                        if (rm.getHardware() == null) {
                            rm.setHardware(sm.getHardware());
                        } else {
                            rm.getHardware().getHardware().addAll(sm.getHardware().getHardware());
                        }
                    }
                    if (sm.getCatalog() != null) {
                        if (rm.getCatalog() == null) {
                            rm.setCatalog(sm.getCatalog());
                        } else {
                            rm.getCatalog().getCatalogSection().addAll(sm.getCatalog().getCatalogSection());
                        }
                    }
                    if (sm.getApplicationPrograms() != null) {
                        if (rm.getApplicationPrograms() == null) {
                            rm.setApplicationPrograms(sm.getApplicationPrograms());
                        } else {
                            rm.getApplicationPrograms().getApplicationProgram().addAll(sm.getApplicationPrograms().getApplicationProgram());
                        }
                    }
                }
            }
        }
    }

    private void mergeKnxData(KNX root, KNX source) {
        if (source == null || source.getProject() == null) return;
        if (root.getProject() == null) {
            root.setProject(new ArrayList<>(source.getProject()));
            return;
        }

        for (Project sProj : source.getProject()) {
            Project rProj = root.getProject().stream().filter(p -> p.getId().equals(sProj.getId())).findFirst().orElse(null);
            if (rProj == null) {
                root.getProject().add(sProj);
            } else {
                if (sProj.getInstallations() != null && !sProj.getInstallations().getInstallation().isEmpty()) {
                    if (rProj.getInstallations() == null || rProj.getInstallations().getInstallation().isEmpty()) {
                        rProj.setInstallations(sProj.getInstallations());
                    } else {
                        Project_Installations_Installation rInst = rProj.getInstallations().getInstallation().get(0);
                        Project_Installations_Installation sInst = sProj.getInstallations().getInstallation().get(0);
                        
                        if (sInst.getTopology() != null) {
                            if (rInst.getTopology() == null) rInst.setTopology(sInst.getTopology());
                            else mergeTopology(rInst.getTopology(), sInst.getTopology());
                        }
                        if (sInst.getLocations() != null) {
                            if (rInst.getLocations() == null) rInst.setLocations(sInst.getLocations());
                            else mergeLocations(rInst.getLocations(), sInst.getLocations());
                        }
                        if (sInst.getGroupAddresses() != null) {
                            if (rInst.getGroupAddresses() == null) rInst.setGroupAddresses(sInst.getGroupAddresses());
                            else mergeGroupAddresses(rInst.getGroupAddresses(), sInst.getGroupAddresses());
                        }
                    }
                }
            }
        }
    }

    private void mergeTopology(Topology r, Topology s) {
        if (s == null || s.getArea() == null) return;
        for (Topology_Area sArea : s.getArea()) {
            Topology_Area rArea = r.getArea().stream().filter(a -> a.getId().equals(sArea.getId())).findFirst().orElse(null);
            if (rArea == null) {
                r.getArea().add(sArea);
            } else {
                if (sArea.getLine() != null) {
                    for (Topology_Area_Line sLine : sArea.getLine()) {
                        Topology_Area_Line rLine = rArea.getLine().stream().filter(l -> l.getId().equals(sLine.getId())).findFirst().orElse(null);
                        if (rLine == null) {
                            rArea.getLine().add(sLine);
                        } else {
                            // Merge Segments
                            if (sLine.getSegment() != null) {
                                for (Topology_Area_Line_Segment ss : sLine.getSegment()) {
                                    Topology_Area_Line_Segment rs = rLine.getSegment().stream()
                                            .filter(seg -> seg.getId().equals(ss.getId())).findFirst().orElse(null);
                                    if (rs == null) {
                                        rLine.getSegment().add(ss);
                                    } else {
                                        // Merge Devices in Segment
                                        if (ss.getDeviceInstance() != null) {
                                            for (DeviceInstance sd : ss.getDeviceInstance()) {
                                                if (rs.getDeviceInstance().stream().noneMatch(rd -> rd.getId().equals(sd.getId()))) {
                                                    rs.getDeviceInstance().add(sd);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            // Merge direct Devices in Line (legacy or mixed)
                            if (sLine.getDeviceInstance() != null) {
                                for (DeviceInstance sd : sLine.getDeviceInstance()) {
                                    if (rLine.getDeviceInstance().stream().noneMatch(rd -> rd.getId().equals(sd.getId()))) {
                                        rLine.getDeviceInstance().add(sd);
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (s.getUnassignedDevices() != null) {
            if (r.getUnassignedDevices() == null) r.setUnassignedDevices(s.getUnassignedDevices());
            else if (s.getUnassignedDevices().getDeviceInstance() != null) {
                for (DeviceInstance sd : s.getUnassignedDevices().getDeviceInstance()) {
                    if (r.getUnassignedDevices().getDeviceInstance().stream().noneMatch(rd -> rd.getId().equals(sd.getId()))) {
                        r.getUnassignedDevices().getDeviceInstance().add(sd);
                    }
                }
            }
        }
    }

    private void mergeLocations(Locations r, Locations s) {
        for (Space sSpace : s.getSpace()) {
            Space rSpace = r.getSpace().stream().filter(sp -> sp.getId().equals(sSpace.getId())).findFirst().orElse(null);
            if (rSpace == null) r.getSpace().add(sSpace);
            else mergeSpaces(rSpace, sSpace);
        }
    }

    private void mergeSpaces(Space r, Space s) {
        for (DeviceInstanceRef sd : s.getDeviceInstanceRef()) {
            if (r.getDeviceInstanceRef().stream().noneMatch(rd -> rd.getRefId().equals(sd.getRefId()))) {
                r.getDeviceInstanceRef().add(sd);
            }
        }
        for (Space ss : s.getSpace()) {
            Space rs = r.getSpace().stream().filter(p -> p.getId().equals(ss.getId())).findFirst().orElse(null);
            if (rs == null) r.getSpace().add(ss);
            else mergeSpaces(rs, ss);
        }
    }

    private void mergeGroupAddresses(GroupAddresses r, GroupAddresses s) {
        if (s.getGroupRanges() == null) return;
        if (r.getGroupRanges() == null) { r.setGroupRanges(s.getGroupRanges()); return; }
        for (GroupRange sr : s.getGroupRanges().getGroupRange()) {
            if (r.getGroupRanges().getGroupRange().stream().noneMatch(rr -> rr.getId().equals(sr.getId()))) {
                r.getGroupRanges().getGroupRange().add(sr);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java ProjectReader <password>");
            return;
        }
        String pass = args[0];
        char[] derived = deriveEtsPassword(pass.toCharArray());
        System.out.println("Derived Password (Base64): " + new String(derived));
    }
}
