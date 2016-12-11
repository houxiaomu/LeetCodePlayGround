package houxiaomu.leetcodeplayground.contains_duplicate_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length < 2) return false;

        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = map.get(nums[i]);
            if (list == null) {
                list = new ArrayList<>();
                map.put(nums[i], list);
            }
            list.add(i);
        }

        for (int key : map.keySet()) {
            List<Integer> list = map.get(key);
            if (list.size() > 1) {
                for (int i = 1; i < list.size(); i++) {
                    if (list.get(i) - list.get(i - 1) <= k)
                        return true;
                }
            }
        }
        return false;
    }
}
