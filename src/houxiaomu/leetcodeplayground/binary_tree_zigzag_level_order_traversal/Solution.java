package houxiaomu.leetcodeplayground.binary_tree_zigzag_level_order_traversal;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.twosum.TreeNode;

import java.util.*;

/**
 * Created by Simon on 2016/6/14.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        if (root != null) queue.add(root);
        boolean dirRight = true;
        while (!queue.isEmpty()) {
            LinkedList<Integer> valByDepth = new LinkedList<>();
            result.add(valByDepth);
            Queue<TreeNode> nextLevelQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (dirRight) {
                    valByDepth.add(node.val);
                } else {
                    valByDepth.addFirst(node.val);
                }
                if (node.left != null) nextLevelQueue.add(node.left);
                if (node.right != null) nextLevelQueue.add(node.right);
            }
            queue = nextLevelQueue;
            dirRight = !dirRight;
        }
        return result;
    }

}
