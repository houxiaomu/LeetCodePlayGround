package houxiaomu.leetcodeplayground.hamming_distance;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public int hammingDistance(int x, int y) {
        int pos = 0;
        while (x != 0 || y != 0) {
            if ((x & 0x1) != (y & 0x1)) pos++;
            x >>= 1;
            y >>= 1;
        }
        return pos;
    }
}
