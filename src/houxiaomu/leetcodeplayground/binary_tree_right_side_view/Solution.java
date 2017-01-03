package houxiaomu.leetcodeplayground.binary_tree_right_side_view;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> next = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) next.offer(node.left);
            if (node.right != null) next.offer(node.right);
            if (queue.isEmpty()) {
                Queue<TreeNode> tmp = queue;
                queue = next;
                next = tmp;
                result.add(node.val);
            }
        }
        return result;
    }
}
