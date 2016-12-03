package houxiaomu.leetcodeplayground.construct_binary_tree_from_preorder_and_inorder_traversal;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.TreeNode;

/**
 * Created by Simon on 2016/12/3.
 */
public class Solution extends BaseSolution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    TreeNode build(int[] preorder, int preLeft, int preRight, int[] inorder, int inLeft, int inRight) {
        if (preLeft > preRight || preLeft > preorder.length - 1) {
            return null;
        }

        int val = preorder[preLeft];
        TreeNode node = new TreeNode(val);
        int inOrderIndex = 0;
        for (int i = inLeft; i <= inRight; i++) {
            if (inorder[i] == val) {
                inOrderIndex = i;
                break;
            }
        }

        node.left = build(preorder, preLeft + 1, preLeft + (inOrderIndex - inLeft), inorder, inLeft, inOrderIndex - 1);
        node.right = build(preorder, preLeft + (inOrderIndex - inLeft) + 1, preRight, inorder, inOrderIndex + 1, inRight);
        return node;
    }
}
