package houxiaomu.leetcodeplayground.populating_next_right_pointers_in_each_node;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeLinkNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    public void connect(TreeLinkNode root) {
        if (root == null) return;
        Queue<TreeLinkNode> queue = new LinkedList<>();
        Queue<TreeLinkNode> nextQueue = new LinkedList<>();
        queue.offer(root);

        TreeLinkNode linkNode = null;
        while (!queue.isEmpty()) {
            TreeLinkNode node = queue.poll();
            if (node.left != null) nextQueue.offer(node.left);
            if (node.right != null) nextQueue.offer(node.right);

            if (linkNode != null) {
                linkNode.next = node;
            }
            linkNode = node;
            linkNode.next = null;

            if (queue.isEmpty()) {
                queue = nextQueue;
                linkNode = null;
            }
        }
    }

    @Override
    public boolean runCustomizedTestCases() {
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        connect(root);
        return true;
    }
}
