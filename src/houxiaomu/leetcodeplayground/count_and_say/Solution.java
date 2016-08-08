package houxiaomu.leetcodeplayground.count_and_say;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-8-5.
 */
public class Solution extends BaseSolution {
    public String countAndSay(int n) {
        String s = "1";
        for (int i = 1; i < n; i++) {
            s = read(s);
        }
        return s;
    }

    private String read(String s) {
        StringBuilder sb = new StringBuilder();
        char prevC = '*';
        int repeat = 1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == prevC) {
                repeat++;
            } else {
                if (prevC != '*') {
                    sb.append(repeat).append(prevC);
                }
                prevC = c;
                repeat = 1;
            }
        }
        if (prevC != '*') {
            sb.append(repeat).append(prevC);
        }
        return sb.toString();
    }

}
