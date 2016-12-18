package houxiaomu.leetcodeplayground.different_ways_to_add_parentheses;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/12.
 */
public class Solution extends BaseSolution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < input.length(); i++) {
            int c = input.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                String leftString = input.substring(0, i);
                String rightString = input.substring(i + 1);
                List<Integer> leftRes = diffWaysToCompute(leftString);
                List<Integer> rightRes = diffWaysToCompute(rightString);
                for (int l : leftRes) {
                    for (int r : rightRes) {
                        if (c == '+') {
                            result.add(l + r);
                        } else if (c == '-') {
                            result.add(l - r);
                        } else if (c == '*') {
                            result.add(l * r);
                        }
                    }
                }
            }
        }
        if (result.size() == 0) {
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
