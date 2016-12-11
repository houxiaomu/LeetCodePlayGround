package houxiaomu.leetcodeplayground.binary_tree_maximum_path_sum;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {
    int max = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) return 0;
        helper(root);
        return max;
    }

    int helper(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, helper(node.left));
        int right = Math.max(0, helper(node.right));
        max = Math.max(max, node.val + left + right);
        return node.val + Math.max(left, right);
    }
}
