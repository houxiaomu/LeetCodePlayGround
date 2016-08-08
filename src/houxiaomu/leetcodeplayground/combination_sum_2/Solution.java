package houxiaomu.leetcodeplayground.combination_sum_2;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Simon on 2016/8/8.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new LinkedList<Integer>(), result);
        return result;
    }

    private void dfs(int[] candidates, int target, int start, LinkedList<Integer> list, List<List<Integer>> result) {
        if (target < 0) {
            return;
        } else if (target == 0) {
            result.add(new ArrayList<Integer>(list));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i > start && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.addLast(candidates[i]);
                dfs(candidates, target - candidates[i], i + 1, list, result);
                list.removeLast();
            }
        }
    }
}
