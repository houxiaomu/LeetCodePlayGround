package houxiaomu.leetcodeplayground.is_subsequence;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) return true;
        if (t.length() == 0) return false;
        char[] schars = s.toCharArray();
        char[] tchars = t.toCharArray();
        int[][] smap = mapping(schars);
        int[][] tmap = mapping(tchars);
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
            while (pos < tchars.length && tchars[pos] != schars[i]) pos++;
            if (pos == tchars.length) return false;
            for (int j = 0; j < 26; j++) {
                if (smap[i][j] > tmap[i][j]) return false;
            }
        }
        return true;
    }

    int[][] mapping(char[] s) {
        int[][] map = new int[s.length][26];
        for (int i = s.length - 2; i >= 0; i--) {
            for (int j = 0; j < 26; j++) {
                map[i][j] = (s[i + 1] - 'a' == j ? 1 : 0) + map[i + 1][j];
            }
        }
        return map;
    }
}
