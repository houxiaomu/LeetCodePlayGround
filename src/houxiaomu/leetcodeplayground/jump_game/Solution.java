package houxiaomu.leetcodeplayground.jump_game;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-8-30.
 */
public class Solution extends BaseSolution {
    public boolean canJump(int[] nums) {
        if (nums.length == 0) return false;
        if (nums.length == 1) return true;
        int pos = 0;
        int range = 0;
        while (pos < nums.length) {
            if (pos == nums.length - 1) return true;
            range = Math.max(range, nums[pos]);
            if (range == 0) return false;
            range--;
            pos++;
        }
        return true;
    }
}
