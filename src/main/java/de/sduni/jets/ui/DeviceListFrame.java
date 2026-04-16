package de.sduni.jets.ui;

import de.sduni.jets.model.v20.*;
import de.sduni.jets.Jets;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeviceListFrame extends JInternalFrame {
    private static final Logger logger = LoggerFactory.getLogger(DeviceListFrame.class);

    private JTable table;
    private DefaultTableModel model;
    private List<DeviceInstance> devices = new ArrayList<>();

    public DeviceListFrame(KNX knx) {
        super("Devices", true, true, true, true);
        setSize(900, 600);
        setLayout(new BorderLayout());

        model = new DefaultTableModel(new String[]{"Address", "Name", "Product", "Status"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadDevices(knx);
        
        // Context Menu
        JPopupMenu menu = new JPopupMenu();
        JMenuItem paramItem = new JMenuItem("Edit Parameters");
        paramItem.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) openParameterEditor(devices.get(row));
        });
        menu.add(paramItem);
        
        JMenuItem downloadItem = new JMenuItem("Download Full");
        downloadItem.addActionListener(e -> {
            int row = table.getSelectedRow();
            if (row >= 0) JOptionPane.showMessageDialog(this, "Programming device " + formatIndividualAddress(devices.get(row).getAddress()) + "...");
        });
        menu.add(downloadItem);
        
        table.setComponentPopupMenu(menu);
    }

    private String formatIndividualAddress(int address) {
        int a = (address >> 12) & 0x0F;
        int l = (address >> 8) & 0x0F;
        int d = address & 0xFF;
        return a + "." + l + "." + d;
    }

    private void openParameterEditor(DeviceInstance dev) {
        ParameterEditorFrame frame = new ParameterEditorFrame(dev);
        getDesktopPane().add(frame);
        frame.setVisible(true);
    }

    private void loadDevices(KNX knx) {
        logger.info("Starting device collection for list frame...");
        devices.clear();
        collectDevices(knx, devices);
        logger.info("Collected {} devices.", devices.size());
        for (DeviceInstance dev : devices) {
            String addr = formatIndividualAddress(dev.getAddress());
            String prodName = null;
            if (Jets.currentContext != null) {
                prodName = Jets.currentContext.getDeviceName(addr);
                // Try harder if not found by address
                if (prodName == null || prodName.isEmpty()) {
                    // This is hacky but let's try to find it in the global root
                    // But we don't have easy access to root here easily without a cast or field
                }
            }
            model.addRow(new Object[]{addr, dev.getName(), (prodName != null && !prodName.isEmpty() ? prodName : dev.getProductRefId()), "Ready"});
        }
    }

    private void collectDevices(Object obj, List<DeviceInstance> list) {
        if (obj == null) return;
        
        if (obj instanceof DeviceInstance) {
            DeviceInstance di = (DeviceInstance) obj;
            if (list.stream().noneMatch(existing -> existing.getId() != null && existing.getId().equals(di.getId()))) {
                list.add(di);
            }
            return;
        }

        if (obj instanceof Collection) {
            for (Object item : (Collection<?>) obj) collectDevices(item, list);
        } else if (obj instanceof KnxBase) {
            try {
                for (java.lang.reflect.Method m : obj.getClass().getMethods()) {
                    if (m.getName().startsWith("get") && m.getParameterCount() == 0 && !m.getName().equals("getClass")) {
                        Object val = m.invoke(obj);
                        if (val != null) {
                            if (val instanceof KnxBase || val instanceof Collection) {
                                collectDevices(val, list);
                            }
                        }
                    }
                }
            } catch (Exception ignored) {}
        }
    }
}
