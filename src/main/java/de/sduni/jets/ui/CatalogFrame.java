package de.sduni.jets.ui;

import de.sduni.jets.Jets;
import de.sduni.jets.model.v20.Hardware;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.List;

public class CatalogFrame extends JInternalFrame {

    private DefaultTableModel model;

    public CatalogFrame() {
        super("Hardware Catalog", true, true, true, true);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel top = new JPanel(new FlowLayout(FlowLayout.LEFT));
        top.add(new JLabel("Search:"));
        JTextField searchField = new JTextField(20);
        top.add(searchField);
        JButton searchBtn = new JButton("Search");
        top.add(searchBtn);
        add(top, BorderLayout.NORTH);

        model = new DefaultTableModel(
            new String[]{"Manufacturer ID", "Product Name", "Order Number", "Version"}, 0
        ) {
            @Override public boolean isCellEditable(int r, int c) { return false; }
        };
        JTable table = new JTable(model);
        add(new JScrollPane(table), BorderLayout.CENTER);
        
        loadCatalogData();

        JLabel hint = new JLabel("  Tip: Use 'File -> Import Product' to add more .knxprod files.");
        hint.setFont(new Font("SansSerif", Font.ITALIC, 12));
        add(hint, BorderLayout.SOUTH);
    }

    public void loadCatalogData() {
        model.setRowCount(0);
        if (Jets.catalogManager == null) return;
        List<Hardware> list = Jets.catalogManager.getHardwareList();
        for (Hardware hw : list) {
            model.addRow(new Object[]{
                hw.getId(),
                hw.getName(),
                hw.getSerialNumber(),
                hw.getVersionNumber()
            });
        }
    }
}
