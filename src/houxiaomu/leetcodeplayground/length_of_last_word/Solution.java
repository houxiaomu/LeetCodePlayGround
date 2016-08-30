package houxiaomu.leetcodeplayground.length_of_last_word;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-8-30.
 */
public class Solution extends BaseSolution {
    public int lengthOfLastWord(String s) {
        int len = 0;
        int pos = 0;
        int lastLen = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (c == ' ') {
                lastLen = len != 0 ? len : lastLen;
                len = 0;
            } else {
                len++;
            }
            pos++;
        }
        return len == 0 ? lastLen : len;
    }
}
