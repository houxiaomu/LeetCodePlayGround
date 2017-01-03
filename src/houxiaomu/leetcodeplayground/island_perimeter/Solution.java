package houxiaomu.leetcodeplayground.island_perimeter;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/22.
 */
public class Solution extends BaseSolution {
    public int islandPerimeter(int[][] grid) {
        if (grid.length == 0 || grid[0].length == 0) return 0;
        final int h = grid.length;
        final int w = grid[0].length;
        int p = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (grid[i][j] == 0) {
                    if (i > 0 && grid[i - 1][j] == 1) p++; //top edge
                    if (j > 0 && grid[i][j - 1] == 1) p++; //left edge
                } else {
                    if (i == 0 || grid[i - 1][j] == 0) p++; //top edge
                    if (j == 0 || grid[i][j - 1] == 0) p++; //left edge
                }
            }
            if (grid[i][w - 1] == 1) p++; //right edge
        }

        //bottom edge
        for (int j = 0; j < w; j++) {
            if (grid[h - 1][j] == 1) {
                p++;
            }
        }
        return p;
    }
}
