package houxiaomu.leetcodeplayground.path_sum_iii;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 2016/12/25.
 */
public class Solution extends BaseSolution {
    public int pathSum(TreeNode root, int sum) {
        if (root == null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return helper(root, 0, sum, map);
    }

    int helper(TreeNode node, int start, int target, Map<Integer, Integer> map) {
        if (node == null) {
            return 0;
        }
        int count = 0;
        int current = start + node.val;
        if (map.containsKey(current - target)) {
            count += map.get(current - target);
        }
        map.put(current, map.containsValue(current) ? map.get(current) + 1 : 1);
        count += helper(node.left, current, target, map);
        count += helper(node.right, current, target, map);
        map.put(current, map.get(current) - 1);
        return count;
    }


//    public int pathSum(TreeNode root, int sum) {
//        if (root == null) return 0;
//        return sumCurrentAsRoot(root, sum) + pathSum(root.left, sum) + pathSum(root.right, sum);
//    }
//
//    int sumCurrentAsRoot(TreeNode root, int sum) {
//        if (root == null) return 0;
//        int count = 0;
//        if (root.val == sum) {
//            count++;
//        }
//        int target = sum - root.val;
//        return count + sumCurrentAsRoot(root.left, target) + sumCurrentAsRoot(root.right, target);
//    }

}
