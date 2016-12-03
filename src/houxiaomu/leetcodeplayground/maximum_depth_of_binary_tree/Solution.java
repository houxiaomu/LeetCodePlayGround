package houxiaomu.leetcodeplayground.maximum_depth_of_binary_tree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/11/14.
 */
public class Solution extends BaseSolution {
    int max = 0;

    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        traverse(root, 1);
        return max;
    }

    void traverse(TreeNode node, int level) {
        if (level > max) max = level;
        if (node.left != null) traverse(node.left, level + 1);
        if (node.right != null) traverse(node.right, level + 1);
    }
}
