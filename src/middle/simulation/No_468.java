package middle.simulation;

/**
 * No.468 验证IP地址 (Microsoft)
 */
public class No_468 {
    public String validIPAddress(String queryIP) {
        if (isIPv4(queryIP)) return "IPv4";
        if (isIPv6(queryIP)) return "IPv6";
        return "Neither";
    }

    private boolean isIPv4(String IP) {
        String[] ips = IP.split("\\.");
        if (ips.length != 4 || IP.charAt(IP.length() - 1) == '.') return false;
        for (String ip : ips) {
            if (ip.length() > 3 || ip.length() == 0 || ip.length() > 1 && ip.charAt(0) == '0') return false;
            for (char ch : ip.toCharArray()) {
                if (ch < '0' || ch > '9') return false;
            }

            if (Integer.parseInt(ip) > 225) return false;
        }

        return true;
    }

    private boolean isIPv6(String IP) {
        String[] ips = IP.split(":");
        if (ips.length != 8 || IP.charAt(IP.length() - 1) == ':') return false;
        for (String ip : ips) {
            if (ip.length() > 4 || ip.length() == 0) return false;
            for (char ch : ip.toCharArray()) {
                if (!((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'f') || (ch >= 'A' && ch <= 'F'))) return false;
            }
        }

        return true;
    }
}
