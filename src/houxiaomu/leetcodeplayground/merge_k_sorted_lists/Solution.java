package houxiaomu.leetcodeplayground.merge_k_sorted_lists;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

import java.util.*;

/**
 * Created by houxiaomu on 16-7-27.
 */
public class Solution extends BaseSolution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        if (lists.length == 1) return lists[0];

        LinkedList<ListNode> queue = new LinkedList<>();
        for (int i = 0; i < lists.length; i++) {
            queue.add(lists[i]);
        }

        while (queue.size() > 1) {
            queue.add(mergeTwoLists(queue.poll(), queue.poll()));
        }

        return queue.get(0);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
