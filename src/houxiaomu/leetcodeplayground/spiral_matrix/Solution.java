package houxiaomu.leetcodeplayground.spiral_matrix;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by houxiaomu on 16-8-30.
 */
public class Solution extends BaseSolution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix.length == 0 || matrix[0].length == 0) return result;
        final int h = matrix.length;
        final int w = matrix[0].length;
        int x = 0;
        int y = 0;
        while (true) {
            int len = w - 1 - x * 2;
            if (len > 0) {
                readLine(matrix, x, y, 1, len, result);
            } else if (len == 0) {
                readLine(matrix, x, y, 1, 1, result);
                y++;
                if (result.size() == w * h) {
                    break;
                } else {
                    continue;
                }
            }

            len = h - 1 - y * 2;
            if (len > 0) {
                readCol(matrix, w - 1 - x, y, 1, len, result);
            } else if (len == 0) {
                readLine(matrix, w - 1 - x, y, 1, 1, result);
                break;
            }

            len = w - 1 - x * 2;
            if (len > 0) {
                readLine(matrix, w - 1 - x, h - 1 - y, -1, len, result);
            }

            len = h - 1 - y * 2;
            if (len > 0) {
                readCol(matrix, x, h - 1 - y, -1, len, result);
            }

            if (result.size() == w * h) {
                break;
            }
            x++;
            y++;
        }
        return result;
    }

    void readLine(int[][] matrix, int x, int y, int step, int len, List<Integer> result) {
        while (len > 0) {
            result.add(matrix[y][x]);
            x += step;
            len--;
        }
    }

    void readCol(int[][] matrix, int x, int y, int step, int len, List<Integer> result) {
        while (len > 0) {
            result.add(matrix[y][x]);
            y += step;
            len--;
        }
    }
}
