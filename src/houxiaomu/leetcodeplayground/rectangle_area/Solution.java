package houxiaomu.leetcodeplayground.rectangle_area;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public int computeArea(int a, int b, int c, int d, int e, int f, int g, int h) {
        int total = (c - a) * (d - b) + (g - e) * (h - f);
        int left = 0;
        if (a <= e && e <= c) {
            left = e;
        } else if (e <= a && a <= g) {
            left = a;
        } else
            return total;

        int bottom = 0;
        if (f <= b && b <= h) {
            bottom = b;
        } else if (b <= f && f <= d) {
            bottom = f;
        } else
            return total;

        int right = 0;
        if (e <= c && c <= g) {
            right = c;
        } else if (a <= g && g <= c) {
            right = g;
        } else
            return total;

        int top = 0;
        if (b <= h && h <= d) {
            top = h;
        } else if (f <= d && d <= h) {
            top = d;
        } else return total;

        return total - (right - left) * (top - bottom);
    }
}
