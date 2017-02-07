package houxiaomu.leetcodeplayground.most_frequent_subtree_sum;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 2017/2/6.
 */
public class Solution extends BaseSolution {
    int maxCount;

    public int[] findFrequentTreeSum(TreeNode root) {
        maxCount = 0;
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map);

        int resCount = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) resCount++;
        }

        int[] res = new int[resCount];
        resCount = 0;
        for (Integer key : map.keySet()) {
            if (map.get(key) == maxCount) res[resCount++] = key;
        }
        return res;
    }

    int helper(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) return 0;
        int left = helper(node.left, map);
        int right = helper(node.right, map);
        int sum = left + right + node.val;
        int count = map.containsKey(sum) ? map.get(sum) + 1 : 1;
        map.put(sum, count);
        if (count > maxCount) maxCount = count;
        return sum;
    }
}
