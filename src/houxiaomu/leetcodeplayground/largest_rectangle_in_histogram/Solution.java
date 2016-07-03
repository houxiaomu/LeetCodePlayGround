package houxiaomu.leetcodeplayground.largest_rectangle_in_histogram;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-6-21.
 */
public class Solution extends BaseSolution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int totalWidth = 0;
            for (int k = i; k < heights.length; k++) {
                if (heights[k] < heights[i]) {
                    break;
                } else {
                    totalWidth++;
                    int area = (k - i + 1) * heights[i];
                    if (area > max) max = area;
                }
            }
            for (int k = i - 1; k >= 0; k--) {
                if (heights[k] < heights[i]) {
                    break;
                } else {
                    totalWidth++;
                    int area = (i - k + 1) * heights[i];
                    if (area > max) max = area;
                }
            }
            if (totalWidth > 0) {
                int area = totalWidth * heights[i];
                if (area > max) max = area;
            }

        }
        return max;
    }
}
