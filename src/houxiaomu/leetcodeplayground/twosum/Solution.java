package houxiaomu.leetcodeplayground.twosum;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by houxiaomu on 16-6-13.
 */
public class Solution extends BaseSolution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int n = target - nums[i];
            if (map.containsKey(n)) {
                result[0] = map.get(n);
                result[1] = i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
}
