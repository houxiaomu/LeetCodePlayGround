package houxiaomu.leetcodeplayground.decode_string;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Stack;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {
    class Level {
        int number;
        StringBuilder current;

        Level(int number, StringBuilder current) {
            this.number = number;
            this.current = current;
        }
    }

    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Level> stack = new Stack<>();
        int pos = 0;
        while (pos < s.length()) {
            char c = s.charAt(pos);
            if (Character.isDigit(c)) {
                int n = c - '0';
                while (++pos < s.length() && Character.isDigit(s.charAt(pos))) {
                    n *= 10;
                    n += s.charAt(pos) - '0';
                }
                stack.add(new Level(n, sb));
                sb = new StringBuilder();
                pos++; // skip '['
            } else if (c == ']') {
                Level level = stack.pop();
                for (int i = 0; i < level.number; i++) {
                    level.current.append(sb);
                }
                sb = level.current;
                pos++;
            } else {
                sb.append(c);
                pos++;
            }
        }
        return sb.toString();
    }
}
