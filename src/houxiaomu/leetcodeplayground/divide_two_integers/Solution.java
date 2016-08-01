package houxiaomu.leetcodeplayground.divide_two_integers;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-7-29.
 */
public class Solution extends BaseSolution {
    public int divide(int dividend, int divisor) {
        if (divisor == 0) {
            return 0;
        } else if (dividend == 0) {
            return 0;
        }
        int n = 0;
        boolean sign = false;
        if (dividend > 0 && divisor > 0) {
            while (dividend >= divisor) {
                dividend -= divisor;
                n++;
            }
        } else if (dividend < 0 && divisor > 0) {
            while (dividend <= -divisor) {
                dividend += divisor;
                n++;
            }
            sign = true;
        } else if (dividend > 0 && divisor < 0) {
            while (dividend >= -divisor) {
                dividend += divisor;
                n++;
            }
            sign = true;
        } else if (dividend < 0 && divisor < 0) {
            while (dividend <= divisor) {
                dividend -= divisor;
                n++;
                if (n == Integer.MAX_VALUE) break;
            }
        }
        return sign ? -n : n;
    }
}
