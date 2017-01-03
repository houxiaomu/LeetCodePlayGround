package houxiaomu.leetcodeplayground.unique_substrings_in_wraparound_string;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/21.
 */
public class Solution extends BaseSolution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() == 0) return 0;
        int[] maxSeq = new int[p.length()];
        char last = 0;
        char[] str = p.toCharArray();
        for (int i = 0; i < str.length; i++) {
            if (str[i] - last == 1 || str[i] - last == -25) {
                maxSeq[i] = maxSeq[i - 1] + 1;
            } else {
                maxSeq[i] = 1;
            }
            last = str[i];
        }

        int[] max = new int[26];
        for (int i = 0; i < maxSeq.length; i++) {
            int index = str[i] - 'a';
            max[index] = Math.max(max[index], maxSeq[i]);
        }
        int sum = 0;
        for (int i : max) sum += i;
        return sum;
    }
}
