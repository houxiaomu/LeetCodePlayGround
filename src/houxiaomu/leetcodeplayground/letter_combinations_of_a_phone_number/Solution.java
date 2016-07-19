package houxiaomu.leetcodeplayground.letter_combinations_of_a_phone_number;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by houxiaomu on 16-7-19.
 */
public class Solution extends BaseSolution {
    static char[][] sDict = new char[][]{
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'},
    };

    public List<String> letterCombinations(String digits) {
        LinkedList<String> result = new LinkedList<>();
        add(digits, result);
        return result;
    }

    private void add(String digits, LinkedList<String> result) {
        if (digits.length() == 0) {
            return;
        }

        final char c = digits.charAt(0);
        final char[] chars = sDict[c - '2'];

        int len = result.size();
        if (len == 0) {
            for (int j = 0; j < chars.length; j++) {
                result.add(String.valueOf(chars[j]));
            }
        } else {
            for (int i = 0; i < len; i++) {
                String str = result.poll();
                for (int j = 0; j < chars.length; j++) {
                    result.add(str + String.valueOf(chars[j]));
                }
            }
        }
        add(digits.substring(1), result);
    }
}
