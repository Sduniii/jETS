package de.sduni.jets;

import de.sduni.jets.knx.KnxBusManager;
import de.sduni.jets.ui.*;
import de.sduni.jets.project.*;
import de.sduni.jets.model.v20.*;
import de.sduni.jets.model.secure.KnxKeyring;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

public class Jets extends JFrame {
    private static final Logger logger = LoggerFactory.getLogger(Jets.class);

    private JDesktopPane desktopPane;
    private WindowManager windowManager;
    private ProjectReader projectReader = new ProjectReader();
    private ProductReader productReader = new ProductReader();
    public static CatalogManager catalogManager;
    private KeyringReader keyringReader = new KeyringReader();
    private WorkspaceManager workspaceManager = new WorkspaceManager();
    private KnxBusManager busManager = new KnxBusManager();
    
    private KNX currentKnx;
    private KnxKeyring currentKeyring;
    private List<SavedInterface> savedInterfaces = new ArrayList<>();
    private Path currentWorkspacePath;
    private char[] currentWorkspacePassword;
    private LogFrame logFrame;
    public static KnxContext currentContext;

    public Jets() {
        super("Jets (Java 21 Swing Edition)");
        StandardContextMenu.install();
        logger.info("Application starting...");
        
        catalogManager = new CatalogManager();
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setAlwaysOnTop(true);
        toFront();

        desktopPane = new JDesktopPane();
        desktopPane.setBackground(Color.DARK_GRAY);
        setContentPane(desktopPane);
        
        windowManager = new WindowManager(desktopPane);
        setJMenuBar(createMenuBar());
        
        new Timer(60000, e -> autoSaveWorkspace()).start();
        logger.info("UI initialized.");
    }

    private JMenuBar createMenuBar() {
        JMenuBar mb = new JMenuBar();
        JMenu file = new JMenu("File");
        file.add(new JMenuItem("Open Project (.knxproj)...")).addActionListener(e -> openProjectAction());
        file.add(new JMenuItem("Import Product (.knxprod)...")).addActionListener(e -> importProductAction());
        file.add(new JMenuItem("Open Workspace (.etsws)...")).addActionListener(e -> openWorkspaceAction());
        file.add(new JMenuItem("Import Keyring (.knxkeys)...")).addActionListener(e -> importKeyringAction());
        file.addSeparator();
        file.add(new JMenuItem("Save Workspace As...")).addActionListener(e -> saveWorkspaceAction());
        file.addSeparator();
        file.add(new JMenuItem("Exit")).addActionListener(e -> System.exit(0));
        mb.add(file);

        JMenu view = new JMenu("View");
        view.add(new JMenuItem("Buildings")).addActionListener(e -> openBuildings());
        view.add(new JMenuItem("Group Addresses")).addActionListener(e -> openGroupAddresses());
        view.add(new JMenuItem("Topology")).addActionListener(e -> openTopology());
        view.add(new JMenuItem("Devices")).addActionListener(e -> openDevices());
        view.add(new JMenuItem("Catalog")).addActionListener(e -> openCatalog());
        mb.add(view);

        JMenu bus = new JMenu("Bus");
        bus.add(new JMenuItem("Connect...")).addActionListener(e -> connectBusAction());
        bus.add(new JMenuItem("Monitor")).addActionListener(e -> openBusMonitor());
        mb.add(bus);

        JMenu window = new JMenu("Window");
        JMenu layout = new JMenu("Layout Mode");
        ButtonGroup bg = new ButtonGroup();
        JRadioButtonMenuItem modeFloating = new JRadioButtonMenuItem("Floating", true);
        modeFloating.addActionListener(e -> windowManager.setLayoutMode(WindowManager.LayoutMode.FLOATING));
        JRadioButtonMenuItem modeTiling = new JRadioButtonMenuItem("Tiling");
        modeTiling.addActionListener(e -> windowManager.setLayoutMode(WindowManager.LayoutMode.TILING));
        bg.add(modeFloating); bg.add(modeTiling);
        layout.add(modeFloating); layout.add(modeTiling);
        window.add(layout);
        window.addSeparator();
        window.add(new JMenuItem("System Log")).addActionListener(e -> openLog());
        mb.add(window);

        return mb;
    }

    public void addInternalFrame(JInternalFrame frame) {
        desktopPane.add(frame);
        frame.setVisible(true);
        if (windowManager.getCurrentMode() == WindowManager.LayoutMode.TILING) {
            windowManager.applyTiling();
        }
    }

    private void autoSaveWorkspace() {
        if (currentWorkspacePath != null) {
            saveWorkspace(currentWorkspacePath, currentWorkspacePassword);
        }
    }

