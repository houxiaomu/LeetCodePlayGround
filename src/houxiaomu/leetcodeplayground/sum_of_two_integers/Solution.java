package houxiaomu.leetcodeplayground.sum_of_two_integers;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    public int getSum(int a, int b) {
        int sum = 0;
        int carry = 0;
        for (int i = 0; i < 32; i++) {
            int aa = a >> i & 0x1;
            int bb = b >> i & 0x1;
            int v = 0;
            if (carry == 0) {
                if (aa == 1 && bb == 1) {
                    v = 0;
                    carry = 1;
                } else if (aa == 0 && bb == 0) {
                    v = 0;
                } else {
                    v = 1;
                }
            } else {
                if (aa == 1 && bb == 1) {
                    v = 1;
                } else if (aa == 0 && bb == 0) {
                    v = 1;
                    carry = 0;
                } else {
                    v = 0;
                }
            }
            sum |= v << i;
        }
        return sum;
    }
}
