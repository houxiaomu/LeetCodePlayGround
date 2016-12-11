package houxiaomu.leetcodeplayground.linked_list_cycle_ii;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by Simon on 2016/12/5.
 */
public class Solution extends BaseSolution {
    public ListNode detectCycle(ListNode head) {
        if (head == null) return null;
        if (head.next == head) return head;

        ListNode fast = head, slow = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) return null;
            fast = fast.next;
        } while (fast != slow && fast != null);


        if (fast == slow) {
            return slow;
        }

        return null;
    }
}
