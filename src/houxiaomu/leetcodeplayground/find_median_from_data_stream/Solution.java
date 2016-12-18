package houxiaomu.leetcodeplayground.find_median_from_data_stream;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Simon on 2016/12/16.
 */
public class Solution extends BaseSolution {
    private PriorityQueue<Integer> bigger = new PriorityQueue<>();
    private PriorityQueue<Integer> smaller = new PriorityQueue<>(20, sComparator);

    private static Comparator<Integer> sComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };

    public void addNum(int num) {
        if (smaller.size() == 0 && bigger.size() == 0) {
            smaller.offer(num);
        } else if (bigger.size() == 0) {
            smaller.offer(num);
            bigger.offer(smaller.poll());
        } else {
            if (num > smaller.peek()) {
                bigger.offer(num);
                if (bigger.size() > smaller.size()) {
                    smaller.offer(bigger.poll());
                }
            } else {
                smaller.offer(num);
                if (smaller.size() > bigger.size() + 1) {
                    bigger.offer(smaller.poll());
                }
            }
        }
    }

    public double findMedian() {
        if (smaller.size() > bigger.size()) {
            return smaller.peek();
        } else {
            return ((double) smaller.peek() + bigger.peek()) / 2;
        }
    }

    @Override
    public boolean runCustomizedTestCases() {
//        addNum(1);
//        System.out.println("findMedian=" + findMedian());
//        addNum(3);
//        System.out.println("findMedian=" + findMedian());
//        addNum(2);
//        System.out.println("findMedian=" + findMedian());
//        addNum(4);
//        System.out.println("findMedian=" + findMedian());

        addNum(6);
        System.out.println("findMedian=" + findMedian());
        addNum(10);
        System.out.println("findMedian=" + findMedian());
        addNum(2);
        System.out.println("findMedian=" + findMedian());
        addNum(6);
        System.out.println("findMedian=" + findMedian());
        addNum(5);
        System.out.println("findMedian=" + findMedian());
        addNum(0);
        System.out.println("findMedian=" + findMedian());
        addNum(6);
        System.out.println("findMedian=" + findMedian());
        addNum(3);
        System.out.println("findMedian=" + findMedian());
        addNum(1);
        System.out.println("findMedian=" + findMedian());
        addNum(0);
        System.out.println("findMedian=" + findMedian());
        addNum(0);
        System.out.println("findMedian=" + findMedian());
        return true;
    }
}
