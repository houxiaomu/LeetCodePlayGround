package houxiaomu.leetcodeplayground.sametree;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.twosum.TreeNode;

/**
 * Created by Simon on 2016/6/14.
 */
public class Solution extends BaseSolution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p != null && q != null) {
            if (p.val != q.val) {
                return false;
            }
            if (p.left == q.left && p.right == q.right) {
                return true;
            }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);

        } else if (p == null && q == null) {
            return true;
        }
        return false;
    }
}
