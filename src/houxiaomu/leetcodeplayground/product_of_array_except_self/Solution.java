package houxiaomu.leetcodeplayground.product_of_array_except_self;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        long p = 1;
        int zeroCount = 0;
        int zeroIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                p *= nums[i];
            } else {
                zeroCount++;
                zeroIndex = i;
            }
        }

        if (zeroCount > 1) {
            return result;
        } else if (zeroCount == 1) {
            for (int i = 0; i < result.length; i++) {
                result[zeroIndex] = (int) p;
            }
        } else {
            for (int i = 0; i < result.length; i++) {
                result[i] = (int) (p / nums[i]);
            }
        }

        return result;
    }
}
