package houxiaomu.leetcodeplayground.binary_tree_level_order_traversal;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Simon on 2016/6/14.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> valByDepth = new ArrayList<>();
            result.add(valByDepth);
            Queue<TreeNode> nextLevelQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                valByDepth.add(node.val);
                if (node.left != null) nextLevelQueue.add(node.left);
                if (node.right != null) nextLevelQueue.add(node.right);
            }
            queue = nextLevelQueue;
        }
        return result;
    }

}
