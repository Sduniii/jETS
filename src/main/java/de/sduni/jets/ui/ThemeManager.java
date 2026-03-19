package de.sduni.jets.ui;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLaf;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Map;

public class ThemeManager {

    public static void applyBuiltinTheme(String name, JFrame frame) {
        try {
            if ("Darcula".equals(name)) {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
            } else if ("IntelliJ".equals(name)) {
                UIManager.setLookAndFeel(new FlatIntelliJLaf());
            }
            if (frame != null) {
                SwingUtilities.updateComponentTreeUI(frame);
                // Also update any child windows
                for (Window window : Window.getWindows()) {
                    SwingUtilities.updateComponentTreeUI(window);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void applyYamlTheme(File yamlFile, JFrame frame) {
        try {
            // First reset to a clean state (e.g. IntelliJ Light) to clear old custom properties
            UIManager.setLookAndFeel(new FlatIntelliJLaf());

            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String, Object> themeProps = mapper.readValue(yamlFile, Map.class);
            
            // FlatLaf supports setting custom variables directly into UIManager
            // For example: "@accentColor": "#ff0000" or "Panel.background": "#333333"
            for (Map.Entry<String, Object> entry : themeProps.entrySet()) {
                String key = entry.getKey();
                Object value = entry.getValue();
                
                if (value instanceof String && ((String) value).startsWith("#")) {
                    UIManager.put(key, Color.decode((String) value));
                } else {
                    UIManager.put(key, value);
                }
            }
            
            // Re-apply FlatLaf to pick up the new UIManager properties
            FlatLaf.updateUI();

            if (frame != null) {
                SwingUtilities.updateComponentTreeUI(frame);
                for (Window window : Window.getWindows()) {
                    SwingUtilities.updateComponentTreeUI(window);
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(frame, "Failed to load YAML theme:\n" + ex.getMessage(), "Theme Error", JOptionPane.ERROR_MESSAGE);
        }
    }
}
