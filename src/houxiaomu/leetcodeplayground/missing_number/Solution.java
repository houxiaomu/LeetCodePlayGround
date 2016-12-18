package houxiaomu.leetcodeplayground.missing_number;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/13.
 */
public class Solution extends BaseSolution {
    public int missingNumber(int[] nums) {
        int sum = 0;
        for (int n : nums) sum += n;
        return nums.length * (nums.length + 1) / 2 - sum;
    }
}
