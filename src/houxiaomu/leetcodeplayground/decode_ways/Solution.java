package houxiaomu.leetcodeplayground.decode_ways;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/6/19.
 */
public class Solution extends BaseSolution {
    public int numDecodings(String s) {
        return search(s, 0);
    }

    private int search(String s, int startPos) {
        int remain = s.length() - startPos;
        if (remain == 0) {
            return 0;
        } else if (remain == 1) {
            return s.substring(startPos, startPos + 1).equals("0") ? 0 : 1;
        } else {
            int val = Integer.valueOf(s.substring(startPos, startPos + 2));
            if (remain == 2) {
                if (val < 10) {
                    return 0;
                } else if (val <= 26 && val != 10 && val != 20) {
                    return 2;
                }
                return 1;
            } else {
                int ret1 = search(s, startPos + 1);
                if (ret1 > 0) {
                    int ret2 = ((val >= 10 && val <= 26) ? search(s, startPos + 2) : 0);
                    if (ret2 > 0) {
                        return ret1 + ret2;
                    }
                } else {

                }
                return 0;

            }
        }
    }
}
