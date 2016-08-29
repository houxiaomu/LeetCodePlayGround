package houxiaomu.leetcodeplayground.permutations_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by houxiaomu on 16-8-29.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        Arrays.sort(nums);
        permute(temp, result, 0, nums, new boolean[nums.length]);
        return result;
    }

    private void permute(LinkedList<Integer> temp, List<List<Integer>> result, int start, int[] nums, boolean[] used) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (used[i] || i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) continue;
                temp.add(nums[i]);
                used[i] = true;
                permute(temp, result, start, nums, used);
                temp.removeLast();
                used[i] = false;
            }
        }
    }
}
