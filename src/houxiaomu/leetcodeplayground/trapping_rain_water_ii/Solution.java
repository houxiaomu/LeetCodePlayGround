package houxiaomu.leetcodeplayground.trapping_rain_water_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by Simon on 2016/12/27.
 */
public class Solution extends BaseSolution {
//    public int trapRainWater(int[][] heightMap) {
//        if (heightMap.length == 0 || heightMap[0].length == 0) return 0;
//        int result = 0;
//        int[][] waterMap = new int[heightMap.length][heightMap[0].length];
//        for (int[] traps : waterMap) {
//            Arrays.fill(traps, -1);
//        }
//        History history = new History(heightMap.length, heightMap[0].length);
//        for (int i = 0; i < heightMap.length; i++) {
//            for (int j = 0; j < heightMap[0].length; j++) {
//                history.reset();
//                fill(heightMap, waterMap, i, j, history);
//            }
//        }
//        for (int i = 0; i < heightMap.length; i++) {
//            for (int j = 0; j < heightMap[0].length; j++) {
//                result += (waterMap[i][j] - heightMap[i][j]);
//            }
//        }
//        return result;
//    }
//
//
//    class History {
//        boolean[][] visited;
//        int currentWater;
//
//        History(int height, int width) {
//            visited = new boolean[height][width];
//            currentWater = Integer.MAX_VALUE;
//        }
//
//        void reset() {
//            for (boolean[] array : visited) {
//                Arrays.fill(array, false);
//            }
//            currentWater = Integer.MAX_VALUE;
//        }
//    }
//
//    int getCurrentWaterHeight(int height, int[][] heightMap, int[][] waterMap, int i, int j, History history) {
//        int water;
//        if (heightMap[i][j] <= height) {
//            if (history.visited[i][j]) {
//                water = history.currentWater;
//            } else {
//                history.visited[i][j] = true;
//                water = fill(heightMap, waterMap, i, j, history);
//            }
//        } else {
//            water = heightMap[i][j];
//        }
//        return water;
//    }
//
//    int fill(int[][] heightMap, int[][] waterMap, int i, int j, History history) {
//        if (waterMap[i][j] >= 0) return waterMap[i][j];
//        int height = heightMap[i][j];
//        if (i == 0 || i == heightMap.length - 1 || j == 0 || j == heightMap[0].length - 1) {
//            waterMap[i][j] = height;
//            return height;
//        }
//
//        int min = Integer.MAX_VALUE;
//        int water = getCurrentWaterHeight(height, heightMap, waterMap, i - 1, j, history);
//        if (water <= height) {
//            waterMap[i][j] = height;
//            return height;
//        }
//        min = water;
//
//        water = getCurrentWaterHeight(height, heightMap, waterMap, i + 1, j, history);
//        if (down <= height) {
//            waterMap[i][j] = height;
//            return height;
//        }
//        min = Math.min(min, down);
//
//        int left = heightMap[i][j - 1] <= height ? fill(heightMap, waterMap, i, j - 1) : heightMap[i][j - 1];
//        if (left <= height) {
//            waterMap[i][j] = height;
//            return height;
//        }
//        min = Math.min(min, left);
//
//
//        int right = heightMap[i][j + 1] <= height ? fill(heightMap, waterMap, i, j + 1) : heightMap[i][j + 1];
//        if (right <= height) {
//            waterMap[i][j] = height;
//            return height;
//        }
//        min = Math.min(min, right);
//        waterMap[i][j] = min;
//        return min;
//    }
}
