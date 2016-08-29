package houxiaomu.leetcodeplayground.permutations;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by houxiaomu on 16-8-29.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<Integer> temp = new LinkedList<>();
        fullPermute(temp, result, 0, nums);
        return result;
    }

    private void fullPermute(LinkedList<Integer> temp, List<List<Integer>> result, int start, int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (temp.contains(nums[i])) continue;
                temp.add(nums[i]);
                fullPermute(temp, result, start, nums);
                temp.removeLast();
            }
        }
    }

}
