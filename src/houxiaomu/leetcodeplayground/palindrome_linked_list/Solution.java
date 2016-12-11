package houxiaomu.leetcodeplayground.palindrome_linked_list;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;
        if (head.next.next == null) return head.val == head.next.val;
        ListNode fast = head, slow = head, prev = null;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode right = slow.next;
        ListNode left = fast.next != null ? slow : prev;
        slow.next = prev;

        while (left != null && right != null) {
            if (left.val != right.val) return false;
            left = left.next;
            right = right.next;
        }
        return true;
    }
}
