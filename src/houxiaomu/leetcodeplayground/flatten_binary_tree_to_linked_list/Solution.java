package houxiaomu.leetcodeplayground.flatten_binary_tree_to_linked_list;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;
import houxiaomu.leetcodeplayground.TreePrinter;

import java.util.Stack;

/**
 * Created by Simon on 2016/12/3.
 */
public class Solution extends BaseSolution {
    public void flatten(TreeNode root) {
        System.out.println("input:");
        TreePrinter.printNode(root);

        if (root == null) return;

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode last = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.right != null) stack.push(node.right);
            if (node.left != null) stack.push(node.left);
            if (last != null) {
                last.right = node;
                last.left = null;
            }
            last = node;
        }
    }

    @Override
    protected void printResult(Object[] params, Object result) {
        TreeNode root = (TreeNode) params[0];
        System.out.println("output:");
        TreePrinter.printNode(root);
    }
}
