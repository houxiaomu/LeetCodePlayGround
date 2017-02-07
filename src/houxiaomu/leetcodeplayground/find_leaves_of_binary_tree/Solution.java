package houxiaomu.leetcodeplayground.find_leaves_of_binary_tree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2017/1/3.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int h = getHeight(root);
        for (int i = 0; i < h; i++) result.add(new ArrayList<Integer>());
        search(root, result);
        return result;
    }

    int search(TreeNode node, List<List<Integer>> result) {
        if (node == null) return 0;
        int level = 1;
        level = Math.max(level, search(node.left, result) + 1);
        level = Math.max(level, search(node.right, result) + 1);
        result.get(level - 1).add(node.val);
        return level;
    }

    int getHeight(TreeNode root) {
        if (root == null) return 0;
        return Math.max(getHeight(root.left) + 1, getHeight(root.right) + 1);
    }
}
