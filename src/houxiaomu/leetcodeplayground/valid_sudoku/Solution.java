package houxiaomu.leetcodeplayground.valid_sudoku;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-8-1.
 */
public class Solution extends BaseSolution {
    public boolean isValidSudoku(char[][] board) {
        final int len = 9;
        if (board == null || board.length != len || board[0].length != len) {
            return false;
        }
        boolean[] tmp = new boolean[len];
        char c;

        // check line
        for (int i = 0; i < len; i++) {
            for (int t = 0; t < len; t++) tmp[t] = false;
            for (int j = 0; j < len; j++) {
                c = board[i][j];
                if (c == '.') {
                    continue;
                }

                if (c >= '1' && c <= '9') {
                    if (tmp[c - '1']) {
                        //has repeat number;
                        return false;
                    }
                    tmp[c - '1'] = true;
                } else {
                    return false;
                }
            }
        }

        // check column
        for (int i = 0; i < len; i++) {
            for (int t = 0; t < len; t++) tmp[t] = false;
            for (int j = 0; j < len; j++) {
                c = board[j][i];
                if (c == '.') {
                    continue;
                }

                if (c >= '1' && c <= '9') {
                    if (tmp[c - '1']) {
                        //has repeat number;
                        return false;
                    }
                    tmp[c - '1'] = true;
                } else {
                    return false;
                }
            }
        }

        // check 3x3
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int t = 0; t < len; t++) tmp[t] = false;
                for (int y = 0; y < 3; y++) {
                    for (int x = 0; x < 3; x++) {
                        c = board[y + i*3][x + j*3];
                        if (c == '.') {
                            continue;
                        }

                        if (c >= '1' && c <= '9') {
                            if (tmp[c - '1']) {
                                //has repeat number;
                                return false;
                            }
                            tmp[c - '1'] = true;
                        } else {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}
