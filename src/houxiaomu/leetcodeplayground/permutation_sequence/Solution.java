package houxiaomu.leetcodeplayground.permutation_sequence;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-8-30.
 */
public class Solution extends BaseSolution {
    int count;
    String result;
    String current;
    String num;

    public String getPermutation(int n, int k) {
        count = 0;
        result = "";
        current = "";
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }
        num = sb.toString();
        permutation(k, new boolean[n]);
        return result;
    }

    void permutation(int k, boolean[] used) {
        if (num.length() == current.length()) {
            count++;
            //System.out.println(count + "th = " + current);
            if (count == k) {
                result = current;
            }
        } else {
            for (int i = 0; i < num.length(); i++) {
                if (used[i]) continue;
                char c = num.charAt(i);
                used[i] = true;
                current += c;
                permutation(k, used);
                current = current.substring(0, current.length() - 1);
                used[i] = false;
            }
        }
    }
}
