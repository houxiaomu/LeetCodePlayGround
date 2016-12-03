package houxiaomu.leetcodeplayground.binary_tree_inorder_traversal;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Simon on 2016/11/14.
 */
public class Solution extends BaseSolution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null || !stack.isEmpty()) {
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            result.add(node.val);
            node = node.right;
        }
        return result;
    }

//    public List<Integer> inorderTraversal(TreeNode root) {
//        List<Integer> result = new ArrayList<>();
//        if (root == null) return result;
//            traverse(root, result);
//        return result;
//    }
//
//    private void traverse(TreeNode node, List<Integer> result) {
//        if (node.left != null) {
//            traverse(node.left, result);
//        }
//        result.add(node.val);
//        if (node.right != null) {
//            traverse(node.right, result);
//        }
//    }
}
