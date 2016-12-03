package houxiaomu.leetcodeplayground.count_bst_nodes_in_range;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/11/23.
 * <p>
 * http://www.practice.geeksforgeeks.org/problem-page.php?pid=700139
 */
public class Solution extends BaseSolution {

    public int count(TreeNode root, int min, int max) {
        int[] results = new int[1];
        count(root, min, max, results);
        return results[0];
    }

    private void count(TreeNode root, int min, int max, int[] results) {
        if (root == null) return;
        if (root.val >= min && root.val <= max) {
            results[0]++;
            count(root.left, min, max, results);
            count(root.right, min, max, results);
        } else if (root.val < min) {
            count(root.right, min, max, results);
        } else if (root.val > max) {
            count(root.left, min, max, results);
        }
    }
}
