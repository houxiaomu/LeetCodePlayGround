package houxiaomu.leetcodeplayground.additive_number;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/16.
 */
public class Solution extends BaseSolution {
    public boolean isAdditiveNumber(String num) {
        if (num == null || num.length() <= 2) return false;
        return helper(num.toCharArray(), 0, "", "");
    }

    boolean helper(char[] num, int start, String n1, String n2) {
        if (start == num.length) {
            return false;
        }

        for (int len = 1; start + len <= num.length; len++) {
            String n = String.copyValueOf(num, start, len);
            if (num[start] == '0' && n.length() > 1) continue;
            if (n1.isEmpty()) {
                if (helper(num, start + len, n, n2)) return true;
                continue;
            }
            if (n2.isEmpty()) {
                if (helper(num, start + len, n1, n)) return true;
                continue;
            }
            String sum = sum(n1, n2);
            if (n.equals(sum)) {
                if (start + len == num.length) return true;
                if (helper(num, start + len, n2, n)) return true;
            }
        }
        return false;
    }

    String sum(String n1, String n2) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int carry = 0;
        while (pos < n1.length() || pos < n2.length()) {
            int i1 = pos < n1.length() ? n1.charAt(n1.length() - pos - 1) - '0' : 0;
            int i2 = pos < n2.length() ? n2.charAt(n2.length() - pos - 1) - '0' : 0;
            int sum = i1 + i2 + carry;
            carry = 0;
            if (sum >= 10) {
                sum -= 10;
                carry = 1;
            }
            sb.insert(0, (char) (sum + '0'));
            pos++;
        }
        if (carry > 0) sb.insert(0, '1');
        return sb.toString();
    }
}
