package de.sduni.jets.knx;

import tuwien.auto.calimero.CloseEvent;
import tuwien.auto.calimero.FrameEvent;
import tuwien.auto.calimero.KNXException;
import tuwien.auto.calimero.GroupAddress;
import tuwien.auto.calimero.datapoint.Datapoint;
import tuwien.auto.calimero.datapoint.StateDP;
import tuwien.auto.calimero.dptxlator.DPTXlator8BitUnsigned;
import tuwien.auto.calimero.dptxlator.DPTXlator2ByteFloat;
import tuwien.auto.calimero.link.KNXNetworkLink;
import tuwien.auto.calimero.link.KNXNetworkLinkIP;
import tuwien.auto.calimero.link.NetworkLinkListener;
import tuwien.auto.calimero.link.medium.TPSettings;
import tuwien.auto.calimero.process.ProcessCommunicator;
import tuwien.auto.calimero.process.ProcessCommunicatorImpl;
import tuwien.auto.calimero.knxnetip.Discoverer;
import tuwien.auto.calimero.knxnetip.SecureConnection;
import tuwien.auto.calimero.knxnetip.TcpConnection;
import tuwien.auto.calimero.knxnetip.servicetype.SearchResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.InetSocketAddress;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class KnxBusManager {
    private static final Logger logger = LoggerFactory.getLogger(KnxBusManager.class);

    public enum ConnectionType {
        TUNNEL_UDP, TUNNEL_TCP, SECURE_TUNNEL_UDP, SECURE_TUNNEL_TCP, ROUTING
    }

    private KNXNetworkLink link;
    private ProcessCommunicator pc;
    private final List<Consumer<FrameEvent>> listeners = new ArrayList<>();

    public void connect(String ipAddress, String localIp, ConnectionType type, String dac, int userId, String password) throws KNXException, InterruptedException {
        if (link != null) disconnect();

        logger.info("Connecting to {} (Type: {}, User: {})", ipAddress, type, userId);

        InetSocketAddress remote = new InetSocketAddress(ipAddress, 3671);
        InetSocketAddress local = (localIp == null || localIp.isEmpty()) ? new InetSocketAddress(0) : new InetSocketAddress(localIp, 0);

        try {
            switch (type) {
                case SECURE_TUNNEL_TCP:
                    logger.info("Using specialized TCP handshake logic...");
                    byte[] uKey = SecureConnection.hashUserPassword(password.toCharArray());
                    byte[] dKey = SecureConnection.hashDeviceAuthenticationPassword(dac.toCharArray());
                    
                    TcpConnection tcp = TcpConnection.newTcpConnection(remote);
                    TcpConnection.SecureSession session = tcp.newSecureSession(userId, uKey, dKey);
                    link = KNXNetworkLinkIP.newSecureTunnelingLink(session, TPSettings.TP1);
                    break;

                case SECURE_TUNNEL_UDP:
                    byte[] uKeyUdp = SecureConnection.hashUserPassword(password.toCharArray());
                    byte[] dKeyUdp = SecureConnection.hashDeviceAuthenticationPassword(dac.toCharArray());
                    link = KNXNetworkLinkIP.newSecureTunnelingLink(local, remote, false, dKeyUdp, userId, uKeyUdp, TPSettings.TP1);
                    break;

                case TUNNEL_TCP:
                    link = KNXNetworkLinkIP.newTunnelingLink(local, remote, true, TPSettings.TP1);
                    break;

                case ROUTING:
                    link = KNXNetworkLinkIP.newRoutingLink(local.getAddress(), remote.getAddress(), TPSettings.TP1);
                    break;

                default:
                    link = KNXNetworkLinkIP.newTunnelingLink(local, remote, false, TPSettings.TP1);
                    break;
            }

            pc = new ProcessCommunicatorImpl(link);
            link.addLinkListener(new NetworkLinkListener() {
                @Override public void confirmation(FrameEvent e) { notifyListeners(e); }
                @Override public void indication(FrameEvent e) { notifyListeners(e); }
                @Override public void linkClosed(CloseEvent e) { logger.info("KNX Link closed: {}", e.getReason()); }
            });
            logger.info("Connection established successfully.");

        } catch (Exception e) {
            logger.error("Connection attempt failed", e);
            throw new KNXException(e.getMessage());
        }
    }

    public List<String> discover() {
        List<String> found = new ArrayList<>();
        try {
            Discoverer d = new Discoverer(0, false);
            d.startSearch(1, true);
            for (Discoverer.Result<SearchResponse> res : d.getSearchResponses()) {
                SearchResponse sr = res.getResponse();
                found.add(sr.getControlEndpoint().getAddress().getHostAddress() + " (" + sr.getDevice().getName() + ")");
            }
        } catch (Exception e) { logger.error("Discovery failed", e); }
        return found;
    }

    public void disconnect() {
        if (pc != null) pc.detach();
        if (link != null) link.close();
        pc = null;
        link = null;
    }

    public void writeGroupValue(String groupAddress, boolean value) throws KNXException, InterruptedException {
        if (pc == null) throw new KNXException("Not connected");
        pc.write(new GroupAddress(groupAddress), value);
    }

    public void writeGroupValue(String groupAddress, int value) throws KNXException, InterruptedException {
        if (pc == null) throw new KNXException("Not connected");
        pc.write(new StateDP(new GroupAddress(groupAddress), "tmp", 0, DPTXlator8BitUnsigned.DPT_SCALING.getID()), String.valueOf(value));
    }

    public void writeGroupValue(String groupAddress, float value) throws KNXException, InterruptedException {
        if (pc == null) throw new KNXException("Not connected");
        pc.write(new StateDP(new GroupAddress(groupAddress), "tmp", 0, DPTXlator2ByteFloat.DPT_TEMPERATURE.getID()), String.valueOf(value));
    }

    public String readGroupValue(String groupAddress) throws KNXException, InterruptedException {
        if (pc == null) throw new KNXException("Not connected");
        return pc.read(new StateDP(new GroupAddress(groupAddress), "tmp"));
    }

    public void addBusListener(Consumer<FrameEvent> listener) { listeners.add(listener); }
    private void notifyListeners(FrameEvent e) { for (Consumer<FrameEvent> l : listeners) l.accept(e); }
    public boolean isConnected() { return link != null && link.isOpen(); }

    public String getConnectionInfo() {
        if (!isConnected()) return "Disconnected";
        return link.getRemoteAddress().toString() + " (" + link.getName() + ")";
    }
}
