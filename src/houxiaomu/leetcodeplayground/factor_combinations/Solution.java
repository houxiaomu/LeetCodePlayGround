package houxiaomu.leetcodeplayground.factor_combinations;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2017/1/4.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> result = new ArrayList<>();
        helper(n, true, result, new ArrayList<Integer>());
        return result;
    }

    void helper(int n, boolean first, List<List<Integer>> result, List<Integer> current) {
        if (n == 1) {
            result.add(new ArrayList<>(current));
        }
        int max = first ? (n - 1) / 2 : n;
        for (int i = 2; i <= max; i++) {
            if (n % i == 0) {
                current.add(i);
                helper(n / i, false, result, current);
                current.remove(current.size() - 1);
            }
        }
    }
}
