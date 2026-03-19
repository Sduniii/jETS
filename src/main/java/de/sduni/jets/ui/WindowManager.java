package de.sduni.jets.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.beans.PropertyVetoException;
import java.util.ArrayList;
import java.util.List;

public class WindowManager {

    public enum LayoutMode {
        FLOATING, TILING, SNAPPING
    }

    private final JDesktopPane desktop;
    private LayoutMode currentMode = LayoutMode.FLOATING;
    private boolean isUpdating = false;

    public WindowManager(JDesktopPane desktop) {
        this.desktop = desktop;
        
        // Listener for desktop resizes to update tiling
        this.desktop.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                if (currentMode == LayoutMode.TILING) {
                    applyTiling();
                }
            }
        });

        // Set custom desktop manager for snapping
        this.desktop.setDesktopManager(new SnappingDesktopManager(this));
    }

    public void setLayoutMode(LayoutMode mode) {
        this.currentMode = mode;
        if (mode == LayoutMode.TILING) {
            applyTiling();
        }
    }

    public LayoutMode getCurrentMode() {
        return currentMode;
    }

    public void applyTiling() {
        if (isUpdating) return;
        isUpdating = true;
        
        JInternalFrame[] frames = getAllVisibleFrames();
        if (frames.length == 0) {
            isUpdating = false;
            return;
        }

        int w = desktop.getWidth();
        int h = desktop.getHeight();

        try {
            switch (frames.length) {
                case 1:
                    setFrameBounds(frames[0], 0, 0, w, h);
                    break;
                case 2:
                    setFrameBounds(frames[0], 0, 0, w / 2, h);
                    setFrameBounds(frames[1], w / 2, 0, w / 2, h);
                    break;
                case 3:
                    setFrameBounds(frames[0], 0, 0, w / 2, h);
                    setFrameBounds(frames[1], w / 2, 0, w / 2, h / 2);
                    setFrameBounds(frames[2], w / 2, h / 2, w / 2, h / 2);
                    break;
                default:
                    // Grid for 4+ windows
                    int cols = (int) Math.ceil(Math.sqrt(frames.length));
                    int rows = (int) Math.ceil((double) frames.length / cols);
                    int fw = w / cols;
                    int fh = h / rows;
                    for (int i = 0; i < frames.length; i++) {
                        int r = i / cols;
                        int c = i % cols;
                        setFrameBounds(frames[i], c * fw, r * fh, fw, fh);
                    }
                    break;
            }
        } catch (Exception ignored) {}

        isUpdating = false;
    }

    private void setFrameBounds(JInternalFrame f, int x, int y, int w, int h) throws PropertyVetoException {
        if (f.isMaximum()) f.setMaximum(false);
        if (f.isIcon()) f.setIcon(false);
        f.setBounds(x, y, w, h);
    }

    public JInternalFrame[] getAllVisibleFrames() {
        List<JInternalFrame> visible = new ArrayList<>();
        for (JInternalFrame f : desktop.getAllFrames()) {
            if (f.isVisible()) visible.add(f);
        }
        return visible.toArray(new JInternalFrame[0]);
    }

    private static class SnappingDesktopManager extends DefaultDesktopManager {
        private final WindowManager wm;
        private static final int SNAP_MARGIN = 20;

        public SnappingDesktopManager(WindowManager wm) {
            this.wm = wm;
        }

        @Override
        public void dragFrame(JComponent f, int x, int y) {
            if (wm.getCurrentMode() != LayoutMode.SNAPPING) {
                super.dragFrame(f, x, y);
                return;
            }

            int dw = wm.desktop.getWidth();
            int dh = wm.desktop.getHeight();

            // Simple snapping preview logic (could be improved with a ghost rectangle)
            super.dragFrame(f, x, y);
        }

        @Override
        public void endDraggingFrame(JComponent f) {
            super.endDraggingFrame(f);
            if (wm.getCurrentMode() != LayoutMode.SNAPPING || !(f instanceof JInternalFrame)) return;

            JInternalFrame frame = (JInternalFrame) f;
            int x = frame.getX();
            int y = frame.getY();
            int dw = wm.desktop.getWidth();
            int dh = wm.desktop.getHeight();

            try {
                // Snapping Zones
                if (x < SNAP_MARGIN) { // Left Half
                    frame.setBounds(0, 0, dw / 2, dh);
                } else if (x + frame.getWidth() > dw - SNAP_MARGIN) { // Right Half
                    frame.setBounds(dw / 2, 0, dw / 2, dh);
                } else if (y < SNAP_MARGIN) { // Top (Maximize suggestion or top half)
                    frame.setBounds(0, 0, dw, dh / 2);
                }
            } catch (Exception ignored) {}
        }
    }
}
