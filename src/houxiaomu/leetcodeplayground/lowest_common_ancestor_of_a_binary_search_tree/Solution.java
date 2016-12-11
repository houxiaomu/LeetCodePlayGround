package houxiaomu.leetcodeplayground.lowest_common_ancestor_of_a_binary_search_tree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    @Override
    public boolean runCustomizedTestCases() {
        TreeNode root = new TreeNode(6);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(0);
        root.left.right = new TreeNode(4);
        root.left.right.left = new TreeNode(3);
        root.left.right.right = new TreeNode(5);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(9);
        System.out.println("node = " + lowestCommonAncestor(root, root.left, root.right));
        System.out.println("node = " + lowestCommonAncestor(root, root.left, root.left.right));
        return true;
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pathP = new ArrayList<>();
        List<TreeNode> pathQ = new ArrayList<>();
        helper(root, p, q, pathP, pathQ, new ArrayList<TreeNode>());
        TreeNode result = root;
        for (int i = 0; i < Math.min(pathP.size(), pathQ.size()); i++) {
            if (pathP.get(i) != pathQ.get(i)) {
                break;
            }
            result = pathP.get(i);
        }
        return result;
    }

    void helper(TreeNode node, TreeNode p, TreeNode q, List<TreeNode> pathP, List<TreeNode> pathQ, List<TreeNode> path) {
        if (node == p) {
            pathP.addAll(path);
            pathP.add(node);
        } else if (node == q) {
            pathQ.addAll(path);
            pathQ.add(node);
        }
        if (node.left == null && node.right == null) {
            return;
        }
        path.add(node);
        if (node.left != null) helper(node.left, p, q, pathP, pathQ, path);
        if (node.right != null) helper(node.right, p, q, pathP, pathQ, path);
        path.remove(path.size() - 1);
    }
}
