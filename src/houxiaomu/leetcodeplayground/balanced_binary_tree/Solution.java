package houxiaomu.leetcodeplayground.balanced_binary_tree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/12/3.
 */
public class Solution extends BaseSolution {
    private int min = Integer.MAX_VALUE;
    private int max = Integer.MIN_VALUE;

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        search(root, 0);
        return (max - min <= 1);
    }

    private void search(TreeNode node, int level) {
        if (node == null) return;
        if (node.left == null && node.right == null) {
            if (level < min) min = level;
            if (level > max) max = level;
        }
        search(node.left, level + 1);
        search(node.right, level + 1);
    }
}
