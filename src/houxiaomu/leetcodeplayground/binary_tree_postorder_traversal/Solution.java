package houxiaomu.leetcodeplayground.binary_tree_postorder_traversal;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.*;

/**
 * Created by Simon on 2016/12/5.
 */
public class Solution extends BaseSolution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        Set<TreeNode> map = new HashSet<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (node.left == null && node.right == null) {
                stack.pop();
                result.add(node.val);
                continue;
            }
            if (map.contains(node)) {
                stack.pop();
                result.add(node.val);
            } else {
                map.add(node);
                if (node.right != null) {
                    stack.add(node.right);
                }
                if (node.left != null) {
                    stack.add(node.left);
                }
            }

        }
        return result;
    }
}
