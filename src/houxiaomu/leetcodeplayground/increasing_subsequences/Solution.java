package houxiaomu.leetcodeplayground.increasing_subsequences;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Simon on 2017/2/6.
 */
public class Solution extends BaseSolution {

    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> resultSet = new HashSet<>();
        helper(nums, 0, new ArrayList<Integer>(), resultSet);
        List<List<Integer>> res = new ArrayList<>(resultSet);
        return res;
    }

    void helper(int[] nums, int start, List<Integer> current, Set<List<Integer>> resultSet) {
        current.add(nums[start]);
        if (current.size() >= 2) {
            resultSet.add(new ArrayList<>(current));
        }
        for (int i = start + 1; i < nums.length; i++) {
            if (i == start + 1) helper(nums, i, new ArrayList<Integer>(), resultSet);
            if (nums[i] >= nums[start]) {
                helper(nums, i, current, resultSet);
            }
        }
        current.remove(current.size() - 1);

//        if (current.size() >= 2) {
//            resultSet.add(new ArrayList(current));
//        }
//        for (int i = start; i < nums.length; i++) {
//            if (current.size() == 0 || current.get(current.size() - 1) <= nums[i]) {
//                current.add(nums[i]);
//                helper(nums, i + 1, current, resultSet);
//                current.remove(current.size() - 1);
//            }
//        }
    }
}
