package houxiaomu.leetcodeplayground.factorial_trailing_zeroes;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/8.
 */
public class Solution extends BaseSolution {
    public int trailingZeroes(int n) {
        int count = 0;
        int step = 1;
        for (int k = 1; k < 12; k++) {
            step *= 5;
            count += n / step;
        }
        return count;
    }
}
