package houxiaomu.leetcodeplayground.longest_repeating_character_replacement;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/26.
 */
public class Solution extends BaseSolution {
    public int characterReplacement(String s, int k) {
        return Math.max(helper(s, k), helper(new StringBuilder(s).reverse().toString(), k));
    }

    public int helper(String s, int k) {
        if (s.length() == 0) return 0;
        int max = 1;
        int pos = 1;
        char last = s.charAt(0);
        int remain = k;
        int dupCount = 1;
        int diffIndex = -1;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c == last) {
                dupCount++;
                pos++;
                if (dupCount > max) max = dupCount;
            } else {
                if (remain == 0) {
                    remain = k;
                    dupCount = 1;
                    if (diffIndex > 0) {
                        last = s.charAt(diffIndex);
                        pos = diffIndex + 1;
                        diffIndex = -1;
                    } else {
                        last = c;
                        pos++;
                    }
                } else {
                    if (diffIndex < 0) {
                        diffIndex = pos;
                    }
                    dupCount++;
                    remain--;
                    pos++;
                    if (dupCount > max) max = dupCount;
                }
            }
        }
        return max;
    }
}
