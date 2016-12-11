package houxiaomu.leetcodeplayground.intersection_of_two_linked_lists;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by Simon on 2016/12/6.
 */
public class Solution extends BaseSolution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0;
        ListNode p = headA;
        ListNode lastA = null;
        while (p != null) {
            lastA = p;
            p = p.next;
            lenA++;
        }

        p = headB;
        ListNode lastB = null;
        int lenB = 0;
        while (p != null) {
            lastB = p;
            p = p.next;
            lenB++;
        }

        if (lastA != lastB) {
            return null;
        }

        p = (lenA > lenB) ? headA : headB;
        ListNode q = (lenA > lenB) ? headB : headA;
        for (int i = 0; i < Math.abs(lenA - lenB); i++) {
            p = p.next;
        }
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
