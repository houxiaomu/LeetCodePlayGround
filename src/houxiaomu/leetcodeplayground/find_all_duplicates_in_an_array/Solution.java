package houxiaomu.leetcodeplayground.find_all_duplicates_in_an_array;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]);
            if (nums[index-1] < 0) {
                result.add(index);
            } else {
                nums[index-1] = -nums[index-1];
            }
        }
        return result;
    }
}
