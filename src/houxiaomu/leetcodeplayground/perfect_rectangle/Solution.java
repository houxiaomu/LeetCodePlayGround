package houxiaomu.leetcodeplayground.perfect_rectangle;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {
    public boolean isRectangleCover(int[][] rectangles) {
        if (rectangles.length == 0 || rectangles.length == 1) return true;
        int area = 0;
        int bottom = Integer.MAX_VALUE;
        int left = Integer.MAX_VALUE;
        int top = Integer.MIN_VALUE;
        int right = Integer.MIN_VALUE;
        for (int[] rect : rectangles) {
            bottom = Math.min(bottom, rect[0]);
            left = Math.min(left, rect[1]);
            top = Math.max(top, rect[2]);
            right = Math.max(right, rect[3]);
            area += (rect[2] - rect[0]) * (rect[3] - rect[1]);
        }
        if ((right - left) * (top - bottom) != area) return false;
        for (int i = 0; i < rectangles.length; i++) {
            for (int j = i + 1; j < rectangles.length; j++) {
                if (isOverlay(rectangles[i], rectangles[j])) return false;
            }
        }
        return true;
    }

    boolean isOverlay(int[] r1, int[] r2) {
        boolean hOverlay = false;
        boolean vOverlay = false;
        if ((r1[0] >= r2[0] && r1[0] <= r2[2]) || (r1[2] >= r2[0] && r1[2] <= r2[2])
                || (r2[0] >= r1[0] && r2[0] <= r1[2]) || (r2[2] >= r1[0] && r2[2] <= r1[2])) {
            vOverlay = true;
        }
        if ((r1[1] >= r2[1] && r1[1] <= r2[3]) || (r1[3] >= r2[1] && r1[3] <= r2[3])
                || (r2[1] >= r1[1] && r2[1] <= r1[3]) || (r2[3] >= r1[1] && r2[3] <= r1[3])) {
            hOverlay = true;
        }
        return hOverlay & vOverlay;
    }
}
