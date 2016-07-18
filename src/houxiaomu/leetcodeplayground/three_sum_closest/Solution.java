package houxiaomu.leetcodeplayground.three_sum_closest;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by Simon on 2016/7/18.
 */
public class Solution extends BaseSolution {
    public int threeSumClosest(int[] nums, int target) {
        int result = target;
        Arrays.sort(nums);

        int diff = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                final int r = nums[i] + nums[j] + nums[k];
                final int d = r - target;
                if (d == 0) {
                    return target;
                } else {
                    if (Math.abs(d) <= diff) {
                        diff = Math.abs(d);
                        result = r;
                    }
                    if (d > 0) {
                        k--;
                    } else {
                        j++;

                    }
                }
            }
        }

        return result;
    }
}
