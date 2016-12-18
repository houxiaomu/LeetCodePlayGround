package houxiaomu.leetcodeplayground.matchsticks_to_square;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public boolean makesquare(int[] nums) {
        if (nums.length < 4) return false;
        int len = 0;
        for (int n : nums) {
            len += n;
        }
        if (len % 4 != 0) return false;
        len /= 4;

        Arrays.sort(nums);
        if (nums[nums.length - 1] > len) return false;

        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int n = nums[i];
            if (map.containsKey(n)) {
                map.put(n, map.get(n) + 1);
            } else {
                map.put(n, 1);
            }
        }

        if (helper(nums, len, map) && helper(nums, len, map) && helper(nums, len, map))
            return true;
        return false;
    }

    boolean helper(int[] nums, int target, Map<Integer, Integer> map) {
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int n = it.next();
            int count = map.get(n);
            if (count == 0) continue;
            if (n > target) return false;
            map.put(n, --count);
            if (n == target) {
                return true;
            } else {
                if (helper(nums, target - n, map)) {
                    return true;
                }
                map.put(n, ++count);
            }
        }
        return false;
    }
}
