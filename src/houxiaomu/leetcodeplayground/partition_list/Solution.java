package houxiaomu.leetcodeplayground.partition_list;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by houxiaomu on 16-6-20.
 */
public class Solution extends BaseSolution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) return head;

        ListNode node = head;
        ListNode left = null;
        ListNode firstLeft = null;
        ListNode right = null;
        ListNode firstRight = null;

        while (node != null) {
            if (node.val >= x) {
                if (right == null) {
                    right = node;
                    firstRight = right;
                } else {
                    right.next = node;
                    right = node;
                }
            } else {
                if (left == null) {
                    left = node;
                    firstLeft = node;
                } else {
                    left.next = node;
                    left = node;
                }
            }
            node = node.next;
        }

        if (firstLeft == null) {
            firstLeft = firstRight;
        } else {
            left.next = firstRight;
        }

        if (firstRight == null) {
            left.next = null;
        } else {
            right.next = null;
        }

        return firstLeft;
    }
}
