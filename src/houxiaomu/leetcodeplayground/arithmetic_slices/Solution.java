package houxiaomu.leetcodeplayground.arithmetic_slices;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/27.
 */
public class Solution extends BaseSolution {
    public int numberOfArithmeticSlices(int[] A) {
        int result = 0;
        int[] cache = new int[A.length];
        for (int i = 2; i < A.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                cache[i] = cache[i - 1] + 1;
            }
            result += cache[i];
        }
        return result;
    }
}
