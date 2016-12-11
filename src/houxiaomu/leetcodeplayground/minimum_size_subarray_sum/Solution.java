package houxiaomu.leetcodeplayground.minimum_size_subarray_sum;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/10.
 */
public class Solution extends BaseSolution {
    public int minSubArrayLen(int s, int[] nums) {
        int sum = 0;
        int right = 0, left = 0;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right];
            while (sum >= s && left <= right) {
                sum -= nums[left];
                minLen = Math.min(minLen, right - left + 1);
                left++;
            }
            right++;
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
