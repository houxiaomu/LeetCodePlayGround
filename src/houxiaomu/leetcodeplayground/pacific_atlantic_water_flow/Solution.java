package houxiaomu.leetcodeplayground.pacific_atlantic_water_flow;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/27.
 */
public class Solution extends BaseSolution {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        final int h = matrix.length;
        final int w = matrix[0].length;
        boolean[][] pacific = new boolean[h][w];
        boolean[][] atlantic = new boolean[h][w];

        for (int i = 0; i < h; i++) {
            pacific[i][0] = true;
            atlantic[i][w - 1] = true;
        }
        for (int j = 0; j < w; j++) {
            pacific[0][j] = true;
            atlantic[h - 1][j] = true;
        }

        for (int i = 0; i < h; i++) {
            fill(matrix, pacific, i, 0);
            fill(matrix, atlantic, i, w - 1);
        }
        for (int j = 0; j < w; j++) {
            fill(matrix, pacific, 0, j);
            fill(matrix, atlantic, h - 1, j);
        }

        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new int[]{i, j});
                }
            }
        }
        return result;
    }

    void fill(int[][] matrix, boolean[][] ocean, int i, int j) {
        //UP
        if (i > 0 && !ocean[i - 1][j] && matrix[i - 1][j] >= matrix[i][j]) {
            ocean[i - 1][j] = true;
            fill(matrix, ocean, i - 1, j);
        }

        //DOWN
        if (i < matrix.length - 1 && !ocean[i + 1][j] && matrix[i + 1][j] >= matrix[i][j]) {
            ocean[i + 1][j] = true;
            fill(matrix, ocean, i + 1, j);
        }

        //LEFT
        if (j > 0 && !ocean[i][j - 1] && matrix[i][j - 1] >= matrix[i][j]) {
            ocean[i][j - 1] = true;
            fill(matrix, ocean, i, j - 1);
        }

        //RIGHT
        if (j < matrix[0].length - 1 && !ocean[i][j + 1] && matrix[i][j + 1] >= matrix[i][j]) {
            ocean[i][j + 1] = true;
            fill(matrix, ocean, i, j + 1);
        }
    }

    @Override
    protected void printResult(Object result) {
        List<int[]> list = (List<int[]>) result;
        for (int[] array : list) {
            System.out.print("[" + array[0] + "," + array[1] + "]");
        }
        System.out.println();
    }
}
