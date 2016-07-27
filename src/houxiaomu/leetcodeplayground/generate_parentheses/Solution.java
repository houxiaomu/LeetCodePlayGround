package houxiaomu.leetcodeplayground.generate_parentheses;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by houxiaomu on 16-7-27.
 */
public class Solution extends BaseSolution {
    public List<String> generateParenthesis(int n) {
        List<String> ret = new ArrayList<>();
        recursiveGenerate("", n, n, ret);
        return ret;
    }

    private void recursiveGenerate(String current, int l, int r, List<String> ret) {
        if (l == 0 && r == 0) {
            ret.add(current);
        }

        if (l > 0) {
            recursiveGenerate(current + "(", l - 1, r, ret);
        }

        if (r > l) {
            recursiveGenerate(current + ")", l, r - 1, ret);
        }
    }
}
