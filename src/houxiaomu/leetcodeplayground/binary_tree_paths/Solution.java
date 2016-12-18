package houxiaomu.leetcodeplayground.binary_tree_paths;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/12.
 */
public class Solution extends BaseSolution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root == null) return result;
        helper(root, result, new StringBuilder());
        return result;
    }

    void helper(TreeNode node, List<String> result, StringBuilder sb) {
        if (sb.length() != 0)
            sb.append("->");
        sb.append(node.val);
        if (node.left == null && node.right == null) {
            result.add(sb.toString());
            return;
        }
        if (node.left != null) helper(node.left, result, new StringBuilder(sb));
        if (node.right != null) helper(node.right, result, new StringBuilder(sb));
    }
}