    private void saveWorkspace(Path path, char[] pass) {
        try {
            JetsWorkspace ws = new JetsWorkspace();
            ws.setProject(currentKnx);
            ws.setKeyring(currentKeyring);
            ws.setSavedInterfaces(savedInterfaces);
            ws.setLayoutMode(windowManager.getCurrentMode());
            
            List<JetsWorkspace.WindowMetadata> meta = new ArrayList<>();
            for (JInternalFrame f : desktopPane.getAllFrames()) {
                String type = "Unknown";
                if (f instanceof ProjectViewFrame) type = f.getTitle();
                else if (f instanceof DeviceListFrame) type = "Devices";
                else if (f instanceof BusMonitorFrame) type = "BusMonitor";
                else if (f instanceof LogFrame) type = "Log";
                else if (f instanceof CatalogFrame) type = "Catalog";
                meta.add(new JetsWorkspace.WindowMetadata(type, f.getTitle(), f.getX(), f.getY(), f.getWidth(), f.getHeight()));
            }
            ws.setOpenWindows(meta);
            workspaceManager.saveWorkspace(ws, path, pass);
            logger.info("Workspace saved.");
        } catch (Exception e) { logger.error("Save failed", e); }
    }

    private void openWorkspaceAction() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Jets Workspace (.etsws)", "etsws"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                JPasswordField pf = new JPasswordField();
                if (JOptionPane.showConfirmDialog(this, pf, "Workspace Password", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    currentWorkspacePassword = pf.getPassword();
                    currentWorkspacePath = fc.getSelectedFile().toPath();
                    JetsWorkspace ws = workspaceManager.loadWorkspace(currentWorkspacePath, currentWorkspacePassword);
                    currentKnx = ws.getProject();
                    currentKeyring = ws.getKeyring();
                    savedInterfaces = ws.getSavedInterfaces();
                    if (currentKnx != null) currentContext = new KnxContext(currentKnx);
                    desktopPane.removeAll();
                    windowManager.setLayoutMode(ws.getLayoutMode());
                    for (JetsWorkspace.WindowMetadata m : ws.getOpenWindows()) restoreWindow(m);
                    desktopPane.repaint();
                }
            } catch (Exception ex) { logger.error("Load failed", ex); }
        }
    }

    private void restoreWindow(JetsWorkspace.WindowMetadata m) {
        JInternalFrame f = null;
        if (m.type.equals("Buildings") || m.type.equals("Group Addresses") || m.type.equals("Topology")) {
            Project_Installations_Installation inst = currentKnx.getProject().get(0).getInstallations().getInstallation().get(0);
            Object root = m.type.equals("Buildings") ? inst.getLocations() : (m.type.equals("Topology") ? inst.getTopology() : inst.getGroupAddresses());
            f = new ProjectViewFrame(m.type, root);
        } else if (m.type.equals("Devices")) f = new DeviceListFrame(currentKnx);
        else if (m.type.equals("BusMonitor")) f = new BusMonitorFrame(busManager);
        else if (m.type.equals("Log")) f = new LogFrame();
        else if (m.type.equals("Catalog")) f = new CatalogFrame();

        if (f != null) {
            f.setBounds(m.x, m.y, m.width, m.height);
            addInternalFrame(f);
        }
    }

    private void saveWorkspaceAction() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("Jets Workspace (.etsws)", "etsws"));
        if (fc.showSaveDialog(this) == JFileChooser.APPROVE_OPTION) {
            JPasswordField pf = new JPasswordField();
            if (JOptionPane.showConfirmDialog(this, pf, "Set Password", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                currentWorkspacePath = fc.getSelectedFile().toPath();
                if (!currentWorkspacePath.toString().toLowerCase().endsWith(".etsws")) {
                    currentWorkspacePath = Path.of(currentWorkspacePath.toString() + ".etsws");
                }
                currentWorkspacePassword = pf.getPassword();
                saveWorkspace(currentWorkspacePath, currentWorkspacePassword);
            }
        }
    }

    private void openBuildings() {
        if (currentKnx == null || currentKnx.getProject().isEmpty()) { showNoProjectMsg(); return; }
        Project p = currentKnx.getProject().get(0);
        if (p.getInstallations() == null || p.getInstallations().getInstallation().isEmpty()) return;
        Project_Installations_Installation inst = p.getInstallations().getInstallation().get(0);
        addInternalFrame(new ProjectViewFrame("Buildings", inst.getLocations()));
    }
    private void openGroupAddresses() {
        if (currentKnx == null || currentKnx.getProject().isEmpty()) { showNoProjectMsg(); return; }
        Project p = currentKnx.getProject().get(0);
        if (p.getInstallations() == null || p.getInstallations().getInstallation().isEmpty()) return;
        Project_Installations_Installation inst = p.getInstallations().getInstallation().get(0);
        addInternalFrame(new ProjectViewFrame("Group Addresses", inst.getGroupAddresses()));
    }
    private void openTopology() {
        if (currentKnx == null || currentKnx.getProject().isEmpty()) { showNoProjectMsg(); return; }
        Project p = currentKnx.getProject().get(0);
        if (p.getInstallations() == null || p.getInstallations().getInstallation().isEmpty()) {
            JOptionPane.showMessageDialog(this, "No installations found in project.");
            return;
        }
        Project_Installations_Installation inst = p.getInstallations().getInstallation().get(0);
        addInternalFrame(new ProjectViewFrame("Topology", inst.getTopology()));
    }
    private void openDevices() { if (currentKnx != null) addInternalFrame(new DeviceListFrame(currentKnx)); }
    private void openCatalog() { addInternalFrame(new CatalogFrame()); }
    private void openBusMonitor() { addInternalFrame(new BusMonitorFrame(busManager)); }
    private void openLog() {
        if (logFrame == null || logFrame.isClosed()) {
            logFrame = new LogFrame();
            addInternalFrame(logFrame);
        }
        logFrame.setVisible(true);
    }

    private void showNoProjectMsg() {
        JOptionPane.showMessageDialog(this, "Please load a project first.");
    }

    private void openProjectAction() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("KNX Project (.knxproj)", "knxproj"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            Path p = fc.getSelectedFile().toPath();
            loadProjectWorkflow(p, null);
        }
    }

    private void loadProjectWorkflow(Path p, char[] password) {
        try {
            Path tmpDir = java.nio.file.Files.createTempDirectory("jets_proj_");
            logger.info("Unpacking project to temporary directory: {}", tmpDir);
            
            try {
                projectReader.unpackKnxProject(p, tmpDir, password);
            } catch (ProjectReader.EncryptedProjectException ex) {
                JPasswordField pf = new JPasswordField();
                if (JOptionPane.showConfirmDialog(this, pf, "Project Password Required", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    loadProjectWorkflow(p, pf.getPassword());
                    return;
                } else return;
            }

            KNX knx = projectReader.readProjectFromDirectory(tmpDir);
            
            if (knx != null && knx.getProject() != null && !knx.getProject().isEmpty()) {
                currentKnx = knx;
                currentContext = new KnxContext(currentKnx);
                logger.info("Project loaded successfully.");
                openTopology();
            } else {
                JOptionPane.showMessageDialog(this, "Project could not be loaded or is empty.");
            }
        } catch (Exception ex) { 
            logger.error("Load failed", ex);
            JOptionPane.showMessageDialog(this, "Error loading project: " + ex.getMessage());
        }
    }

    private void importProductAction() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("KNX Product (.knxprod)", "knxprod"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                List<KNX> dataList = productReader.readProduct(fc.getSelectedFile().toPath());
                catalogManager.importProductList(dataList);
                JOptionPane.showMessageDialog(this, "Product imported successfully!");
                for (JInternalFrame f : desktopPane.getAllFrames()) {
                    if (f instanceof CatalogFrame) ((CatalogFrame) f).loadCatalogData();
                }
            } catch (Exception ex) { logger.error("Product import failed", ex); }
        }
    }

    private void connectBusAction() {
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        JPanel fieldPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL; gbc.insets = new Insets(5, 5, 5, 5); gbc.gridx = 0; gbc.gridy = 0;

        JTextField ipField = new JTextField("192.168.1.120", 15);
        JComboBox<String> localIpCombo = new JComboBox<>();
        localIpCombo.addItem("192.168.1.128"); 
        try {
            Enumeration<NetworkInterface> nets = NetworkInterface.getNetworkInterfaces();
            for (NetworkInterface netint : Collections.list(nets)) {
                if (netint.isLoopback() || !netint.isUp()) continue;
                for (InetAddress inetAddress : Collections.list(netint.getInetAddresses())) {
                    if (inetAddress.getHostAddress().contains(":")) continue; 
                    if (!"192.168.1.128".equals(inetAddress.getHostAddress())) localIpCombo.addItem(inetAddress.getHostAddress());
                }
            }
        } catch (Exception ignored) {}

        JComboBox<KnxBusManager.ConnectionType> typeCombo = new JComboBox<>(KnxBusManager.ConnectionType.values());
        typeCombo.setSelectedItem(KnxBusManager.ConnectionType.SECURE_TUNNEL_TCP);
        JPasswordField dacField = new JPasswordField(15);
        JSpinner userSpinner = new JSpinner(new SpinnerNumberModel(3, 1, 127, 1));
        JPasswordField passField = new JPasswordField(15);
        JCheckBox showPass = new JCheckBox("Show Keys/Passwords");
        
        DefaultListModel<SavedInterface> listModel = new DefaultListModel<>();
        for (SavedInterface si : savedInterfaces) listModel.addElement(si);
        JList<SavedInterface> interfaceList = new JList<>(listModel);
        interfaceList.addListSelectionListener(l -> {
            SavedInterface si = interfaceList.getSelectedValue();
            if (si != null) {
                ipField.setText(si.ip); typeCombo.setSelectedItem(si.type);
                dacField.setText(si.dac); userSpinner.setValue(si.userId); passField.setText(si.password);
            }
        });

        showPass.addActionListener(al -> {
            char echo = showPass.isSelected() ? (char) 0 : '*';
            passField.setEchoChar(echo); dacField.setEchoChar(echo);
        });

        fieldPanel.add(new JLabel("Gateway IP:"), gbc); gbc.gridx = 1; fieldPanel.add(ipField, gbc);
        gbc.gridx = 0; gbc.gridy++; fieldPanel.add(new JLabel("Local IP:"), gbc); gbc.gridx = 1; fieldPanel.add(localIpCombo, gbc);
        gbc.gridx = 0; gbc.gridy++; fieldPanel.add(new JLabel("Type:"), gbc); gbc.gridx = 1; fieldPanel.add(typeCombo, gbc);
        gbc.gridx = 0; gbc.gridy++; fieldPanel.add(new JLabel("DAC:"), gbc); gbc.gridx = 1; fieldPanel.add(dacField, gbc);
        gbc.gridx = 0; gbc.gridy++; fieldPanel.add(new JLabel("User ID:"), gbc); gbc.gridx = 1; fieldPanel.add(userSpinner, gbc);
        gbc.gridx = 0; gbc.gridy++; fieldPanel.add(new JLabel("Password:"), gbc); gbc.gridx = 1; fieldPanel.add(passField, gbc);
        gbc.gridx = 1; gbc.gridy++; fieldPanel.add(showPass, gbc);

        JPanel rightPanel = new JPanel(new BorderLayout(5, 5));
        rightPanel.add(new JLabel("Saved Connections:"), BorderLayout.NORTH);
        rightPanel.add(new JScrollPane(interfaceList), BorderLayout.CENTER);

        mainPanel.add(fieldPanel, BorderLayout.CENTER); mainPanel.add(rightPanel, BorderLayout.EAST);

        if (JOptionPane.showConfirmDialog(this, mainPanel, "Connect", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
            String ip = ipField.getText(); String localIp = (String) localIpCombo.getSelectedItem();
            KnxBusManager.ConnectionType type = (KnxBusManager.ConnectionType) typeCombo.getSelectedItem();
            String dac = new String(dacField.getPassword()); int uid = (Integer) userSpinner.getValue();
            String pass = new String(passField.getPassword());
            new Thread(() -> {
                try {
                    busManager.connect(ip, localIp, type, dac, uid, pass);
                    SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, "Connected!"));
                } catch (Exception ex) { logger.error("Connect failed", ex); }
            }).start();
        }
    }

    private void importKeyringAction() {
        JFileChooser fc = new JFileChooser();
        fc.setFileFilter(new FileNameExtensionFilter("KNX Keyring (.knxkeys)", "knxkeys"));
        if (fc.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
            try {
                JPasswordField pf = new JPasswordField();
                if (JOptionPane.showConfirmDialog(this, pf, "Keyring Password", JOptionPane.OK_CANCEL_OPTION) == JOptionPane.OK_OPTION) {
                    currentKeyring = keyringReader.readKeyring(fc.getSelectedFile().toPath(), pf.getPassword());
                    if (currentKeyring.getInterfaces() != null) {
                        for (KnxKeyring.Interface iface : currentKeyring.getInterfaces()) {
                            SavedInterface nsi = new SavedInterface();
                            nsi.name = "Keyring: " + iface.address; nsi.ip = "192.168.1.120";
                            nsi.type = KnxBusManager.ConnectionType.SECURE_TUNNEL_TCP;
                            nsi.userId = iface.userId; nsi.password = iface.password;
                            if (iface.host != null && currentKeyring.getDevices() != null) {
                                for (KnxKeyring.Device d : currentKeyring.getDevices().deviceList) {
                                    if (iface.host.equals(d.address)) { nsi.dac = (d.authentication != null ? d.authentication : d.fdsk); break; }
                                }
                            }
                            if (nsi.dac == null) nsi.dac = iface.authentication;
                            savedInterfaces.add(nsi);
                        }
                    }
                    JOptionPane.showMessageDialog(this, "Imported!");
                }
            } catch (Exception ex) { logger.error("Import failed", ex); }
        }
    }

    public static void main(String[] args) {
        try { UIManager.setLookAndFeel(new com.formdev.flatlaf.FlatDarculaLaf()); } catch (Exception ignored) {}
        SwingUtilities.invokeLater(() -> new Jets().setVisible(true));
    }
}
