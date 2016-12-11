package houxiaomu.leetcodeplayground.word_break;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Set;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        return helper(s, wordDict, 0);
    }

    boolean helper(String s, Set<String> wordDict, int start) {
        if (start == s.length()) {
            return true;
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (!wordDict.contains(sub)) continue;
            boolean b = helper(s, wordDict, i);
            if (b) return true;
        }
        return false;
    }
}
