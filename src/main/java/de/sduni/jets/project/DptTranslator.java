package de.sduni.jets.project;

import tuwien.auto.calimero.dptxlator.DPTXlator;
import tuwien.auto.calimero.dptxlator.TranslatorTypes;
import tuwien.auto.calimero.KNXException;

import java.util.Base64;

public class DptTranslator {

    public static String translate(int main, int sub, String rawValue) {
        String dpt = main + "." + String.format("%03d", sub);
        return translate(dpt, rawValue);
    }

    public static String translate(String dpt, String rawValue) {
        if (rawValue == null || rawValue.isEmpty()) return "";
        if (dpt == null || dpt.isEmpty() || dpt.equals("0") || dpt.equals("0.000")) {
            return rawValue;
        }

        try {
            byte[] data;
            if (rawValue.startsWith("0x")) {
                data = hexToBytes(rawValue.substring(2));
            } else if (isBase64(rawValue)) {
                data = Base64.getDecoder().decode(rawValue);
            } else {
                return rawValue;
            }

            String normalizedDpt = dpt;
            if (normalizedDpt.startsWith("DPST-")) {
                String[] parts = normalizedDpt.split("-");
                normalizedDpt = parts[1] + "." + String.format("%03d", Integer.parseInt(parts[2]));
            }

            DPTXlator xlator = TranslatorTypes.createTranslator(normalizedDpt);
            xlator.setData(data);
            return xlator.getValue();

        } catch (Exception e) {
            return rawValue + " (DPT " + dpt + " err)";
        }
    }

    private static boolean isBase64(String s) {
        if (s.length() < 2) return false;
        return s.contains("/") || s.contains("+") || (s.endsWith("=") && s.length() > 4);
    }

    private static byte[] hexToBytes(String s) {
        int len = s.length();
        if (len % 2 != 0) s = "0" + s;
        byte[] data = new byte[s.length() / 2];
        for (int i = 0; i < s.length(); i += 2) {
            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                                 + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }
}
