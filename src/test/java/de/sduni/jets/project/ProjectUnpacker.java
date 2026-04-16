package de.sduni.jets.project;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import de.sduni.jets.model.v20.*;
import de.sduni.jets.util.KnxAddressUtil;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

/**
 * Utility to fully unpack a .knxproj file, including nested project ZIPs.
 * Now uses the core ProjectReader implementation for validation and password derivation.
 */
public class ProjectUnpacker {

    public static void main(String[] args) {
        if (args.length < 1) {
            System.out.println("Usage: java ProjectUnpacker <path-to-knxproj> [output-dir] [password]");
            return;
        }

        Path knxprojPath = Paths.get(args[0]);
        Path outputDir = args.length > 1 ? Paths.get(args[1]) : Paths.get("tmp_unpacked_" + System.currentTimeMillis());
        char[] rawPassword = args.length > 2 ? args[2].toCharArray() : null;

        try {
            System.out.println("Unpacking: " + knxprojPath);
            System.out.println("Target: " + outputDir.toAbsolutePath());
            
            ProjectReader reader = new ProjectReader();
            
            // Derive password as ETS does
            char[] derivedPassword = ProjectReader.deriveEtsPassword(rawPassword);
            if (derivedPassword != null) {
                System.out.println("Using ETS derived password.");
            }

            // 0. Test the ProjectReader's read function (this validates the project)
            System.out.println("Validating project with ProjectReader...");
            KNX knx = reader.readProjectAny(knxprojPath, rawPassword);
            String projectId = (knx.getProject() != null && !knx.getProject().isEmpty() ? knx.getProject().get(0).getId() : "Unknown");
            System.out.println("Validation successful! Project ID: " + projectId);

            // Print some resolved device names to verify ManufacturerData parsing
            if (knx.getProject() != null && !knx.getProject().isEmpty()) {
                Project project = knx.getProject().get(0);
                if (project.getInstallations() != null && !project.getInstallations().getInstallation().isEmpty()) {
                    Project_Installations_Installation inst = project.getInstallations().getInstallation().get(0);
                    if (inst.getTopology() != null) {
                        System.out.println("Topology areas: " + inst.getTopology().getArea().size());
                        int count = 0;
                        for (Topology_Area area : inst.getTopology().getArea()) {
                            System.out.println("  Area: " + area.getName() + " (" + (area.getLine() != null ? area.getLine().size() : 0) + " lines)");
                            if (area.getLine() != null) {
                                for (Topology_Area_Line line : area.getLine()) {
                                    System.out.println("    Line: " + line.getName() + " (" + line.getSegment().size() + " segments, " + line.getDeviceInstance().size() + " direct devices)");
                                    // Print devices from segments
                                    for (Topology_Area_Line_Segment segment : line.getSegment()) {
                                        for (DeviceInstance dev : segment.getDeviceInstance()) {
                                            printDevice(knx, dev);
                                            count++;
                                        }
                                    }
                                    // Print direct devices
                                    for (DeviceInstance dev : line.getDeviceInstance()) {
                                        printDevice(knx, dev);
                                        count++;
                                    }
                                }
                            }
                        }
                        if (count == 0) System.out.println("  NO DEVICES FOUND in topology.");
                    } else {
                        System.out.println("  NO TOPOLOGY FOUND in installation.");
                    }
                }
            }

            if (Files.exists(outputDir)) {
                Files.walk(outputDir)
                     .sorted(Comparator.reverseOrder())
                     .map(Path::toFile)
                     .forEach(File::delete);
            }
            
            // 1. Unpack main zip
            if (Files.isRegularFile(knxprojPath)) {
                Files.createDirectories(outputDir);
                try (ZipFile zipFile = new ZipFile(knxprojPath.toFile())) {
                    if (derivedPassword != null) {
                        zipFile.setPassword(derivedPassword);
                    }
                    zipFile.extractAll(outputDir.toString());
                }

                // 2. Search and unpack nested project zips (usually P-xxxx.zip)
                Files.walk(outputDir).forEach(path -> {
                    if (path.toString().endsWith(".zip")) {
                        try {
                            String fileName = path.getFileName().toString();
                            Path nestedDir = path.getParent().resolve(fileName.substring(0, fileName.length() - 4));
                            System.out.println("  Unpacking nested: " + fileName);
                            
                            try (ZipFile nestedZip = new ZipFile(path.toFile())) {
                                if (derivedPassword != null) {
                                    nestedZip.setPassword(derivedPassword);
                                }
                                nestedZip.extractAll(nestedDir.toString());
                            }
                        } catch (Exception e) {
                            System.err.println("  Failed to unpack nested " + path + ": " + e.getMessage());
                        }
                    }
                });
            } else {
                System.out.println("Source is a directory, skipping extraction step.");
            }

            System.out.println("Success! Files are in: " + outputDir.toAbsolutePath());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void printDevice(KNX knx, DeviceInstance dev) {
        String addr = KnxAddressUtil.toPhysicalAddress(dev.getAddress());
        String prodName = knx.findProductName(dev.getProductRefId());
        String devName = dev.getName() != null ? dev.getName() : "Unnamed";
        System.out.println("      [" + addr + "] " + devName + " -> " + (prodName != null ? prodName : "Unknown Product") + " (ID: " + dev.getId() + ")");
    }
}
