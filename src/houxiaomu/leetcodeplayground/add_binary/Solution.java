package houxiaomu.leetcodeplayground.add_binary;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/10/19.
 */
public class Solution extends BaseSolution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int pos = 0;
        int carryOver = 0;
        while (pos < a.length() || pos < b.length()) {
            int index = a.length() - pos - 1;
            int va = (index >= 0) ? (a.charAt(a.length() - pos - 1) - '0') : 0;
            index = b.length() - pos - 1;
            int vb = (index >= 0) ? (b.charAt(index) - '0') : 0;
            int v = va + vb + carryOver;
            carryOver = 0;
            if (v > 1) {
                v -= 2;
                carryOver = 1;
            }
            sb.insert(0, (char) ('0' + v));
            pos++;
        }
        if (carryOver > 0) sb.insert(0, '1');
        return sb.toString();
    }
}
