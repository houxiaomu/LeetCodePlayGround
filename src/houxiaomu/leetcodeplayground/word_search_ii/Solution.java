package houxiaomu.leetcodeplayground.word_search_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Simon on 2016/12/10.
 */
public class Solution extends BaseSolution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                for (int w = 0; w < words.length; w++) {
                    search(board, i, j, 0, words[w], result, new boolean[board.length][board[0].length]);
                }
            }
        }
        List<String> ret = new ArrayList<>();
        for (String s : result) {
            ret.add(s);
        }
        return ret;
    }

    void search(char[][] board, int i, int j, int pos, String word, Set<String> result, boolean used[][]) {
        if (i < 0 || j < 0 || i == board.length || j == board[0].length) return;
        if (used[i][j]) return;
        if (board[i][j] == word.charAt(pos)) {
            if (pos == word.length() - 1) {
                result.add(word);
                return;
            }
            used[i][j] = true;
            pos++;
            search(board, i + 1, j, pos, word, result, used);
            search(board, i - 1, j, pos, word, result, used);
            search(board, i, j + 1, pos, word, result, used);
            search(board, i, j - 1, pos, word, result, used);
            used[i][j] = false;
        }
    }
}
