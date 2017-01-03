package houxiaomu.leetcodeplayground.minimum_moves_to_equal_array_elements_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by Simon on 2016/12/22.
 */
public class Solution extends BaseSolution {
    public int minMoves2(int[] nums) {
        if (nums.length == 0) return 0;
        Arrays.sort(nums);
        int move = 0;
        int midian = nums[nums.length / 2];
        for (int n : nums) {
            move += Math.abs(n - midian);
        }
        return move;
    }
}
