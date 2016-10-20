package houxiaomu.leetcodeplayground.minimum_path_sum;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/10/20.
 */
public class Solution extends BaseSolution {
    public int minPathSum(int[][] grid) {
        int h = grid.length;
        int w = grid[0].length;
        int[][] cache = new int[h][w];
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                cache[y][x] = -1;
            }
        }
        return doRecursive(grid, 0, 0, w, h, cache);
    }

    private int doRecursive(int[][] grid, int x, int y, int w, int h, int[][] cache) {
        if (cache[y][x] >= 0) return cache[y][x];

        int right = -1, down = -1;
        if (x < w - 1) right = doRecursive(grid, x + 1, y, w, h, cache);
        if (y < h - 1) down = doRecursive(grid, x, y + 1, w, h, cache);
        int value = grid[y][x];
        if (right >= 0 && down >= 0) {
            value += Math.min(right, down);
        } else if (right >= 0 && down < 0) {
            value += right;
        } else if (right < 0 && down >= 0) {
            value += down;
        }
        cache[y][x] = value;
        return value;
    }
}
