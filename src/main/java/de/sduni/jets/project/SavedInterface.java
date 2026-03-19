package de.sduni.jets.project;

import de.sduni.jets.knx.KnxBusManager;

public class SavedInterface {
    public String name;
    public String ip;
    public KnxBusManager.ConnectionType type;
    public String dac;
    public int userId;
    public String password;

    @Override
    public String toString() {
        return name != null ? name : ip;
    }
}
