package houxiaomu.leetcodeplayground.add_two_numbers_ii;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);
        ListNode n1 = l1, n2 = l2;
        int carry = 0;
        ListNode result = null, current = null;
        while (n1 != null || n2 != null || carry > 0) {
            int val = (n1 == null ? 0 : n1.val) + (n2 == null ? 0 : n2.val) + carry;
            carry = 0;
            if (val >= 10) {
                val -= 10;
                carry = 1;
            }
            if (result == null) {
                result = new ListNode(val);
                current = result;
            } else {
                current.next = new ListNode(val);
                current = current.next;
            }
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;
        }
        return reverse(result);
    }

    ListNode reverse(ListNode head) {
        if (head == null) return null;
        ListNode prev = null;
        ListNode node = head;
        while (node != null) {
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            node = next;
        }
        return prev;
    }
}
