package de.sduni.jets.ui;

import de.sduni.jets.Jets;
import de.sduni.jets.model.v20.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Modern Stateful Parameter Form following the Master-Detail layout.
 * Implements Conditional Rendering based on <choose>/<when> logic.
 */
public class ParameterFormPanel extends JPanel {
    private static final Logger logger = LoggerFactory.getLogger(ParameterFormPanel.class);

    private final DeviceInstance device;
    private final ApplicationProgram ap;
    private final ParameterState state;
    
    private JPanel sidebar;
    private JPanel detailArea;
    private JLabel detailHeader;
    private JPanel formContainer;
    private Object selectedMenuItem;
    private final Map<Object, JButton> menuButtons = new LinkedHashMap<>();

    public ParameterFormPanel(DeviceInstance di) {
        this.device = di;
        this.state = new ParameterState(di);
        this.ap = Jets.currentContext.findApplicationProgram(di.getHardware2ProgramRefId());
        
        setLayout(new BorderLayout());
        setBackground(new Color(30, 30, 30));
        
        if (ap == null || ap.getDynamic() == null) {
            JLabel msg = new JLabel("No dynamic parameter structure available for this device.");
            msg.setForeground(Color.GRAY);
            msg.setHorizontalAlignment(JLabel.CENTER);
            add(msg, BorderLayout.CENTER);
            return;
        }

        setupLayout();
        state.addListener(id -> {
            logger.debug("State updated for {}, rebuilding form...", id);
            rebuildForm();
        });
    }

    private void setupLayout() {
        // Sidebar (Master)
        sidebar = new JPanel();
        sidebar.setLayout(new BoxLayout(sidebar, BoxLayout.Y_AXIS));
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(new Color(45, 45, 48));
        sidebar.setBorder(new EmptyBorder(10, 0, 10, 0));

        buildMenu();

        // Detail Area
        detailArea = new JPanel(new BorderLayout());
        detailArea.setBackground(new Color(30, 30, 30));

        // Detail Header
        detailHeader = new JLabel(" Select a category");
        detailHeader.setFont(new Font("SansSerif", Font.BOLD, 22));
        detailHeader.setForeground(Color.WHITE);
        detailHeader.setBorder(new EmptyBorder(20, 25, 10, 25));
        
        JPanel headerWrapper = new JPanel(new BorderLayout());
        headerWrapper.setBackground(new Color(30, 30, 30));
        headerWrapper.add(detailHeader, BorderLayout.WEST);
        
        JSeparator sep = new JSeparator();
        sep.setForeground(new Color(60, 60, 60));
        headerWrapper.add(sep, BorderLayout.SOUTH);
        
        detailArea.add(headerWrapper, BorderLayout.NORTH);

        // Form Container
        formContainer = new JPanel(new BorderLayout());
        formContainer.setBackground(new Color(30, 30, 30));
        JScrollPane scroll = new JScrollPane(formContainer);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        detailArea.add(scroll, BorderLayout.CENTER);

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sidebar, detailArea);
        split.setDividerLocation(220);
        split.setDividerSize(1);
        split.setBorder(null);
        add(split, BorderLayout.CENTER);

