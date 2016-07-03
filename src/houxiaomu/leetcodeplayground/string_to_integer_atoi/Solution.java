package houxiaomu.leetcodeplayground.string_to_integer_atoi;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/7/3.
 */
public class Solution extends BaseSolution {
    public int myAtoi(String str) {
        boolean negative = false;
        int result = 0;
        int pos = 0;
        final int len = str.length();

        int digit = 0;
        final int max = Integer.MAX_VALUE / 10;
        while (pos < len) {
            final char c = str.charAt(pos);
            if (c >= '0' && c <= '9') {
                if (result > max) {
                    result = negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                    break;
                }

                result *= 10;

                int num = c - '0';
                if (negative) {
                    if (Integer.MIN_VALUE + result > -num) {
                        result = Integer.MIN_VALUE;
                        break;
                    }
                } else {
                    if (Integer.MAX_VALUE - result < num) {
                        result = Integer.MAX_VALUE;
                        break;
                    }
                }

                result += num;
                digit++;
            } else if (c == '-' && digit == 0) {
                negative = true;
                digit++;
            } else if (c == '+' && digit == 0) {
                digit++;
            } else if (c == ' ' || c == '\t') {
                if (digit > 0) {
                    break;
                }
            } else {
                break;
            }
            pos++;
        }

        return negative ? -result : result;
    }
}
