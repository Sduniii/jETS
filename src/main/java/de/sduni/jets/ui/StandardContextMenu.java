package de.sduni.jets.ui;

import javax.swing.*;
import javax.swing.text.JTextComponent;
import java.awt.*;
import java.awt.event.AWTEventListener;
import java.awt.event.MouseEvent;

public class StandardContextMenu {

    public static void install() {
        Toolkit.getDefaultToolkit().addAWTEventListener(new AWTEventListener() {
            @Override
            public void eventDispatched(AWTEvent event) {
                if (event instanceof MouseEvent) {
                    MouseEvent me = (MouseEvent) event;
                    if (me.isPopupTrigger()) {
                        Component c = SwingUtilities.getDeepestComponentAt(me.getComponent(), me.getX(), me.getY());
                        if (c instanceof JTextComponent) {
                            showMenu(me, (JTextComponent) c);
                        }
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);
    }

    private static void showMenu(MouseEvent me, JTextComponent textComponent) {
        JPopupMenu menu = new JPopupMenu();

        Action cutAction = textComponent.getActionMap().get("cut");
        Action copyAction = textComponent.getActionMap().get("copy");
        Action pasteAction = textComponent.getActionMap().get("paste");
        Action selectAllAction = textComponent.getActionMap().get("select-all");

        if (cutAction != null) {
            JMenuItem item = new JMenuItem("Cut");
            item.addActionListener(e -> textComponent.cut());
            item.setEnabled(textComponent.isEditable() && textComponent.isEnabled() && textComponent.getSelectedText() != null);
            menu.add(item);
        }

        if (copyAction != null) {
            JMenuItem item = new JMenuItem("Copy");
            item.addActionListener(e -> textComponent.copy());
            item.setEnabled(textComponent.getSelectedText() != null);
            menu.add(item);
        }

        if (pasteAction != null) {
            JMenuItem item = new JMenuItem("Paste");
            item.addActionListener(e -> textComponent.paste());
            item.setEnabled(textComponent.isEditable() && textComponent.isEnabled());
            menu.add(item);
        }

        menu.addSeparator();

        if (selectAllAction != null) {
            JMenuItem item = new JMenuItem("Select All");
            item.addActionListener(e -> textComponent.selectAll());
            item.setEnabled(textComponent.isEnabled() && textComponent.getText().length() > 0);
            menu.add(item);
        }

        if (menu.getComponentCount() > 0) {
            menu.show(textComponent, me.getX(), me.getY());
        }
    }
}
