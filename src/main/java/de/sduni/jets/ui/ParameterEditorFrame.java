package de.sduni.jets.ui;

import de.sduni.jets.model.v20.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ParameterEditorFrame extends JInternalFrame {

    public ParameterEditorFrame(DeviceInstance dev) {
        super("Parameters: " + dev.getName(), true, true, true, true);
        setSize(600, 500);
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel(new String[]{"Parameter", "Value"}, 0);
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Simple listing of ParameterInstanceRefs
        if (dev.getParameterInstanceRefs() != null) {
            for (ParameterInstanceRef p : dev.getParameterInstanceRefs().getParameterInstanceRef()) {
                model.addRow(new Object[]{p.getRefId(), p.getValue()});
            }
        }

        JPanel bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottom.add(new JButton("Apply"));
        bottom.add(new JButton("Cancel"));
        add(bottom, BorderLayout.SOUTH);
    }
}
