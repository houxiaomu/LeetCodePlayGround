package houxiaomu.leetcodeplayground.reverse_linked_list_ii;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by Simon on 2016/6/18.
 */
public class Solution extends BaseSolution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode result = head;
        if (m == n) return result;

        int pos = 1;
        ListNode node = head;
        ListNode prev = null;
        ListNode before = null;
        ListNode first = null;
        ListNode tmp;

        while (node != null) {
            if (pos == m) {
                before = prev;
                first = node;
            }

            if (pos > m && pos < n) {
                tmp = node.next;
                node.next = prev;
                prev = node;
                node = tmp;
                pos++;
            } else if (pos == n) {
                first.next = node.next;
                if (before != null) {
                    before.next = node;
                }
                if (m == 1) {
                    result = node;
                }
                tmp = node.next;
                node.next = prev;
                prev = node;
                node = tmp;
                pos++;
            } else {
                prev = node;
                node = node.next;
                pos++;
            }
        }
        return result;
    }
}
