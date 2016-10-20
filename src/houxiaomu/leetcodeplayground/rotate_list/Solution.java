package houxiaomu.leetcodeplayground.rotate_list;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by Simon on 2016/10/19.
 */
public class Solution extends BaseSolution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int len = 0;
        ListNode p = head;
        while (p != null) {
            p = p.next;
            len++;
        }

        if (k > len) k = k % len;
        if (k == 0) return head;
        if (len == 1) return head;

        p = head;
        int i = 0;
        ListNode anchor = null;
        ListNode nodeBeforeAnchor = null;
        ListNode tail = null;
        while (p != null) {
            if (i == len - k - 1) {
                nodeBeforeAnchor = p;
            } else if (i == len - k) {
                anchor = p;
            }
            if (i == len - 1) {
                tail = p;
            }
            p = p.next;
            i++;
        }

        if (nodeBeforeAnchor != null) {
            nodeBeforeAnchor.next = null;
            tail.next = head;
        }
        return anchor;
    }
}
