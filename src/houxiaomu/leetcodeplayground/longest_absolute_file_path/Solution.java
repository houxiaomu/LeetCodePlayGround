package houxiaomu.leetcodeplayground.longest_absolute_file_path;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Stack;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {
    public int lengthLongestPath(String input) {
        String[] lines = input.split("\n");
        int max = 0;
        int lastDirLen = 0;
        int lastDepth = 0;
        int currentPrefixLen = 0;
        Stack<Integer> stack = new Stack<>();
        for (String line : lines) {
            int pos = 0;
            while (pos < line.length() - 1 && line.charAt(pos) == '\\' && line.charAt(pos + 1) == 't') {
                pos += 2;
            }
            int currentLen = line.length() - pos;
            int depth = pos / 2;
            if (depth > lastDepth) {
                lastDepth = depth;
                stack.add(currentLen);
                currentPrefixLen += lastDirLen + 1;
                lastDirLen = currentLen;
            } else if (depth < lastDepth) {
                while (depth != lastDepth) {
                    lastDepth--;
                    lastDirLen = stack.pop();
                    currentPrefixLen -= lastDirLen + 1;
                }
            } else {
                lastDirLen = currentLen;
            }
            max = Math.max(max, currentPrefixLen + currentLen);
        }
        return max;
    }
}
