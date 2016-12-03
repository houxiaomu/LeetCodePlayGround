package houxiaomu.leetcodeplayground.subsets;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Simon on 2016/11/16.
 */
public class Solution extends BaseSolution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        caculate(nums, result, new ArrayList<Integer>(), 0);
        return result;
    }

    private void caculate(int[] nums, List<List<Integer>> result, List<Integer> group, int start) {
        result.add(new ArrayList<>(group));
        for (int i = start; i < nums.length; i++) {
            group.add(nums[i]);
            caculate(nums, result, group, i + 1);
            group.remove(group.size() - 1);
        }
    }
}
