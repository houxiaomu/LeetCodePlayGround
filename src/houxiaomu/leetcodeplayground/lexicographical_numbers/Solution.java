package houxiaomu.leetcodeplayground.lexicographical_numbers;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            helper(result, i, n);
        }
        return result;
    }

    void helper(List<Integer> result, int current, int n) {
        if (current > n) return;
        result.add(current);
        for (int i = 0; i <= 9; i++) {
            helper(result, current * 10 + i, n);
        }
    }
}
