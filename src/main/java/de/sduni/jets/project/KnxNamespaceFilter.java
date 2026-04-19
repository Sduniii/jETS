package de.sduni.jets.project;

import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.util.StreamReaderDelegate;

/**
 * Strips or rewrites KNX namespaces to match the compiled Java model (v20).
 * This ensures compatibility across different ETS versions (v11, v13, v23, etc.).
 */
public class KnxNamespaceFilter extends StreamReaderDelegate {
    
    private static final String KNX_NS_PREFIX = "http://knx.org/xml/project/";
    private static final String TARGET_NAMESPACE = "http://knx.org/xml/project/20";

    public KnxNamespaceFilter(XMLStreamReader reader) {
        super(reader);
    }

    @Override
    public String getNamespaceURI() {
        String uri = super.getNamespaceURI();
        if (uri != null && uri.startsWith(KNX_NS_PREFIX)) {
            return TARGET_NAMESPACE;
        }
        return uri;
    }

    @Override
    public String getNamespaceURI(int index) {
        String uri = super.getNamespaceURI(index);
        if (uri != null && uri.startsWith(KNX_NS_PREFIX)) {
            return TARGET_NAMESPACE;
        }
        return uri;
    }

    @Override
    public String getNamespaceURI(String prefix) {
        String uri = super.getNamespaceURI(prefix);
        if (uri != null && uri.startsWith(KNX_NS_PREFIX)) {
            return TARGET_NAMESPACE;
        }
        return uri;
    }
}
