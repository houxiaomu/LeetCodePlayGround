package houxiaomu.leetcodeplayground.sudoku_solver;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashSet;

/**
 * Created by Simon on 2016/8/3.
 */
public class Solution extends BaseSolution {
    public void solveSudoku(char[][] board) {
        final int len = 9;
        HashSet[][] candidates = new HashSet[9][9];

        while (true) {
            boolean done = true;
            for (int y = 0; y < len; y++) {
                for (int x = 0; x < len; x++) {
                    boolean ret = fillCandidates(board, candidates, x, y);
                    if (!ret) {
                        done = false;
                    }
                }
            }
            if (done) break;
            //dump(board);
        }
    }

    boolean fillCandidates(char[][] board, HashSet[][] candidates, int x, int y) {
        char c = board[x][y];
        if (c >= '1' && c <= '9') {
            return true;
        }

        if (candidates[x][y] == null) {
            candidates[x][y] = new HashSet();
            for (int i = 0; i < 9; i++) {
                candidates[x][y].add((char) ('1' + i));
            }
        }
        final HashSet candidate = candidates[x][y];

        for (int i = 0; i < 9; i++) {
            c = board[x][i];
            if (c >= '1' && c <= '9') {
                candidate.remove(c);
            }
        }

        for (int i = 0; i < 9; i++) {
            c = board[i][y];
            if (c >= '1' && c <= '9') {
                candidate.remove(c);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                c = board[i + x / 3 * 3][j + y / 3 * 3];
                if (c >= '1' && c <= '9') {
                    candidate.remove(c);
                }
            }
        }

        if (candidate.size() == 1) {
            board[x][y] = (char) candidate.iterator().next();
            return true;
        }

        return false;
    }

    void dump(char[][] board) {
        for (char[] line : board) {
            for (char c : line) {
                System.out.print(c);
            }
            System.out.println();
        }
        System.out.println();
    }
}
