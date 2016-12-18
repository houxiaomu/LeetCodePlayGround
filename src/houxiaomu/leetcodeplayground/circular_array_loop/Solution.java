package houxiaomu.leetcodeplayground.circular_array_loop;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public boolean circularArrayLoop(int[] nums) {
        if (nums.length == 0) return false;
        int fast = 0, slow = 0;
        while (true) {
            slow = slow + nums[slow];
            if (slow < -1 || slow > nums.length) return false;
            if (slow == -1) slow = nums.length - 1;
            if (slow == nums.length) slow = 0;

            fast = fast + nums[fast];
            if (fast < 0 || fast > nums.length) return false;
            if (fast == -1) fast = nums.length - 1;
            if (fast == nums.length) fast = 0;

            fast = fast + nums[fast];
            if (fast < 0 || fast > nums.length) return false;
            if (fast == -1) fast = nums.length - 1;
            if (fast == nums.length) fast = 0;

            if (slow == fast) break;
        }
        return true;
    }
}
