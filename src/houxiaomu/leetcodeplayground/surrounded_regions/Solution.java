package houxiaomu.leetcodeplayground.surrounded_regions;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {

    public void solve(char[][] board) {
        int h = board.length;
        if (h == 0) return;
        int w = board[0].length;
        for (int row = 0; row < h; row++) {
            for (int col = 0; col < w; col++) {
                if (board[row][col] == 'O') {
                    boolean[][] visited = new boolean[h][w];
                    boolean b = hasWayOut(board, h, w, row, col, visited);
                    if (!b) {
                        for (int i = 0; i < h; i++) {
                            for (int j = 0; j < w; j++) {
                                if (visited[i][j]) board[i][j] = 'X';
                            }
                        }
                    }
                }
            }
        }
    }

    boolean hasWayOut(char[][] board, int h, int w, int row, int col, boolean[][] visited) {
        if (board[row][col] == 'X')
            return false;
        if (row == 0 || row == h - 1 || col == 0 || col == w - 1) return true;
        visited[row][col] = true;
        if (!visited[row + 1][col] && hasWayOut(board, h, w, row + 1, col, visited)) {
            return true;
        }
        if (!visited[row - 1][col] && hasWayOut(board, h, w, row - 1, col, visited)) {
            return true;
        }
        if (!visited[row][col + 1] && hasWayOut(board, h, w, row, col + 1, visited)) {
            return true;
        }
        if (!visited[row][col - 1] && hasWayOut(board, h, w, row, col - 1, visited)) {
            return true;
        }

        return false;
    }

    @Override
    protected void printResult(Object[] params, Object result) {
        char[][] board = (char[][]) params[0];
        System.out.println(Arrays.deepToString(board));
    }
}
