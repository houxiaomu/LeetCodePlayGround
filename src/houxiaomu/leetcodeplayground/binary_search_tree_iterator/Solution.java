package houxiaomu.leetcodeplayground.binary_search_tree_iterator;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.Stack;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    @Override
    public boolean runCustomizedTestCases() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + ",");
        }
        System.out.println();

        root = new TreeNode(1);
        root.right = new TreeNode(3);
        it = new BSTIterator(root);
        while (it.hasNext()) {
            System.out.print(it.next() + ",");
        }
        System.out.println();
        return true;
    }

    public class BSTIterator {

        private Stack<TreeNode> stack;

        public BSTIterator(TreeNode root) {
            stack = new Stack<>();
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
        }

        /**
         * @return whether we have a next smallest number
         */
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        /**
         * @return the next smallest number
         */
        public int next() {
            TreeNode node = stack.pop();
            int val = node.val;
            node = node.right;
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            return val;
        }
    }
}
