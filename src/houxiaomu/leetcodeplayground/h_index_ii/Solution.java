package houxiaomu.leetcodeplayground.h_index_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/14.
 */
public class Solution extends BaseSolution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        if (citations.length == 1) return citations[0] >= 1 ? 1 : 0;
        int low = 0, high = citations.length - 1;
        int max = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (mid + 1 >= citations[mid]) {
                max = mid + 1;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return max;
    }
}
