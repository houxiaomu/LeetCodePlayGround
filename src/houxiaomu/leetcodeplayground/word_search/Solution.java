package houxiaomu.leetcodeplayground.word_search;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/11/18.
 */
public class Solution extends BaseSolution {
    public boolean exist(char[][] board, String word) {
        int h = board.length;
        if (h == 0)
            return false;
        int w = board[0].length;
        if (w == 0)
            return false;
        if (word.length() == 0) return false;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                boolean ret = search(board, h, w, col, row, word, 0, new boolean[h][w]);
                if (ret) return true;
            }
        }
        return false;
    }

    boolean search(char[][] board, int h, int w, int col, int row, String word, int wordPos, boolean[][] used) {
        if (col >= w || col < 0 || row < 0 || row >= h) return false;
        if (used[row][col]) return false;
        if (board[row][col] != word.charAt(wordPos)) {
            return false;
        }
        wordPos++;
        if (wordPos == word.length()) {
            return true;
        }
        used[row][col] = true;
        boolean result = search(board, h, w, col + 1, row, word, wordPos, used) ||
                search(board, h, w, col - 1, row, word, wordPos, used) ||
                search(board, h, w, col, row + 1, word, wordPos, used) ||
                search(board, h, w, col, row - 1, word, wordPos, used);
        if (!result) used[row][col] = false;
        return result;
    }
}
