package houxiaomu.leetcodeplayground.remove_element;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-7-29.
 */
public class Solution extends BaseSolution {
    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        int w = 0;
        int r = 0;
        while (r < nums.length) {
            if (nums[r] != val) {
                if (w != r) {
                    nums[w] = nums[r];
                }
                w++;
            }
            r++;
        }
        return w;
    }
}
