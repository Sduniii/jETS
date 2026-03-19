package de.sduni.jets.project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import de.sduni.jets.model.v20.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class CatalogManager {
    private static final Logger logger = LoggerFactory.getLogger(CatalogManager.class);
    private static final String CATALOG_DIR = "knx_catalog";
    private final ObjectMapper yamlMapper;
    private final List<Hardware> hardwareList = new ArrayList<>();

    public CatalogManager() {
        yamlMapper = new ObjectMapper(new YAMLFactory());
        try {
            Files.createDirectories(Paths.get(CATALOG_DIR));
            loadLocalCatalog();
        } catch (Exception e) {
            logger.error("Failed to initialize catalog directory", e);
        }
    }

    public void importProductList(List<KNX> productDataList) throws Exception {
        int count = 0;
        for (KNX productData : productDataList) {
            if (productData.getManufacturerData() == null) continue;
            
            for (ManufacturerData_Manufacturer mData : productData.getManufacturerData().getManufacturer()) {
                if (mData.getHardware() != null) {
                    for (Hardware hw : mData.getHardware().getHardware()) {
                        hardwareList.add(hw);
                        // Persist to local YAML for next restart
                        File file = new File(CATALOG_DIR, hw.getId() + ".yaml");
                        yamlMapper.writeValue(file, hw);
                        count++;
                    }
                }
            }
        }
        logger.info("Imported {} hardware items to catalog.", count);
    }

    private void loadLocalCatalog() {
        File dir = new File(CATALOG_DIR);
        File[] files = dir.listFiles((d, name) -> name.endsWith(".yaml"));
        if (files != null) {
            for (File f : files) {
                try {
                    Hardware hw = yamlMapper.readValue(f, Hardware.class);
                    hardwareList.add(hw);
                } catch (Exception e) {
                    logger.warn("Failed to load catalog item: {}", f.getName());
                }
            }
        }
        logger.info("Loaded {} items from local catalog.", hardwareList.size());
    }

    public List<Hardware> getHardwareList() {
        return hardwareList;
    }
}
