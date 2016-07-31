package houxiaomu.leetcodeplayground.search_for_a_range;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/7/31.
 */
public class Solution extends BaseSolution {
    public int[] searchRange(int[] nums, int target) {
        int[] ret = new int[]{-1, -1};
        find(nums, 0, nums.length - 1, target, ret);
        return ret;
    }

    void find(int[] nums, int left, int right, int target, int[] ret) {
        if (right < left) return;
        int index = (right + left) / 2;
        if (nums[index] == target) {
            if (ret[0] == -1 || index < ret[0]) {
                ret[0] = index;
                find(nums, left, index - 1, target, ret);
            }
            if (ret[1] == -1 || index > ret[1]) {
                ret[1] = index;
                find(nums, index + 1, right, target, ret);
            }
        } else if (nums[index] < target && (ret[0] == -1 || index < ret[0])) {
            find(nums, index + 1, right, target, ret);
        } else if (nums[index] > target && (ret[1] == -1 || index > ret[1])) {
            find(nums, left, index - 1, target, ret);
        }
    }

}
