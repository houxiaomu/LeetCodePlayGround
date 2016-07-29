package houxiaomu.leetcodeplayground.reverse_nodes_in_k_group;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by houxiaomu on 16-7-29.
 */
public class Solution extends BaseSolution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode newHead = null;
        ListNode p = head;
        ListNode pre, start, end, q, next;
        ListNode lastSegEnd = null;
        while (p != null) {
            int i = 0;
            start = p;
            pre = p;
            while (p != null && i < k) {
                i++;
                pre = p;
                p = p.next;
            }
            if (i < k) {
                if (lastSegEnd != null) lastSegEnd.next = start;
                break;
            }

            end = pre;
            q = start;
            pre = null;
            while (q != null) {
                next = q.next;
                if (q == end) {
                    if (newHead == null) newHead = q;
                    if (lastSegEnd != null) lastSegEnd.next = q;
                    q.next = pre;
                    lastSegEnd = start;
                    break;
                }
                q.next = pre;
                pre = q;
                q = next;
            }
        }
        if (newHead == null) newHead = head;
        return newHead;
    }
}
