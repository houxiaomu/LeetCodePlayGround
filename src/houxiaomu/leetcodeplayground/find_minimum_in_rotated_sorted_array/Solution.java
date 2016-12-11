package houxiaomu.leetcodeplayground.find_minimum_in_rotated_sorted_array;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/6.
 */
public class Solution extends BaseSolution {
    int min = Integer.MIN_VALUE;

    public int findMin(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums[0] < nums[nums.length - 1]) return nums[0];
        isSorted(nums, 0, nums.length - 1);
        return min;
    }

    boolean isSorted(int[] nums, int left, int right) {
        if (left == right) return true;
        boolean sorted = nums[right] > nums[left];
        int mid = (left + right) / 2;
        boolean sortedLeft = isSorted(nums, left, mid);
        boolean sortedRight = isSorted(nums, mid + 1, right);
        if (!sorted && sortedLeft && sortedRight) {
            min = nums[mid + 1];
        }
        return sorted;
    }
}
