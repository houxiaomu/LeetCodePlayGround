package houxiaomu.leetcodeplayground.majority_element_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        if (nums.length < 3) {
            for (int n : nums) {
                result.add(n);
            }
            return result;
        }
        int pos = 0;
        int n1 = 0, n2 = 0;
        int count1 = 0, count2 = 0;
        while (pos < nums.length) {
            if (count1 == 0) {
                n1 = nums[pos];
                count1 = 1;
            } else if (count2 == 0) {
                n2 = nums[pos];
                count2 = 1;
            } else if (nums[pos] == n1) {
                count1++;
            } else if (nums[pos] == n2) {
                count2++;
            } else {
                count1--;
                count2--;
            }
            pos++;
        }
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == n1) count1++;
            else if (nums[i] == n2) count2++;
        }
        if (count1 > nums.length / 3) result.add(n1);
        if (count2 > nums.length / 3) result.add(n2);
        return result;
    }
}
