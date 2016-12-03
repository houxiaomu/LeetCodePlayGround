package houxiaomu.leetcodeplayground.path_sum_ii;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/3.
 */
public class Solution extends BaseSolution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        search(root, sum, result, new ArrayList<Integer>());
        return result;
    }

    private void search(TreeNode node, int sum, List<List<Integer>> result, List<Integer> current) {
        if (node == null) return;
        current.add(node.val);
        if (node.left == null && node.right == null && node.val == sum) {
            result.add(new ArrayList<Integer>(current));
        }
        if (node.left != null) {
            search(node.left, sum - node.val, result, current);
        }
        if (node.right != null) {
            search(node.right, sum - node.val, result, current);
        }
        current.remove(current.size() - 1);
    }
}
