package de.sduni.jets.ui;

import de.sduni.jets.Jets;
import de.sduni.jets.knx.KnxBusManager;
import de.sduni.jets.project.DptTranslator;
import tuwien.auto.calimero.FrameEvent;
import tuwien.auto.calimero.cemi.CEMILData;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class BusMonitorFrame extends JInternalFrame {

    private final DefaultTableModel tableModel;
    private final DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private final KnxBusManager busManager;

    public BusMonitorFrame(KnxBusManager busManager) {
        super("Bus Monitor", true, true, true, true);
        this.busManager = busManager;
        setSize(1100, 600);

        tableModel = new DefaultTableModel(new String[]{
            "Time", "Source", "Source Name", "Dest", "Dest Name", "Service", "Raw Data", "Value"
        }, 0);
        JTable table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        // Bottom Sending Panel
        JPanel sendPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JTextField addrField = new JTextField("1/1/1", 10);
        JTextField valField = new JTextField("", 10);
        String[] dpts = {"1.001 (Switch)", "5.001 (%)", "9.001 (°C)", "14.056 (Power)"};
        JComboBox<String> dptCombo = new JComboBox<>(dpts);
        JButton sendBtn = new JButton("Write");
        
        sendBtn.addActionListener(e -> {
            try {
                String addr = addrField.getText();
                String val = valField.getText();
                String selDpt = ((String) dptCombo.getSelectedItem()).split(" ")[0];
                
                if (selDpt.startsWith("1.")) {
                    boolean b = "On".equalsIgnoreCase(val) || "1".equals(val) || "true".equalsIgnoreCase(val);
                    busManager.writeGroupValue(addr, b);
                } else if (selDpt.startsWith("5.")) {
                    int p = Integer.parseInt(val.replace("%", "").trim());
                    busManager.writeGroupValue(addr, p);
                } else if (selDpt.startsWith("9.") || selDpt.startsWith("14.")) {
                    float f = Float.parseFloat(val.replaceAll("[^0-9.\\-]", ""));
                    busManager.writeGroupValue(addr, f);
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Send failed: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        sendPanel.add(new JLabel("Address:"));
        sendPanel.add(addrField);
        sendPanel.add(new JLabel("Value:"));
        sendPanel.add(valField);
        sendPanel.add(new JLabel("Type:"));
        sendPanel.add(dptCombo);
        sendPanel.add(sendBtn);
        add(sendPanel, BorderLayout.SOUTH);

        busManager.addBusListener(this::onFrameReceived);
    }

    private void onFrameReceived(FrameEvent e) {
        SwingUtilities.invokeLater(() -> {
            String time = LocalTime.now().format(timeFormatter);
            String src = "?";
            String srcName = "";
            String dst = "?";
            String dstName = "";
            String service = e.getFrame().getClass().getSimpleName();
            String rawHex = "";
            String trans = "";

            if (e.getFrame() instanceof CEMILData) {
                CEMILData f = (CEMILData) e.getFrame();
                src = f.getSource().toString();
                dst = f.getDestination().toString();
                
                if (Jets.currentContext != null) {
                    srcName = Jets.currentContext.getDeviceName(src);
                    dstName = Jets.currentContext.getGroupName(dst);
                }

                int mc = f.getMessageCode();
                if (mc == CEMILData.MC_LDATA_IND) service = "Indication";
                else if (mc == CEMILData.MC_LDATA_CON) service = "Confirmation";
                else if (mc == CEMILData.MC_LDATA_REQ) service = "Request";

                byte[] payload = f.getPayload();
                if (payload != null && payload.length > 0) {
                    // Full Raw Hex for debugging
                    StringBuilder sb = new StringBuilder("0x");
                    for (byte b : payload) sb.append(String.format("%02X", b));
                    rawHex = sb.toString();
                    
                    // STRIP KNX HEADER (APCI) TO GET PURE DATA
                    byte[] data;
                    if (payload.length > 1) {
                        // Data > 6 bits: skip 2 bytes APCI header
                        data = Arrays.copyOfRange(payload, 2, payload.length);
                    } else {
                        // Data <= 6 bits: extract from lower 6 bits of the single byte
                        data = new byte[] { (byte)(payload[0] & 0x3F) };
                    }

                    // Convert stripped data back to Hex string for Translator
                    StringBuilder dataHex = new StringBuilder("0x");
                    for (byte b : data) dataHex.append(String.format("%02X", b));

                    String dpt = null;
                    if (Jets.currentContext != null) {
                        dpt = Jets.currentContext.getDptForGroupAddress(dst);
                    }
                    trans = DptTranslator.translate(dpt, dataHex.toString());
                }
            }

            tableModel.insertRow(0, new Object[]{
                time, src, srcName, dst, dstName, service, rawHex, trans
            });
            if (tableModel.getRowCount() > 1000) tableModel.setRowCount(1000);
        });
    }
}
