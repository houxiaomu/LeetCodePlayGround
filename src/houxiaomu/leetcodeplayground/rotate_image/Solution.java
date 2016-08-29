package houxiaomu.leetcodeplayground.rotate_image;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by houxiaomu on 16-8-29.
 */
public class Solution extends BaseSolution {
    public void rotate(int[][] matrix) {
        final int n = matrix[0].length;
        final int half = n / 2;
        final boolean even = n % 2 == 0;
        for (int y = 0; (even && y < half) || (!even && y <= half); y++) {
            for (int x = 0; x < half; x++) {
                int tmp = matrix[y][x];
                matrix[y][x] = matrix[n - 1 - x][y];
                matrix[n - 1 - x][y] = matrix[n - 1 - y][n - 1 - x];
                matrix[n - 1 - y][n - 1 - x] = matrix[x][n - 1 - y];
                matrix[x][n - 1 - y] = tmp;
            }
        }
    }

    @Override
    protected void printResult(Object[] params, Object result) {
        int[][] matrix = (int[][]) params[0];
        System.out.println(Arrays.deepToString(matrix));
    }
}
