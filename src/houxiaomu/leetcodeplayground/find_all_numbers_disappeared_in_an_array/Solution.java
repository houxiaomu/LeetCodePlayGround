package houxiaomu.leetcodeplayground.find_all_numbers_disappeared_in_an_array;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int n = Math.abs(nums[i]);
            if (nums[n - 1] > 0) {
                nums[n - 1] = -nums[n - 1];
            } else if (nums[n - 1] < 0) {
                nums[n - 1] = 0;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) result.add(i + 1);
        }
        return result;
    }
}
