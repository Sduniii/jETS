package de.sduni.jets.ui;

import de.sduni.jets.util.LogManager;

import javax.swing.*;
import java.awt.*;

public class LogFrame extends JInternalFrame {

    private final JTextArea textArea;

    public LogFrame() {
        super("System Log", true, true, true, true);
        setSize(800, 400);
        
        textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBackground(Color.BLACK);
        textArea.setForeground(new Color(0, 255, 0));
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 12));
        
        // Fill history
        for (String msg : LogManager.getHistory()) {
            textArea.append(msg + "\n");
        }
        
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        // Status line
        JLabel statusLabel = new JLabel(" Log file: " + LogManager.getLogFilePath());
        statusLabel.setFont(new Font("SansSerif", Font.ITALIC, 11));
        statusLabel.setBorder(BorderFactory.createEtchedBorder());
        mainPanel.add(statusLabel, BorderLayout.SOUTH);
        
        add(mainPanel);
        
        LogManager.addListener(msg -> {
            SwingUtilities.invokeLater(() -> {
                textArea.append(msg + "\n");
                textArea.setCaretPosition(textArea.getDocument().getLength());
            });
        });
    }
}
