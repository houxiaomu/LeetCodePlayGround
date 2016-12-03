package houxiaomu.leetcodeplayground.search_a_2d_matrix;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/10/28.
 */
public class Solution extends BaseSolution {
    public boolean searchMatrix(int[][] matrix, int target) {
        final int rowNum = matrix.length;
        if (rowNum == 0) return false;
        final int col = matrix[0].length;
        for (int i = 0; i < rowNum; i++) {
            if (target < matrix[i][0]) break;
            if (searchRow(matrix[i], target)) return true;
        }
        return false;
    }

    private boolean searchRow(int[] row, int target) {
        final int len = row.length;
        int start = 0, end = len - 1;

        while (start <= end) {
            final int pos = (start + end) / 2;
            if (target == row[pos]) {
                return true;
            } else if (target > row[pos]) {
                start = pos + 1;
            } else {
                end = pos - 1;
            }
        }
        return false;
    }
}
