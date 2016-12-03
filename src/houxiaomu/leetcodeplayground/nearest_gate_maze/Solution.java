package houxiaomu.leetcodeplayground.nearest_gate_maze;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Simon on 2016/11/19.
 */
public class Solution extends BaseSolution {

    private class Pos {
        int row;
        int col;

        public Pos(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void cacluateMaze(char[][] maze) {
        final int m = maze.length;
        final int n = maze[0].length;

        List<Pos> gates = new ArrayList<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (maze[row][col] == 'G') {
                    gates.add(new Pos(row, col));
                }
            }
        }

        for (Pos pos : gates) {
            calculate(maze, pos.row, pos.col, m, n, 1);
        }
    }

    private void calculate(char[][] maze, int row, int col, int m, int n, int step) {
        //UP
        if (row > 0) {
            char c = maze[row - 1][col];
            if (c == '_' || c != 'W' && c != 'G' && c - '0' > step) {
                maze[row - 1][col] = (char) (step + '0');
                calculate(maze, row - 1, col, m, n, step + 1);
            }
        }

        //DOWN
        if (row < m - 1) {
            char c = maze[row + 1][col];
            if (c == '_' || c != 'W' && c != 'G' && c - '0' > step) {
                maze[row + 1][col] = (char) (step + '0');
                calculate(maze, row + 1, col, m, n, step + 1);
            }
        }

        //LEFT
        if (col > 0) {
            char c = maze[row][col - 1];
            if (c == '_' || c != 'W' && c != 'G' && c - '0' > step) {
                maze[row][col - 1] = (char) (step + '0');
                calculate(maze, row, col - 1, m, n, step + 1);
            }
        }

        //RIGHT
        if (col < n - 1) {
            char c = maze[row][col + 1];
            if (c == '_' || c != 'W' && c != 'G' && c - '0' > step) {
                maze[row][col + 1] = (char) (step + '0');
                calculate(maze, row, col + 1, m, n, step + 1);
            }
        }
    }

    @Override
    protected void printResult(Object[] params, Object result) {
        char[][] maze = (char[][]) params[0];
        System.out.println("maze:" + Arrays.deepToString(maze));
    }
}
