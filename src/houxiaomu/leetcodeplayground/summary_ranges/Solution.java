package houxiaomu.leetcodeplayground.summary_ranges;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<String>();
        int pos = 0;
        String s = null;
        int start = 0;
        int prev = 0;
        while (pos < nums.length) {
            if (s == null) {
                start = nums[pos];
                s = String.valueOf(start);
                prev = start;
            } else if (prev + 1 == nums[pos]) {
                prev = nums[pos];
            } else {
                if (prev != start) {
                    s += "->" + String.valueOf(prev);
                }
                result.add(s);
                start = nums[pos];
                s = String.valueOf(start);
                prev = start;
            }
            pos++;
        }

        if (s != null) {
            if (prev != start) {
                s += "->" + String.valueOf(prev);
            }
            result.add(s);
        }
        return result;
    }
}
