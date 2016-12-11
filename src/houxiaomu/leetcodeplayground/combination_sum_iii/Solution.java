package houxiaomu.leetcodeplayground.combination_sum_iii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        Set<Integer> result = new HashSet<>();
        helper(k, n, result, new boolean[9]);
        List<List<Integer>> output = new ArrayList<>();
        for (Integer i : result) {
            LinkedList<Integer> number = new LinkedList<>();
            while (i != 0) {
                number.addFirst(i % 10);
                i /= 10;
            }
            output.add(number);
        }
        return output;
    }

    void helper(int k, int n, Set<Integer> result, boolean used[]) {
        if (k == 0) {
            if (n == 0) {
                int number = 0;
                for (int i = 1; i <= 9; i++) {
                    if (used[i - 1]) {
                        number *= 10;
                        number += i;
                    }
                }
                result.add(number);
            }
            return;
        }

        for (int i = 1; i <= 9; i++) {
            if (used[i - 1]) continue;
            used[i - 1] = true;
            helper(k - 1, n - i, result, used);
            used[i - 1] = false;
        }
    }
}
