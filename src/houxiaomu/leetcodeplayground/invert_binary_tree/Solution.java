package houxiaomu.leetcodeplayground.invert_binary_tree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        if (root.left != null) invertTree(root.left);
        if (root.right != null) invertTree(root.right);
        return root;
    }
}
