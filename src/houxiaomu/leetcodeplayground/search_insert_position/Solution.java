package houxiaomu.leetcodeplayground.search_insert_position;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/7/31.
 */
public class Solution extends BaseSolution {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int index = (left + right) / 2;
            if (nums[index] == target) {
                return index;
            } else if (nums[index] < target) {
                left++;
            } else {
                right--;
            }
        }
        return left;
    }
}
