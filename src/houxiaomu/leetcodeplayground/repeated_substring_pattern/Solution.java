package houxiaomu.leetcodeplayground.repeated_substring_pattern;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/22.
 */
public class Solution extends BaseSolution {
    public boolean repeatedSubstringPattern(String str) {
        if (str.length() < 2) return false;
        char[] chars = str.toCharArray();
        final int len = chars.length;
        for (int n = 1; n <= chars.length / 2; n++) {
            if (len % n == 0) {
                int m = len / n;
                boolean found = true;
                for (int i = 0; i < n; i++) {
                    char c = chars[i];
                    for (int j = 1; j < m; j++) {
                        if (c != chars[j * n + i]) {
                            found = false;
                            break;
                        }
                    }
                    if (!found) break;
                }
                if (found) return true;
            }
        }
        return false;
    }
}
