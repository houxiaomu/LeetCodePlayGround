package houxiaomu.leetcodeplayground.super_pow;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    public int superPow(int a, int[] b) {
        int[] bb = new int[b.length];
        int carry = 0;
        boolean bIs1or0 = true;
        for (int i = 0; i < b.length; i++) {
            if (b[i] != 0 && i != b.length - 1) bIs1or0 = false;
            b[i] += carry * 10;
            if (b[i] % 2 == 1) {
                carry = 1;
            }
            bb[i] = b[i] / 2;
        }
        if (bIs1or0 && b[b.length - 1] == 0) {
            return 1;
        }
        if (bIs1or0 && b[b.length - 1] == 1) {
            return a;
        }
        if (b[b.length - 1] % 2 == 1) {
            return a * superPow(a * a, bb);
        } else {
            return superPow(a * a, bb);
        }
    }
}
