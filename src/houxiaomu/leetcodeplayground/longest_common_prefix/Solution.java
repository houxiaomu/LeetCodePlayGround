package houxiaomu.leetcodeplayground.longest_common_prefix;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-7-14.
 */
public class Solution extends BaseSolution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }

        int len = 0;
        final String s = strs[0];
        for (int charIndex = 0; charIndex < s.length(); charIndex++) {
            char c = s.charAt(charIndex);
            boolean end = false;
            for (int strIndex = 1; strIndex < strs.length; strIndex++) {
                final String s1 = strs[strIndex];
                if (charIndex < s1.length() && s1.charAt(charIndex) == c) {
                    continue;
                } else {
                    end = true;
                    break;
                }
            }

            if (end) {
                len = charIndex;
                break;
            } else {
                len = charIndex + 1;
            }
        }

        if (len > 0) {
            return strs[0].substring(0, len );
        }
        return "";
    }
}
