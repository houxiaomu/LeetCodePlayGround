package houxiaomu.leetcodeplayground.move_zeroes;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by Simon on 2016/12/15.
 */
public class Solution extends BaseSolution {
    public void moveZeroes(int[] nums) {
        int read = 0;
        int write = 0;
        while (read < nums.length) {
            if (nums[read] != 0) {
                if (read != write) nums[write] = nums[read];
                write++;
            }
            read++;
        }
        while (write < nums.length) {
            nums[write] = 0;
            write++;
        }
    }

    @Override
    protected void printResult(Object[] params, Object result) {
        int[] nums = (int[]) params[0];
        System.out.println(Arrays.toString(nums));
    }
}
