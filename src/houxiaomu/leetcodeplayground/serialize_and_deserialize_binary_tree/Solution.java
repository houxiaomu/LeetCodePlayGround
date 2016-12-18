package houxiaomu.leetcodeplayground.serialize_and_deserialize_binary_tree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Simon on 2016/12/16.
 */
public class Solution extends BaseSolution {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        int level = getTreeLevel(root);
        //int total = getTotalCount(root);
        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.offer(root);
        int leafCount = (int) Math.pow(2, level - 1);
        sb.append('[');
        int pos = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            pos++;
            if (node != null) {
                if (sb.length() != 1) sb.append(',');
                sb.append(node.val);
                if (pos < leafCount) {
                    queue.offer(node.left);
                    queue.offer(node.right);
                }
            } else {
                if (sb.length() != 1) sb.append(',');
                sb.append("null");
                if (pos < leafCount) {
                    queue.offer(null);
                    queue.offer(null);
                }
            }
        }
        sb.append(']');
        return sb.toString();
    }

    int getTreeLevel(TreeNode node) {
        if (node == null) return 0;
        return Math.max(getTreeLevel(node.left), getTreeLevel(node.right)) + 1;
    }

    int getTotalCount(TreeNode node) {
        if (node == null) return 0;
        return getTotalCount(node.left) + getTotalCount(node.right) + 1;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) return null;
        Queue<TreeNode> queue = new ArrayDeque<>();
        TreeNode root = null;
        data = data.substring(1, data.length() - 1);
        if (data == null || data.isEmpty()) return null;
        String[] array = data.split(",");
        int pos = 0;
        while (pos < array.length) {
            TreeNode node = queue.poll();
            if (node == null) {
                root = newNode(array[pos++]);
                queue.add(root);
            } else {
                node.left = newNode(array[pos++]);
                if (pos < array.length) {
                    node.right = newNode(array[pos++]);
                }
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }

    private TreeNode newNode(String val) {
        if (val.equals("null")) {
            return null;
        } else {
            return new TreeNode(Integer.valueOf(val));
        }
    }
}
