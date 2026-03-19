package de.sduni.jets.knx;

import tuwien.auto.calimero.knxnetip.SecureConnection;
import tuwien.auto.calimero.knxnetip.TcpConnection;
import tuwien.auto.calimero.link.KNXNetworkLink;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.medium.TPSettings;
import java.net.InetSocketAddress;
import java.util.Base64;

public class CalimeroTest {
    public static void main(String[] args) {
        String targetIp = "192......";
        String userPassStr = "test";
        String dacStr = "test";
        int uid = 3;

        System.out.println("=== Starting FINAL SUCCESS TEST (User 3 via TCP) ===");
        InetSocketAddress remote = new InetSocketAddress(targetIp, 3671);

        try {
            // Hash correctly
            byte[] userKey = SecureConnection.hashUserPassword(userPassStr.toCharArray());
            byte[] dacKey = SecureConnection.hashDeviceAuthenticationPassword(dacStr.toCharArray());

            System.out.println("  Opening TCP to " + targetIp + "...");
            try (TcpConnection tcp = TcpConnection.newTcpConnection(remote)) {
                System.out.println("  TCP Socket open. Requesting Secure Session for User " + uid + "...");
                try (TcpConnection.SecureSession session = tcp.newSecureSession(uid, userKey, dacKey)) {
                    System.out.println("  SECURE SESSION ESTABLISHED!!!");
                    try (KNXNetworkLink link = KNXNetworkLinkIP.newSecureTunnelingLink(session, new TPSettings())) {
                        System.out.println("  SUCCESS!!! KNX TUNNEL IS OPEN AND SECURE.");
                        System.exit(0);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("  FAILED: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
