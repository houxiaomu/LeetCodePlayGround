package houxiaomu.leetcodeplayground.reorder_list;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

import java.util.Stack;

/**
 * Created by Simon on 2016/12/5.
 */
public class Solution extends BaseSolution {
    public void reorderList(ListNode head) {
        if (head == null) return;
        Stack<ListNode> stack = new Stack<>();
        ListNode p = head;
        while (p != null) {
            stack.push(p);
            p = p.next;
        }

        p = head;
        while (true) {
            ListNode tail = stack.pop();
            if (p == tail) {
                p.next = null;
                break;
            } else if (p.next == tail) {
                p.next = tail;
                tail.next = null;
                break;
            }
            ListNode next = p.next;
            p.next = tail;
            tail.next = next;
            p = next;
        }
    }

    @Override
    protected void printResult(Object[] params, Object result) {
        printResult(params[0]);
    }
}
