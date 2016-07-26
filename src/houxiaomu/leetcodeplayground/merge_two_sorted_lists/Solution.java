package houxiaomu.leetcodeplayground.merge_two_sorted_lists;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by houxiaomu on 16-7-26.
 */
public class Solution extends BaseSolution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cur = null;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                if (cur != null) {
                    cur.next = l1;
                } else {
                    head = l1;
                }
                cur = l1;
                l1 = l1.next;
            } else {
                if (cur != null) {
                    cur.next = l2;
                } else {
                    head = l2;
                }
                cur = l2;
                l2 = l2.next;
            }
        }

        if (l1 != null) {
            if (cur != null) {
                cur.next = l1;
            } else {
                head = l1;
            }
        } else if (l2 != null) {
            if (cur != null) {
                cur.next = l2;
            } else {
                head = l2;
            }
        }

        return head;
    }
}
