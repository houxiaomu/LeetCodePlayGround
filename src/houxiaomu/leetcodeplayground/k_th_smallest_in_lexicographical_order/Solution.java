package houxiaomu.leetcodeplayground.k_th_smallest_in_lexicographical_order;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Simon on 2016/12/25.
 */
public class Solution extends BaseSolution {
    public int findKthNumber(int n, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(20, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                String s1 = String.valueOf(i1);
                String s2 = String.valueOf(i2);
                int index = 0;
                while (index < s1.length() && index < s2.length()) {
                    int diff = s2.charAt(index) - s1.charAt(index);
                    if (diff != 0) return diff;
                    index++;
                }
                return index >= s1.length() ? 1 : -1;
            }
        });

        for (int i = 1; i <= n; i++) {
            pq.offer(i);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }
}
