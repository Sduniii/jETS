package de.sduni.jets.project;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;
import de.sduni.jets.model.v20.KNX;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.InputStream;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductReader {
    private static final Logger logger = LoggerFactory.getLogger(ProductReader.class);
    private final XmlMapper xmlMapper;

    public ProductReader() {
        xmlMapper = new XmlMapper();
        xmlMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    /**
     * Reads a .knxprod file and returns all contained KNX data models found.
     */
    public List<KNX> readProduct(Path path) throws Exception {
        logger.info("Reading product file: {}", path.getFileName());
        List<KNX> results = new ArrayList<>();
        
        try (ZipFile zipFile = new ZipFile(path.toFile())) {
            for (FileHeader header : zipFile.getFileHeaders()) {
                String name = header.getFileName();
                if (name.endsWith(".xml") && !name.contains("knx_master")) {
                    try (InputStream is = zipFile.getInputStream(header)) {
                        KNX knx = xmlMapper.readValue(is, KNX.class);
                        if (knx != null && knx.getManufacturerData() != null) {
                            logger.info("Found manufacturer data in {}", name);
                            results.add(knx);
                        }
                    } catch (Exception e) {
                        logger.debug("Could not parse {} as KNX model: {}", name, e.getMessage());
                    }
                }
            }
        }
        
        if (results.isEmpty()) {
            throw new IllegalArgumentException("No valid KNX manufacturer data found in .knxprod file");
        }
        return results;
    }
}
