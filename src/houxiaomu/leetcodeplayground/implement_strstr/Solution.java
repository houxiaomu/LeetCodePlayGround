package houxiaomu.leetcodeplayground.implement_strstr;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-7-29.
 */
public class Solution extends BaseSolution {
    public int strStr(String haystack, String needle) {
        final int nl = needle.length();
        final int hl = haystack.length();
        if (nl == 0) return 0;
        if (hl == 0) return -1;

        int pos = 0;
        while (pos <= hl - nl) {
            int i = 0;
            for (i = 0; i < nl; i++) {
                if (needle.charAt(i) != haystack.charAt(i + pos)) {
                    break;
                }
            }
            if (i == nl) {
                return pos;
            }
            pos++;
        }
        haystack.indexOf("a");
        return -1;
    }
}
