package houxiaomu.leetcodeplayground.partition_equal_subset_sum;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by Simon on 2016/12/27.
 */
public class Solution extends BaseSolution {
    public boolean canPartition(int[] nums) {
        if (nums.length == 0) return false;
        int sum = 0, max = Integer.MIN_VALUE;
        for (int n : nums) {
            if (n > max) max = n;
            sum += n;
        }
        if (sum % 2 == 1) return false;
        sum /= 2;
        if (max > sum) return false;
        if (max == sum) return true;

        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            for (int j = sum; j >= 0; j--) {
                if (j >= n) {
                    dp[j] = dp[j] || dp[j - n];
                }
            }
        }
        return dp[sum];
    }

//    boolean search(int nums[], int pos, int target) {
//        if (target == 0) return true;
//        if (target < 0 || pos >= nums.length) return false;
//        if (search(nums, pos + 1, target - nums[pos])) return true;
//        if (search(nums, pos + 1, target)) return true;
//        return false;
//    }
}
