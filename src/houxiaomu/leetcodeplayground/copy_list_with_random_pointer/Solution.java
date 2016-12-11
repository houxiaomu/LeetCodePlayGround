package houxiaomu.leetcodeplayground.copy_list_with_random_pointer;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.zigzag_conversion.RandomListNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return null;
        RandomListNode newHead = null;
        RandomListNode p = head;
        RandomListNode pCurrent, pPrevious = null;
        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        while (p != null) {
            pCurrent = new RandomListNode(head.label);
            if (newHead == null) {
                newHead = pCurrent;
            }
            if (pPrevious != null) {
                pPrevious.next = pCurrent;
            }
            map.put(p, pCurrent);
            pPrevious = pCurrent;
            p = p.next;
        }

        p = head;
        while (p != null) {
            RandomListNode node = map.get(p);
            node.random = map.get(p.random);
            p = p.next;
        }
        return newHead;
    }
}
