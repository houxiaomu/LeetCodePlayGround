package houxiaomu.leetcodeplayground.binary_tree_longest_consecutive_sequence;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2017/1/3.
 */
public class Solution extends BaseSolution {
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }

    int helper(TreeNode node) {
        int max = 1;
        if (node.left != null) {
            int childMax = helper(node.left);
            if (node.left.val - node.val == 1) childMax++;
            max = Math.max(max, childMax);
        } else if (node.right != null) {
            int childMax = helper(node.right);
            if (node.right.val - node.val == 1) childMax++;
            max = Math.max(max, childMax);
        }
        return max;
    }
}
