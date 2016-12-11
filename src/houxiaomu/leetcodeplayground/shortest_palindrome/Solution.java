package houxiaomu.leetcodeplayground.shortest_palindrome;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public String shortestPalindrome(String s) {
        if (s.length() == 0) return s;
        int len = longestPalindrome(s.toCharArray());
        StringBuilder sb = new StringBuilder(s);
        for (int i = len; i < s.length(); i++) {
            sb.insert(0, s.charAt(i));
        }
        return sb.toString();
    }

    int longestPalindrome(char[] s) {
        int len = 1;
        for (int i = 1; i < s.length; i++) {
            if (isPalindrome(s, 0, i)) {
                len = Math.max(len, i + 1);
            }
        }
        return len;
    }

    boolean isPalindrome(char[] s, int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--]) return false;
        }
        return true;
    }
}
