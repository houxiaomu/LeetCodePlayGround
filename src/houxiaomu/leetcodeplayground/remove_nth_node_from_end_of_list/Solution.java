package houxiaomu.leetcodeplayground.remove_nth_node_from_end_of_list;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by houxiaomu on 16-7-21.
 */
public class Solution extends BaseSolution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null) {
            return null;
        }
        if (n <= 0) {
            return head;
        }

        ListNode p = head;
        int len = 0;
        while (p != null) {
            p = p.next;
            len++;
        }

        len -= n;
        if (len < 0) {
            return head;
        }

        ListNode pre = null;
        p = head;
        while (len > 0) {
            pre = p;
            p = p.next;
            len--;
        }

        ListNode newList = head;
        if (pre != null) {
            pre.next = p.next;
        } else {
            newList = p.next;
        }

        return newList;
    }
}
