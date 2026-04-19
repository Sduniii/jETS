package de.sduni.jets.ui;

import de.sduni.jets.Jets;
import de.sduni.jets.model.v20.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.stream.Collectors;

public class DeviceDetailPanel extends JTabbedPane {

    public DeviceDetailPanel(DeviceInstance dev) {
        addTab("Channels", createChannelsTab(dev));
        addTab("Communication Objects", createComObjectsTab(dev));
        addTab("Parameters", createParametersTab(dev));
    }

    private JComponent createChannelsTab(DeviceInstance dev) {
        return new JLabel("Channels View (Work in Progress)");
    }

    private JComponent createComObjectsTab(DeviceInstance dev) {
        String[] columns = {"Number", "Name", "Object Function", "Connected with", "Length", "C", "R", "W", "T", "U", "Priority"};
        DefaultTableModel model = new DefaultTableModel(columns, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        JTable table = new JTable(model);
        
        if (dev.getComObjectInstanceRefs() != null) {
            for (ComObjectInstanceRef ref : dev.getComObjectInstanceRefs().getComObjectInstanceRef()) {
                ComObject co = Jets.currentContext.findComObject(dev, ref.getRefId());
                
                String num = (co != null) ? String.valueOf(co.getNumber()) : "?";
                String name = (ref.getText() != null && !ref.getText().isEmpty()) ? ref.getText() : (co != null ? co.getText() : "");
                String func = (ref.getFunctionText() != null && !ref.getFunctionText().isEmpty()) ? ref.getFunctionText() : (co != null ? co.getFunctionText() : "");
                
                String connections = ref.getConnect().stream()
                        .map(c -> {
                            GroupAddress ga = Jets.currentContext.findGroupAddress(c.getGroupAddressRefId());
                            return (ga != null) ? ga.getName() + " (" + formatGroupAddress(ga.getAddress()) + ")" : c.getGroupAddressRefId();
                        })
                        .collect(Collectors.joining(", "));

                String length = (co != null) ? co.getObjectSize() : "";
                
                model.addRow(new Object[]{
                    num, name, func, connections, length,
                    ref.getCommunicationFlag(), ref.getReadFlag(), ref.getWriteFlag(), 
                    ref.getTransmitFlag(), ref.getUpdateFlag(), ref.getPriority()
                });
            }
        }

        return new JScrollPane(table);
    }

    private JComponent createParametersTab(DeviceInstance dev) {
        return new ParameterFormPanel(dev);
    }

    private String formatGroupAddress(long address) {
        long p = (address >> 11) & 0x1F;
        long m = (address >> 8) & 0x07;
        long s = address & 0xFF;
        return p + "/" + m + "/" + s;
    }
}
