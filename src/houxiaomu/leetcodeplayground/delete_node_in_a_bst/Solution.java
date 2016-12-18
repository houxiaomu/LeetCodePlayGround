package houxiaomu.leetcodeplayground.delete_node_in_a_bst;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        TreeNode parent = root, node = root;
        while (node != null) {
            if (key > node.val) {
                parent = node;
                node = node.right;
            } else if (key < node.val) {
                parent = node;
                node = node.left;
            } else break;
        }

        // not found
        if (node == null) return root;

        // root parent to delete
        if (parent == node) {
            return deleteThisNode(node);
        } else if (key > parent.val) {
            parent.right = deleteThisNode(node);
        } else {
            parent.left = deleteThisNode(node);
        }
        return root;
    }

    TreeNode deleteThisNode(TreeNode root) {
        if (root.left == null) {
            return root.right;
        }
        if (root.right == null) {
            return root.left;
        }
        TreeNode node = root.left;
        TreeNode parent = null;
        while (node.right != null) {
            parent = node;
            node = node.right;
        }
        node.right = root.right;
        if (parent != null) {
            parent.right = null;
            TreeNode left = node;
            while (left.left != null) {
                left = left.left;
            }
            node.left = root.left;
        }
        return node;
    }
}
