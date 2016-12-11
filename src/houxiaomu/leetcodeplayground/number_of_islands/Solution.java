package houxiaomu.leetcodeplayground.number_of_islands;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/9.
 */
public class Solution extends BaseSolution {
    public int numIslands(char[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (search(grid, i, j)) count++;
            }
        }
        return count;
    }

    boolean search(char[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length) return false;
        if (grid[i][j] == '1') {
            grid[i][j] = '*';
            search(grid, i + 1, j);
            search(grid, i - 1, j);
            search(grid, i, j + 1);
            search(grid, i, j - 1);
            return true;
        }
        return false;
    }
}
