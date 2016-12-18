package houxiaomu.leetcodeplayground.expression_add_operators;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/15.
 */
public class Solution extends BaseSolution {
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        char[] operators = new char[num.length() - 1];
        helper(num, target, operators, 0, result);
        return result;
    }

    void helper(String num, int target, char[] operators, int opIndex, List<String> result) {
        if (opIndex == operators.length) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= operators.length; i++) {
                sb.append(num.charAt(i));
                if (i != operators.length) {
                    sb.append(operators[i]);
                }
            }
            String exp = sb.toString();
            if (calculate(exp) == target) {
                result.add(exp);
            }
            return;
        }
        operators[opIndex] = '+';
        helper(num, target, operators, opIndex + 1, result);
        operators[opIndex] = '-';
        helper(num, target, operators, opIndex + 1, result);
        operators[opIndex] = '*';
        helper(num, target, operators, opIndex + 1, result);
    }


    private int calculate(String expression) {
        System.out.println(expression);
        long cur = 0;
        int pos = expression.length() - 1;
        while (pos >= 0) {
            if (pos == expression.length() - 1) {
                cur = expression.charAt(pos) - '0';
            }
            char op = expression.charAt(--pos);
            int n = expression.charAt(--pos);
            if (op == '+') {
                cur += n;
            } else if (op == '-') {

            }
        }
        return 0;
    }
}
