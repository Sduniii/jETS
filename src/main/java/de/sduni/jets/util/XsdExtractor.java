package de.sduni.jets.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Utility to extract XSD schemas from .NET DLL assemblies.
 * Uses a pure Java byte-scanning approach (Method 1).
 */
public class XsdExtractor {

    /**
     * Extracts the ETS6 (v23) schema from the specified DLL.
     * @param dllPath Path to Knx.Ets.Xml.ObjectModel.dll
     * @param outputPath Path where the extracted .xsd should be saved
     */
    public static void extractV23Schema(String dllPath, String outputPath) throws IOException {
        Path path = Paths.get(dllPath);
        if (!Files.exists(path)) {
            throw new IOException("DLL not found: " + dllPath);
        }

        // 1. Read complete DLL as bytes
        byte[] dllBytes = Files.readAllBytes(path);

        // 2. Convert to String using ISO_8859_1 to preserve binary data
        String content = new String(dllBytes, StandardCharsets.ISO_8859_1);

        // 3. Search for the specific ETS6 target namespace
        String searchTarget = "targetNamespace=\"http://knx.org/xml/project/23\"";
        int targetIdx = content.indexOf(searchTarget);
        if (targetIdx == -1) {
            throw new IOException("Schema for version 23 not found in DLL.");
        }

        // 4. Find start of schema (<xs:schema)
        int startIdx = content.lastIndexOf("<xs:schema", targetIdx);
        if (startIdx == -1) {
            throw new IOException("Could not find start tag <xs:schema for version 23.");
        }

        // 5. Find end of schema (</xs:schema>)
        String endTag = "</xs:schema>";
        int endIdx = content.indexOf(endTag, targetIdx);
        if (endIdx == -1) {
            throw new IOException("Could not find end tag </xs:schema> for version 23.");
        }
        endIdx += endTag.length();

        // 6. Extract and save
        String xsd = content.substring(startIdx, endIdx);
        
        // Final cleaning: Optional check if there are binary artifacts at the very end
        // But usually substring is clean.
        
        Files.writeString(Paths.get(outputPath), xsd, StandardCharsets.UTF_8);
        System.out.println("Success! Extracted knx_project_23.xsd to: " + outputPath);
    }

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java XsdExtractor <path-to-dll> <output-xsd-path>");
            return;
        }
        try {
            extractV23Schema(args[0], args[1]);
        } catch (Exception e) {
            System.err.println("Extraction failed: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
