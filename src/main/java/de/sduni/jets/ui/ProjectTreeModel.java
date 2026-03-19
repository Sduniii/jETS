package de.sduni.jets.ui;

import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;
import java.util.ArrayList;
import java.util.List;

public class ProjectTreeModel implements TreeModel {

    private final ProjectTreeNode root;
    private final List<TreeModelListener> listeners = new ArrayList<>();

    public ProjectTreeModel(ProjectTreeNode root) {
        this.root = root;
    }

    @Override
    public Object getRoot() {
        return root;
    }

    @Override
    public Object getChild(Object parent, int index) {
        if (parent instanceof ProjectTreeNode) {
            return ((ProjectTreeNode) parent).getChildren().get(index);
        }
        return null;
    }

    @Override
    public int getChildCount(Object parent) {
        if (parent instanceof ProjectTreeNode) {
            return ((ProjectTreeNode) parent).getChildren().size();
        }
        return 0;
    }

    @Override
    public boolean isLeaf(Object node) {
        return getChildCount(node) == 0;
    }

    @Override
    public void valueForPathChanged(TreePath path, Object newValue) {
        // Not editable yet
    }

    @Override
    public int getIndexOfChild(Object parent, Object child) {
        if (parent instanceof ProjectTreeNode && child instanceof ProjectTreeNode) {
            return ((ProjectTreeNode) parent).getChildren().indexOf(child);
        }
        return -1;
    }

    @Override
    public void addTreeModelListener(TreeModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTreeModelListener(TreeModelListener l) {
        listeners.remove(l);
    }

    public void reload(ProjectTreeNode node) {
        if (node != null) {
            node.reload(); // clear cached children
            TreeModelEvent event = new TreeModelEvent(this, getPathToRoot(node, 0));
            for (TreeModelListener listener : listeners) {
                listener.treeStructureChanged(event);
            }
        }
    }

    private Object[] getPathToRoot(ProjectTreeNode node, int depth) {
        // Simplified path generation: only accurate for direct updates if we track parents.
        // For now, since we rebuild, returning just the root path or full refresh works if we pass root.
        return new Object[]{root};
    }
}

