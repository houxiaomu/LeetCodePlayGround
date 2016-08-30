package houxiaomu.leetcodeplayground.spiral_matrix_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;

/**
 * Created by houxiaomu on 16-8-30.
 */
public class Solution extends BaseSolution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int number = 1;
        int x = 0;
        int y = 0;
        while (true) {
            int startNumber = number;
            int newNumber = fillRow(result, x, y, 1, number);
            if (newNumber != number) {
                x += newNumber - number - 1;
                y++;
                number = newNumber;
            }

            newNumber = fillCol(result, x, y, 1, number);
            if (newNumber != number) {
                y += newNumber - number - 1;
                x--;
                number = newNumber;
            }

            newNumber = fillRow(result, x, y, -1, number);
            if (newNumber != number) {
                x -= newNumber - number - 1;
                y--;
                number = newNumber;
            }

            newNumber = fillCol(result, x, y, -1, number);
            if (newNumber != number) {
                y -= newNumber - number - 1;
                x++;
                number = newNumber;
            }

            if (startNumber == number) break;
        }
        return result;
    }

    int fillRow(int[][] result, int x, int y, int step, int startNumber) {
        while (x >= 0 && x < result.length && y >= 0 && y < result.length && result[y][x] == 0) {
            result[y][x] = startNumber;
            startNumber++;
            x += step;
        }
        return startNumber;
    }

    int fillCol(int[][] result, int x, int y, int step, int startNumber) {
        while (x >= 0 && x < result.length && y >= 0 && y < result.length && result[y][x] == 0) {
            result[y][x] = startNumber;
            startNumber++;
            y += step;
        }
        return startNumber;
    }

    @Override
    protected void printResult(Object result) {
        int[][] array = (int[][]) result;
        System.out.println(Arrays.deepToString(array));
    }
}
