package houxiaomu.leetcodeplayground.remove_duplicates_from_sorted_array;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-7-29.
 */
public class Solution extends BaseSolution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;

        int r = 1;
        int w = 1;
        int last = nums[0];
        while (r < nums.length) {
            if (nums[r] == last) {
                r++;
            } else {
                last = nums[r];
                if (w != r) {
                    nums[w] = last;
                }
                w++;
                r++;
            }
        }
        return w;
    }
}
