package houxiaomu.leetcodeplayground.palindrome_partitioning;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2017/1/4.
 */
public class Solution extends BaseSolution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        helper(s, 0, result, new ArrayList<String>());
        return result;
    }

    void helper(String s, int pos, List<List<String>> result, List<String> current) {
        if (pos == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }
        for (int i = pos; i < s.length(); i++) {
            String sub = s.substring(pos, i + 1);
            if (isPalindrome(sub)) {
                current.add(sub);
                helper(s, i + 1, result, current);
                current.remove(current.size() - 1);
            }
        }
    }

    boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
