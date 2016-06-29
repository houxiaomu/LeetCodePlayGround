package houxiaomu.leetcodeplayground.zigzag_conversion;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-6-29.
 */
public class Solution extends BaseSolution {
    public String convert(String s, int numRows) {
        if (s.equals("") || numRows == 1 || numRows == 0) {
            return s;
        }

        StringBuilder lines[] = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            lines[i] = new StringBuilder();
        }

        int pos = 0, y = 0;
        boolean down = true;
        while (pos < s.length()) {
            lines[y].append(s.charAt(pos));
            if (y == 0) {
                down = true;
            } else if (down && y == numRows - 1) {
                down = false;
            }

            if (down) {
                y++;
            } else {
                y--;
            }
            pos++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            sb.append(lines[i].toString());
        }
        return sb.toString();
    }
}
