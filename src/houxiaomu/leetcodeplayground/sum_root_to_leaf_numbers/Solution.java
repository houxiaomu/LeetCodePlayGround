package houxiaomu.leetcodeplayground.sum_root_to_leaf_numbers;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {
    private int sum;

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        sum = 0;
        helper(root, 0);
        return sum;
    }

    void helper(TreeNode node, int pathVal) {
        pathVal = pathVal * 10 + node.val;
        if (node.left == null && node.right == null) {
            sum += pathVal;
            return;
        }

        if (node.left != null) {
            helper(node.left, pathVal);
        }
        if (node.right != null) {
            helper(node.right, pathVal);
        }
    }
}
