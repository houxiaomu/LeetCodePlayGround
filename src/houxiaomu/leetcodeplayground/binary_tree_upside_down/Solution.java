package houxiaomu.leetcodeplayground.binary_tree_upside_down;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        TreeNode node = root;
        TreeNode parent = null;
        TreeNode parentRight = null;
        while (node != null) {
            TreeNode left = node.left;
            TreeNode right = node.right;
            node.left = parentRight;
            node.right = parent;
            parent = node;
            parentRight = right;
            if (left == null) return node;
            node = left;
        }
        return null;
    }
}