        // Select first item
        if (!menuButtons.isEmpty()) {
            selectMenuItem(menuButtons.keySet().iterator().next());
        }
    }

    private void buildMenu() {
        if (ap.getDynamic() == null) return;
        
        for (ApplicationProgramChannel ch : ap.getDynamic().getChannel()) {
            addMenuButton(ch.getText() != null ? ch.getText() : ch.getName(), ch);
        }
        for (ComObjectParameterBlock pb : ap.getDynamic().getParameterBlock()) {
            addMenuButton(pb.getText() != null ? pb.getText() : pb.getName(), pb);
        }
    }

    private void addMenuButton(String text, Object item) {
        JButton btn = new JButton(text);
        btn.setAlignmentX(Component.LEFT_ALIGNMENT);
        btn.setMaximumSize(new Dimension(Integer.MAX_VALUE, 35));
        btn.setFocusPainted(false);
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setForeground(new Color(180, 180, 180));
        btn.setHorizontalAlignment(SwingConstants.LEFT);
        btn.setMargin(new Insets(0, 20, 0, 0));
        btn.setFont(new Font("SansSerif", Font.PLAIN, 13));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        btn.addActionListener(e -> selectMenuItem(item));
        sidebar.add(btn);
        menuButtons.put(item, btn);
    }

    private void selectMenuItem(Object item) {
        this.selectedMenuItem = item;
        
        // Highlight active button
        menuButtons.values().forEach(b -> {
            b.setForeground(new Color(180, 180, 180));
            b.setOpaque(false);
            b.setBackground(null);
        });
        JButton active = menuButtons.get(item);
        if (active != null) {
            active.setForeground(Color.WHITE);
            active.setOpaque(true);
            active.setBackground(new Color(60, 60, 60));
        }

        // Set Header
        String title = "Parameters";
        if (item instanceof ApplicationProgramChannel) title = ((ApplicationProgramChannel)item).getText();
        else if (item instanceof ComObjectParameterBlock) title = ((ComObjectParameterBlock)item).getText();
        detailHeader.setText(title);

        rebuildForm();
    }

    private void rebuildForm() {
        formContainer.removeAll();
        
        JPanel form = new JPanel(new GridBagLayout());
        form.setBackground(new Color(30, 30, 30));
        form.setBorder(new EmptyBorder(10, 25, 30, 25));
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(8, 0, 8, 0);
        gbc.gridy = 0;

        renderDynamicContainer(selectedMenuItem, form, gbc);

        // Add glue at bottom
        gbc.weighty = 1.0;
        form.add(Box.createVerticalGlue(), gbc);

        formContainer.add(form, BorderLayout.NORTH);
        formContainer.revalidate();
        formContainer.repaint();
    }

    private void renderDynamicContainer(Object container, JPanel form, GridBagConstraints gbc) {
        if (container instanceof ApplicationProgramChannel) {
            ApplicationProgramChannel ch = (ApplicationProgramChannel) container;
            for (ComObjectParameterBlock pb : ch.getParameterBlock()) renderDynamicContainer(pb, form, gbc);
            for (ChannelChoose c : ch.getChoose()) evalChoose(c, form, gbc);
        } else if (container instanceof ComObjectParameterBlock) {
            ComObjectParameterBlock pb = (ComObjectParameterBlock) container;
            
            if (pb.getText() != null && !pb.getText().isEmpty()) {
                addSeparator(form, gbc, pb.getText().toUpperCase());
            }

            for (ParameterRefRef prr : pb.getParameterRefRef()) renderParameter(prr.getRefId(), form, gbc);
            for (ChannelChoose c : pb.getChoose()) evalChoose(c, form, gbc);
        }
    }

    private void addSeparator(JPanel form, GridBagConstraints gbc, String text) {
        gbc.gridx = 0; gbc.gridwidth = 2; gbc.weightx = 1.0;
        JLabel l = new JLabel(text);
        l.setFont(l.getFont().deriveFont(Font.BOLD, 11f));
        l.setForeground(new Color(0, 122, 204));
        l.setBorder(new EmptyBorder(15, 0, 5, 0));
        form.add(l, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1; // reset
    }

    private void evalChoose(ChannelChoose c, JPanel form, GridBagConstraints gbc) {
        String currentVal = state.getValue(c.getParamRefId());
        if (currentVal == null) return;

        for (ChannelChoose_when when : c.getWhen()) {
            if (currentVal.equals(when.getTest())) {
                for (ParameterRefRef prr : when.getParameterRefRef()) renderParameter(prr.getRefId(), form, gbc);
                for (ComObjectParameterBlock pb : when.getParameterBlock()) renderDynamicContainer(pb, form, gbc);
                for (ChannelChoose nested : when.getChoose()) evalChoose(nested, form, gbc);
            }
        }
    }

    private void renderParameter(String refId, JPanel form, GridBagConstraints gbc) {
        String name = Jets.currentContext.findParameterText(device, refId);
        String value = state.getValue(refId);
        
        ApplicationProgramStatic_Parameters_Parameter pDef = resolveParameterDefinition(refId);
        if (pDef == null) {
            logger.warn("Could not resolve definition for parameter {}", refId);
            return;
        }

        // Label
        gbc.gridx = 0; gbc.weightx = 0.0;
        gbc.anchor = GridBagConstraints.WEST;
        JLabel label = new JLabel(name != null ? name : pDef.getName());
        label.setPreferredSize(new Dimension(350, 25));
        label.setForeground(new Color(220, 220, 220));
        form.add(label, gbc);

        // Control
        gbc.gridx = 1; gbc.weightx = 1.0;
        JComponent control = createControl(refId, pDef, value);
        form.add(control, gbc);
        
        gbc.gridy++;
    }

    private ApplicationProgramStatic_Parameters_Parameter resolveParameterDefinition(String id) {
        if (id == null) return null;
        String baseId = id.contains("_R-") ? id.substring(0, id.lastIndexOf("_R-")) : id;

        // 1. Check direct Parameters
        if (ap.getStatic().getParameters() != null) {
            for (ApplicationProgramStatic_Parameters_Parameter p : ap.getStatic().getParameters().getParameter()) {
                if (baseId.equals(p.getId())) return p;
            }
        }

        // 2. Check ParameterRefs (Indirections)
        if (ap.getStatic().getParameterRefs() != null) {
            for (ParameterRef ref : ap.getStatic().getParameterRefs().getParameterRef()) {
                if (baseId.equals(ref.getId())) {
                    // Recurse to follow RefId
                    return resolveParameterDefinition(ref.getRefId());
                }
            }
        }
        
        // 3. Check in ID map as fallback
        Object found = Jets.currentContext.findById(baseId);
        if (found instanceof ApplicationProgramStatic_Parameters_Parameter) return (ApplicationProgramStatic_Parameters_Parameter) found;

        return null;
    }

    private JComponent createControl(String refId, ApplicationProgramStatic_Parameters_Parameter pDef, String value) {
        ParameterType type = findType(pDef.getParameterType());

        if (type != null && type.getTypeRestriction() != null && !type.getTypeRestriction().getEnumeration().isEmpty()) {
            List<ParameterType_TypeRestriction_Enumeration> enums = type.getTypeRestriction().getEnumeration();
            JComboBox<ParameterType_TypeRestriction_Enumeration> combo = new JComboBox<>(enums.toArray(new ParameterType_TypeRestriction_Enumeration[0]));
            
            combo.setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object val, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, val, index, isSelected, cellHasFocus);
                    if (val instanceof ParameterType_TypeRestriction_Enumeration) {
                        setText(((ParameterType_TypeRestriction_Enumeration) val).getText());
                    }
                    return this;
                }
            });

            try {
                long currentVal = Long.parseLong(value != null ? value : "0");
                for (int i = 0; i < enums.size(); i++) {
                    if (enums.get(i).getValue() == currentVal) { combo.setSelectedIndex(i); break; }
                }
            } catch (Exception ignored) {}

            combo.addActionListener(e -> {
                ParameterType_TypeRestriction_Enumeration selected = (ParameterType_TypeRestriction_Enumeration) combo.getSelectedItem();
                if (selected != null) state.setValue(refId, String.valueOf(selected.getValue()));
            });
            
            return combo;
        } else if (type != null && type.getTypeNumber() != null) {
            ParameterType_TypeNumber num = type.getTypeNumber();
            String suffix = pDef.getSuffixText() != null ? " " + pDef.getSuffixText() : "";
            String range = " [" + num.getminInclusive() + "..." + num.getmaxInclusive() + "]";
            
            JPanel p = new JPanel(new BorderLayout(5, 0));
            p.setOpaque(false);
            
            long startVal = 0;
            try { startVal = Long.parseLong(value != null ? value : "0"); } catch (Exception ignored) {}
            
            JSpinner spinner = new JSpinner(new SpinnerNumberModel(
                startVal, 
                num.getminInclusive(), num.getmaxInclusive(), 1));
            
            spinner.addChangeListener(e -> state.setValue(refId, String.valueOf(spinner.getValue())));
            
            p.add(spinner, BorderLayout.CENTER);
            p.add(new JLabel(suffix + range) {{ setForeground(Color.GRAY); }}, BorderLayout.EAST);
            return p;
        } else {
            JTextField field = new JTextField(value != null ? value : "");
            field.setPreferredSize(new Dimension(150, 25));
            field.addFocusListener(new java.awt.event.FocusAdapter() {
                @Override
                public void focusLost(java.awt.event.FocusEvent e) {
                    state.setValue(refId, field.getText());
                }
            });
            return field;
        }
    }

    private ParameterType findType(String id) {
        if (id == null || ap.getStatic().getParameterTypes() == null) return null;
        for (ParameterType t : ap.getStatic().getParameterTypes().getParameterType()) {
            if (id.equals(t.getId())) return t;
        }
        return null;
    }
}
