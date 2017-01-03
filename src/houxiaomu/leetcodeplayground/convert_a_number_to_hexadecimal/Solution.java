package houxiaomu.leetcodeplayground.convert_a_number_to_hexadecimal;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/28.
 */
public class Solution extends BaseSolution {
    public String toHex(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8 && num != 0; i++) {
            int n = (num & 0xf);
            sb.insert(0, n < 10 ? (char) (n + '0') : (char) (n - 10 + 'a'));
            num >>= 4;
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}
