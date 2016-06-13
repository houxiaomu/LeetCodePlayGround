package houxiaomu.leetcodeplayground.addtwonumbers;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.ListNode;

/**
 * Created by Simon on 2016/6/13.
 */
public class Solution extends BaseSolution {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = l1;
        ListNode n2 = l2;

        ListNode ret = new ListNode(0);
        ListNode n = ret;
        int add = 0;
        while (true) {
            n.val = ((n1 != null) ? n1.val : 0) + ((n2 != null) ? n2.val : 0) + add;
            add = 0;
            if (n.val >= 10) {
                n.val -= 10;
                add = 1;
            }
            if (n1 != null) n1 = n1.next;
            if (n2 != null) n2 = n2.next;

            if (n1 == null && n2 == null && add == 0) {
                break;
            }

            n.next = new ListNode(0);
            n = n.next;
        }
        return ret;
    }

}
