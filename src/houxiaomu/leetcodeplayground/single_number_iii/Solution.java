package houxiaomu.leetcodeplayground.single_number_iii;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/12.
 */
public class Solution extends BaseSolution {
    public int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }

        int mask = 1;
        while ((diff & 0x1) == 0) {
            diff >>= 1;
            mask <<= 1;
        }

        int n1 = 0, n2 = 0;
        for (int i : nums) {
            if ((i & mask) == 0) {
                n1 ^= i;
            } else {
                n2 ^= i;
            }
        }

        result[0] = n1;
        result[1] = n2;
        return result;
    }
}
