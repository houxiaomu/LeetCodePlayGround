package houxiaomu.leetcodeplayground.total_hamming_distance;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public int totalHammingDistance(int[] nums) {
        int[] onebits = new int[32];
        int[] zerobits = new int[32];
        for (int n : nums) {
            for (int i = 0; i < 32; i++) {
                if ((n & 0x1) == 0) {
                    zerobits[i]++;
                } else {
                    onebits[i]++;
                }
                n >>= 1;
            }
        }
        int total = 0;
        for (int i = 0; i < 32; i++) {
            total += zerobits[i] * onebits[i];
        }
        return total;
    }
}
