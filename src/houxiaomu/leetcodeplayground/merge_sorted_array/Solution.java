package houxiaomu.leetcodeplayground.merge_sorted_array;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.ListIterator;

/**
 * Created by houxiaomu on 16-6-20.
 */
public class Solution extends BaseSolution {
//    protected void invokeRunMethod(Method method, Object[] params) {
//        int[] nums1 = (int[]) params[0];
//        int m = (int) params[1];
//        int[] nums2 = (int[]) params[2];
//        int n = (int) params[3];
//        int[] newNums1 = new int[m + n];
//        System.arraycopy(nums1, 0, newNums1, 0, m);
//        merge(newNums1, m, nums2, n);
//        printResult(newNums1);
//    }


    @Override
    protected void invokeRunMethod(Method method, Object[] params) {
        super.invokeRunMethod(method, params);
        printResult(params[0]);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        LinkedList<Integer> list = new LinkedList<>();
        int pos1 = 0, pos2 = 0;
        while (pos1 < m || pos2 < n) {
            if (pos1 >= m) {
                list.add(nums2[pos2]);
                pos2++;
            } else if (pos2 >= n) {
                list.add(nums1[pos1]);
                pos1++;
            } else if (nums1[pos1] > nums2[pos2]) {
                list.add(nums2[pos2]);
                pos2++;
            } else {
                list.add(nums1[pos1]);
                pos1++;
            }
        }
        ListIterator<Integer> it = list.listIterator();
        while (it.hasNext()) {
            nums1[it.nextIndex()] = it.next();
        }
    }
}
