package de.sduni.jets.util;

/**
 * Utility for converting KNX addresses between integer and string representations.
 */
public class KnxAddressUtil {

    /**
     * Converts a 16-bit integer address to a physical address string (Area.Line.Device).
     * Format: 4 bits Area, 4 bits Line, 8 bits Device (X.Y.Z)
     */
    public static String toPhysicalAddress(int address) {
        int area = (address >> 12) & 0x0F;
        int line = (address >> 8) & 0x0F;
        int device = address & 0xFF;
        return area + "." + line + "." + device;
    }

    /**
     * Converts a physical address string (X.Y.Z) to a 16-bit integer.
     */
    public static int fromPhysicalAddress(String address) {
        String[] parts = address.split("\\.");
        if (parts.length != 3) throw new IllegalArgumentException("Invalid physical address format: " + address);
        int area = Integer.parseInt(parts[0]);
        int line = Integer.parseInt(parts[1]);
        int device = Integer.parseInt(parts[2]);
        return (area << 12) | (line << 8) | device;
    }

    /**
     * Converts a 16-bit integer group address to a 3-level string (Main/Middle/Sub).
     * Format: 5 bits Main, 3 bits Middle, 8 bits Sub (X/Y/Z)
     */
    public static String toGroupAddress3Level(int address) {
        int main = (address >> 11) & 0x1F;
        int middle = (address >> 8) & 0x07;
        int sub = address & 0xFF;
        return main + "/" + middle + "/" + sub;
    }

    /**
     * Converts a 16-bit integer group address to a 2-level string (Main/Sub).
     * Format: 5 bits Main, 11 bits Sub (X/Y)
     */
    public static String toGroupAddress2Level(int address) {
        int main = (address >> 11) & 0x1F;
        int sub = address & 0x7FF;
        return main + "/" + sub;
    }

    /**
     * Converts a group address string (X/Y or X/Y/Z) to a 16-bit integer.
     */
    public static int fromGroupAddress(String address) {
        String[] parts = address.split("/");
        if (parts.length == 3) {
            int main = Integer.parseInt(parts[0]);
            int middle = Integer.parseInt(parts[1]);
            int sub = Integer.parseInt(parts[2]);
            return (main << 11) | (middle << 8) | sub;
        } else if (parts.length == 2) {
            int main = Integer.parseInt(parts[0]);
            int sub = Integer.parseInt(parts[1]);
            return (main << 11) | sub;
        }
        throw new IllegalArgumentException("Invalid group address format: " + address);
    }
}
