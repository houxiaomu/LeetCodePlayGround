package houxiaomu.leetcodeplayground;

/**
 * Created by Simon on 2016/6/13.
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    @Override
    public String toString() {
        return "(" + val + ")->(" + (next == null ? "null" : next.val) + ")";
    }
}
