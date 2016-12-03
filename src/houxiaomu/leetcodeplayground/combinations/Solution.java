package houxiaomu.leetcodeplayground.combinations;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houxiaomu on 16-10-28.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        run(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }

    private void run(List<List<Integer>> result, List<Integer> group, int n, int k, int start) {
        if (k == 0) {
            result.add(new ArrayList<>(group));
        }
        for (int i = start; i <= n; i++) {
            group.add(i);
            run(result, group, n, k - 1, i + 1);
            group.remove(group.size() - 1);
        }
    }
}
