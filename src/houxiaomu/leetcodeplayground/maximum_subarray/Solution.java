package houxiaomu.leetcodeplayground.maximum_subarray;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-8-30.
 */
public class Solution extends BaseSolution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currentSum = 0;
        for (int i : nums) {
            currentSum += i;
            max = Math.max(currentSum, max);
            if (currentSum < 0) {
                currentSum = 0;
            }
        }
        return max;
    }
}
