package houxiaomu.leetcodeplayground.validate_binary_search_tree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/6/14.
 */
public class Solution extends BaseSolution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isInRange(root.left, null, root.val) && isInRange(root.right, root.val, null);
    }

    private boolean isInRange(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        if ((max != null && node.val >= max) || (min != null && node.val <= min)) {
            return false;
        }
        if (node.left == null && node.right == null) {
            return true;
        }
        return isInRange(node.left, min, node.val) && isInRange(node.right, node.val, max);
    }
}
