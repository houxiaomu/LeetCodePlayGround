package houxiaomu.leetcodeplayground.guess_number_higher_or_lower_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    public int getMoneyAmount(int n) {
        if (n <= 1) return 0;
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = i - 3 + i - 1;
        }
        return dp[n];
    }
}
