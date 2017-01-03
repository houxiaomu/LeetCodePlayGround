package houxiaomu.leetcodeplayground.combination_sum_iv;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        helper(nums, target, dp);
        return dp[target];
    }

    int helper(int[] nums, int target, int[] dp) {
        if (dp[target] != -1) {
            return dp[target];
        }
        int total = 0;
        for (int i = 0; i < nums.length; i++) {
            if (target - nums[i] >= 0) {
                total += helper(nums, target - nums[i], dp);
            }
        }
        dp[target] = total;
        return total;
    }
}
