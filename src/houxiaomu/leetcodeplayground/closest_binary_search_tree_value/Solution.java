package houxiaomu.leetcodeplayground.closest_binary_search_tree_value;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2017/1/3.
 */
public class Solution extends BaseSolution {
    class Status {
        double diff;
        int val;

        Status() {
            diff = Double.MAX_VALUE;
        }
    }

    public int closestValue(TreeNode root, double target) {
        Status s = new Status();
        helper(root, target, s);
        return s.val;
    }

    void helper(TreeNode node, double target, Status status) {
        if (node == null) return;
        double diff = target - node.val;
        if (Math.abs(diff) < status.diff) {
            status.diff = Math.abs(diff);
            status.val = node.val;
        }
        if (diff > 0) {
            helper(node.right, target, status);
        } else if (diff < 0) {
            helper(node.left, target, status);
        }
    }
}
