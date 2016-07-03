package houxiaomu.leetcodeplayground.longest_palindromic_substring;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/6/26.
 */
public class Solution extends BaseSolution {
    public String longestPalindrome(String s) {
        int max = 0;
        String ret = "";
        int len = s.length();
        for (int i = 0; i < len; i++) {
            String newRet = getPalindrome(s, i, max);
            if (newRet != null && newRet.length() > max) {
                max = newRet.length();
                ret = newRet;
            }
        }
        return ret;
    }

    private String getPalindrome(String s, int pos, int max) {
        int begin = -1, end = -1;
        for (int i = 0; pos + i < s.length() && pos - i >= 0; i++) {
            if (pos + i + 1 < s.length() && s.charAt(pos - i) == s.charAt(pos + i + 1)) {
                begin = pos - i;
                end = pos + i + 2;
            } else {
                break;
            }
        }
        if (begin >= 0 && end >= 0 && end - begin > max) {
            return s.substring(begin, end);
        }

        begin = -1;
        end = -1;
        for (int i = 0; pos + i < s.length() && pos - i >= 0; i++) {
            if (s.charAt(pos - i) == s.charAt(pos + i)) {
                begin = pos - i;
                end = pos + i + 1;
            } else {
                break;
            }
        }
        if (begin >= 0 && end >= 0 && end - begin > max) {
            return s.substring(begin, end);
        }
        return null;
    }
}
