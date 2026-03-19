package de.sduni.jets.project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import de.sduni.jets.model.v20.KNX;
import de.sduni.jets.model.secure.KnxKeyring;
import de.sduni.jets.ui.WindowManager;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class JetsWorkspace {

    private KNX project;
    private KnxKeyring keyring;
    private List<SavedInterface> savedInterfaces = new ArrayList<>();
    
    // UI State
    private WindowManager.LayoutMode layoutMode = WindowManager.LayoutMode.FLOATING;
    private List<WindowMetadata> openWindows = new ArrayList<>();

    public KNX getProject() { return project; }
    public void setProject(KNX project) { this.project = project; }

    public KnxKeyring getKeyring() { return keyring; }
    public void setKeyring(KnxKeyring keyring) { this.keyring = keyring; }

    public List<SavedInterface> getSavedInterfaces() { return savedInterfaces; }
    public void setSavedInterfaces(List<SavedInterface> savedInterfaces) { this.savedInterfaces = savedInterfaces; }

    public WindowManager.LayoutMode getLayoutMode() { return layoutMode; }
    public void setLayoutMode(WindowManager.LayoutMode layoutMode) { this.layoutMode = layoutMode; }

    public List<WindowMetadata> getOpenWindows() { return openWindows; }
    public void setOpenWindows(List<WindowMetadata> openWindows) { this.openWindows = openWindows; }

    public static class WindowMetadata {
        public String type; 
        public String title;
        public int x, y, width, height;
        public boolean isIcon, isMaximized;

        public WindowMetadata() {}
        public WindowMetadata(String type, String title, int x, int y, int w, int h) {
            this.type = type; this.title = title;
            this.x = x; this.y = y; this.width = w; this.height = h;
        }
    }
}
