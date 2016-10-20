package houxiaomu.leetcodeplayground.plus_one;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/10/19.
 */
public class Solution extends BaseSolution {
    public int[] plusOne(int[] digits) {
        final int len = digits.length;
        int carryOver = 0;
        for (int i = len - 1; i >= 0; i--) {
            if (i == len - 1) {
                digits[i] += 1;
                if (digits[i] >= 10) {
                    digits[i] -= 10;
                    carryOver = 1;
                }
            } else {
                digits[i] += carryOver;
                if (digits[i] >= 10) {
                    digits[i] -= 10;
                    carryOver = 1;
                } else {
                    carryOver = 0;
                }
            }
        }
        int[] result = new int[len + carryOver];
        if (carryOver > 0) {
            result[0] = carryOver;
        }
        for (int i = 0; i < len; i++) {
            result[i + carryOver] = digits[i];
        }
        return result;
    }
}
