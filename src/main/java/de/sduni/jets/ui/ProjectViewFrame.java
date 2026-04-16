package de.sduni.jets.ui;

import de.sduni.jets.model.v20.GroupAddress;
import de.sduni.jets.model.v20.ComObjectInstanceRef;
import javax.swing.*;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;

public class ProjectViewFrame extends JInternalFrame {

    private JTree tree;
    private JPanel detailContainer;

    public ProjectViewFrame(String title, Object rootObj) {
        super(title, true, true, true, true);
        setSize(1000, 700);
        setLayout(new BorderLayout());

        ProjectTreeNode rootNode = new ProjectTreeNode("Root", rootObj);
        ProjectTreeModel treeModel = new ProjectTreeModel(rootNode);
        tree = new JTree(treeModel);
        
        detailContainer = new JPanel(new BorderLayout());
        detailContainer.add(new JLabel("Select an item to see details", JLabel.CENTER), BorderLayout.CENTER);
        
        tree.addTreeSelectionListener(e -> {
            ProjectTreeNode node = (ProjectTreeNode) tree.getLastSelectedPathComponent();
            if (node != null) {
                updateDetailView(node.getUserObject());
            }
        });

        // Setup Drag & Drop
        tree.setDragEnabled(true);
        tree.setDropMode(DropMode.ON);
        tree.setTransferHandler(new TreeTransferHandler());

        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(tree), detailContainer);
        split.setDividerLocation(300);
        add(split, BorderLayout.CENTER);
    }

    private void updateDetailView(Object obj) {
        detailContainer.removeAll();
        if (obj instanceof de.sduni.jets.model.v20.DeviceInstance) {
            detailContainer.add(new DeviceDetailPanel((de.sduni.jets.model.v20.DeviceInstance) obj), BorderLayout.CENTER);
        } else {
            JTable table = new JTable(new ProjectTableModel(obj));
            detailContainer.add(new JScrollPane(table), BorderLayout.CENTER);
        }
        detailContainer.revalidate();
        detailContainer.repaint();
    }

    private class TreeTransferHandler extends TransferHandler {
        @Override
        public int getSourceActions(JComponent c) {
            return COPY;
        }

        @Override
        protected Transferable createTransferable(JComponent c) {
            JTree tree = (JTree) c;
            TreePath path = tree.getSelectionPath();
            if (path != null) {
                ProjectTreeNode node = (ProjectTreeNode) path.getLastPathComponent();
                if (node.getUserObject() instanceof ComObjectInstanceRef) {
                    ComObjectInstanceRef co = (ComObjectInstanceRef) node.getUserObject();
                    return new StringSelection("CO:" + co.getRefId());
                }
            }
            return null;
        }

        @Override
        public boolean canImport(TransferSupport support) {
            if (!support.isDataFlavorSupported(DataFlavor.stringFlavor)) return false;
            JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
            TreePath path = dl.getPath();
            if (path == null) return false;
            ProjectTreeNode node = (ProjectTreeNode) path.getLastPathComponent();
            return node.getUserObject() instanceof GroupAddress;
        }

        @Override
        public boolean importData(TransferSupport support) {
            if (!canImport(support)) return false;
            try {
                String data = (String) support.getTransferable().getTransferData(DataFlavor.stringFlavor);
                JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
                ProjectTreeNode destNode = (ProjectTreeNode) dl.getPath().getLastPathComponent();
                GroupAddress ga = (GroupAddress) destNode.getUserObject();
                
                if (data.startsWith("CO:")) {
                    String coId = data.substring(3);
                    JOptionPane.showMessageDialog(ProjectViewFrame.this, 
                        "Linked CO " + coId + " to Group Address " + ga.getName());
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return false;
        }
    }
}
