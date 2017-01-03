package houxiaomu.leetcodeplayground.utf_8_validation;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {
    public boolean validUtf8(int[] data) {
        int pos = 0;
        while (pos < data.length) {
            if (data[pos] >> 7 == 0) {
                pos++;
                continue;
            }
            if (data.length - pos >= 2 && data[pos] >> 5 == 0x6
                    && data[pos + 1] >> 6 == 0x2) {
                pos += 2;
                continue;
            }
            if (data.length - pos >= 3 && data[pos] >> 4 == 0xE
                    && data[pos + 1] >> 6 == 0x2 && data[pos + 2] >> 6 == 0x2) {
                pos += 3;
                continue;
            }
            if (data.length - pos >= 4 && data[pos] >> 3 == 0x1E
                    && data[pos + 1] >> 6 == 0x2 && data[pos + 2] >> 6 == 0x2
                    && data[pos + 3] >> 6 == 0x2) {
                pos += 4;
                continue;
            }
            return false;
        }
        return true;
    }
}
