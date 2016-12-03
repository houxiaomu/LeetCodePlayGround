package houxiaomu.leetcodeplayground.simplify_path;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.LinkedList;

/**
 * Created by Simon on 2016/10/21.
 */
public class Solution extends BaseSolution {
    public String simplifyPath(String path) {
        LinkedList<String> dir = new LinkedList<>();
        String[] split = path.split("/");
        for (String s : split) {
            if (s.isEmpty()) continue;
            else if (s.equals(".")) continue;
            else if (s.equals("..")) {
                if (dir.size() > 0) {
                    dir.removeLast();
                }
            } else {
                dir.add(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (String s : dir) {
            sb.append("/").append(s);
        }
        if (sb.length() == 0) sb.append("/");
        return sb.toString();
    }
}
