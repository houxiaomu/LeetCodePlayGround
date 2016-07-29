package houxiaomu.leetcodeplayground.swap_nodes_in_pairs;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by houxiaomu on 16-7-29.
 */
public class Solution extends BaseSolution {
    public ListNode swapPairs(ListNode head) {
        if (head == null) return null;

        ListNode newHead = head;
        ListNode p = head;
        ListNode pre = null;
        ListNode tmp;
        while (p != null && p.next != null) {
            tmp = p.next;
            p.next = p.next.next;
            tmp.next = p;
            if (pre == null) {
                newHead = tmp;
            } else {
                pre.next = tmp;
            }
            pre = p;
            p = tmp.next.next;
        }

        return newHead;
    }
}
