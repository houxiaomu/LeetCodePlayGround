package houxiaomu.leetcodeplayground.find_k_pairs_with_smallest_sums;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Created by Simon on 2017/1/2.
 */
public class Solution extends BaseSolution {
    class Pair {
        int[] ints;
        int sum;

        Pair(int a, int b) {
            ints = new int[]{a, b};
            sum = a + b;
        }
    }

    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> result = new ArrayList<>();
        PriorityQueue<Pair> pq = new PriorityQueue<>(10, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.sum - o1.sum;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.offer(new Pair(nums1[i], nums2[j]));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        for (Pair p : pq) {
            result.add(p.ints);
        }
        return result;
    }
}
