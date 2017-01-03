package houxiaomu.leetcodeplayground.validate_ip_address;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/21.
 */
public class Solution extends BaseSolution {
    static final String NEITHER = "Neither";
    static final String IPV4 = "IPv4";
    static final String IPV6 = "IPv6";

    public String validIPAddress(String IP) {
        if (IP == null || IP.isEmpty()) return NEITHER;
        String[] segments = IP.split("\\.");
        if (segments.length == 4 && IP.charAt(IP.length() - 1) != '.') {
            return checkIPv4(segments) ? IPV4 : NEITHER;
        }

        segments = IP.split(":");
        if (segments.length == 8 && IP.charAt(IP.length() - 1) != ':') {
            return checkIPv6(segments) ? IPV6 : NEITHER;
        }
        return NEITHER;
    }

    private boolean checkIPv6(String[] segments) {
        for (int i = 0; i < segments.length; i++) {
            char[] s = segments[i].toCharArray();
            if (s.length == 0 || s.length > 4) return false;
            for (int j = 0; j < s.length; j++) {
                if (!((s[j] >= '0' && s[j] <= '9') || (s[j] >= 'a' && s[j] <= 'f')
                        || (s[j] >= 'A' && s[j] <= 'F'))) return false;
            }
        }
        return true;
    }

    private boolean checkIPv4(String[] segments) {
        for (int i = 0; i < segments.length; i++) {
            char[] s = segments[i].toCharArray();
            if (s.length == 0 || s.length > 3) return false;
            if (s.length > 1 && s[0] == '0') return false;
            int n = 0;
            for (int j = 0; j < s.length; j++) {
                if (s[j] < '0' || s[j] > '9') return false;
                n = n * 10;
                n += s[j] - '0';
            }
            if (n > 255) return false;
        }
        return true;
    }
}
