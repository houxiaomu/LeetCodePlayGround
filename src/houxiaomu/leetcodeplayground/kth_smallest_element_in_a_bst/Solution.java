package houxiaomu.leetcodeplayground.kth_smallest_element_in_a_bst;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public int kthSmallest(TreeNode root, int k) {
        int n = countNode(root.left);
        if (n == k - 1) return root.val;
        else if (n > k - 1) {
            return kthSmallest(root.left, k);
        } else {
            return kthSmallest(root.right, k - n - 1);
        }
    }

    int countNode(TreeNode node) {
        if (node == null) return 0;
        int count = 1;
        if (node.left != null) count += countNode(node.left);
        if (node.right != null) count += countNode(node.right);
        return count;
    }
}
