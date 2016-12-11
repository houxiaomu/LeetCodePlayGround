package houxiaomu.leetcodeplayground.word_break_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by Simon on 2016/12/5.
 */
public class Solution extends BaseSolution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();
        wordBreak(s, wordDict, 0, new ArrayList<String>(), result);
        return result;
    }

    void wordBreak(String s, Set<String> wordDict, int start, List<String> current, List<String> result) {
        if (start == s.length()) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < current.size(); i++) {
                sb.append(current.get(i));
                if (i != current.size() - 1) {
                    sb.append(" ");
                }
            }
            result.add(sb.toString());
        }

        for (int i = start + 1; i <= s.length(); i++) {
            String sub = s.substring(start, i);
            if (wordDict.contains(sub)) {
                current.add(sub);
                wordBreak(s, wordDict, i, current, result);
                current.remove(current.size() - 1);
            }
        }
    }
}
