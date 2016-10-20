package houxiaomu.leetcodeplayground.unique_paths2;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 2016/10/20.
 */
public class Solution extends BaseSolution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        return doRecursive(obstacleGrid, 0, 0, obstacleGrid[0].length, obstacleGrid.length, new HashMap<String, Integer>());
    }

    private int doRecursive(int[][] obstacleGrid, int x, int y, int w, int h, Map<String, Integer> cache) {
        if (y == h - 1) {
            for (int i = x; i < w; i++) {
                if (obstacleGrid[y][i] == 1) return 0;
            }
            return 1;
        } else if (x == w - 1) {
            for (int i = y; i < h; i++) {
                if (obstacleGrid[i][x] == 1) return 0;
            }
            return 1;
        }
        if (obstacleGrid[y][x] == 1) return 0;
        String key1 = x + "_" + y;
        if (cache.containsKey(key1)) return cache.get(key1);
        int value = doRecursive(obstacleGrid, x + 1, y, w, h, cache) +
                doRecursive(obstacleGrid, x, y + 1, w, h, cache);
        cache.put(key1, value);
        return value;
    }
}
