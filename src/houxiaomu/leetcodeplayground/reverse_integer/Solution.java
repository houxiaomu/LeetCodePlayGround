package houxiaomu.leetcodeplayground.reverse_integer;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-7-1.
 */
public class Solution extends BaseSolution {
    public int reverse(int x) {
        int[] array = new int[10];
        int n = x >= 0 ? x : -x;

        int pos = 0;
        while (n > 0) {
            array[pos] = n % 10;
            n = n / 10;
            pos++;
        }

        int result = 0;
        int d = 1;
        while (pos > 0) {
            if (d >= 1000000000 && array[pos - 1] > 2) return 0;
            int tmp = array[pos - 1] * d;
            if (Integer.MAX_VALUE - tmp < result) return 0;
            result += tmp;
            d *= 10;
            pos--;
        }
        return x >= 0 ? result : -result;
    }
}
