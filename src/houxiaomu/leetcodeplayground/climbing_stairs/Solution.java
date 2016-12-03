package houxiaomu.leetcodeplayground.climbing_stairs;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/10/21.
 */
public class Solution extends BaseSolution {
    public int climbStairs(int n) {
        if (n <= 0) return 0;
        return doRecursively(n, new int[n + 1]);
    }

    private int doRecursively(int n, int[] cache) {
        if (cache[n] != 0) return cache[n];
        if (n == 1) return 1;
        if (n == 2) return 2;
        int value = doRecursively(n - 1, cache) + doRecursively(n - 2, cache);
        cache[n] = value;
        return value;
    }
}
