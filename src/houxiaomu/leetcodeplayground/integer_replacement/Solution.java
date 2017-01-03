package houxiaomu.leetcodeplayground.integer_replacement;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/29.
 */
public class Solution extends BaseSolution {
    public int integerReplacement(int n) {
        int count = 0;
        int i = 1;
        while (i < n) {
            i *= 2;
            count++;
        }
        if (i == n) return count;
        count--;
        int big = i;
        int small = i / 2;
        while (true) {
            if (i > n) {
                big = i;
            } else {
                small = i;
            }
            if (i == n) break;
            if (n - 1 == small) return count + 1;
            i = (big + small) / 2;
            count++;
        }
        return count;
    }
}
