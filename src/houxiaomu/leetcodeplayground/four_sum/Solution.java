package houxiaomu.leetcodeplayground.four_sum;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by houxiaomu on 16-7-18.
 */
public class Solution extends BaseSolution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 3) {
            return result;
        }

        Arrays.sort(nums);
        HashSet<Triplet> resultMap = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                final int val = nums[i] + nums[j] + nums[k];
                if (val == 0) {
                    Triplet triplet = new Triplet(nums[i], nums[j], nums[k]);
                    if (!resultMap.contains(triplet)) {
                        resultMap.add(triplet);
                    }
                    k--;
                    j++;
                    continue;
                } else if (val > 0) {
                    k--;
                } else {
                    j++;
                }
            }
        }

        Iterator<Triplet> iterator = resultMap.iterator();
        while (iterator.hasNext()) {
            Triplet next = iterator.next();
            List<Integer> list = new ArrayList<>();
            list.add(next.a);
            list.add(next.b);
            list.add(next.c);
            result.add(list);
        }

        return result;
    }

    class Triplet {
        final int a;
        final int b;
        final int c;

        Triplet(int n1, int n2, int n3) {
            a = n1;
            b = n2;
            c = n3;
        }

        @Override
        public int hashCode() {
            return a + b * 7 + c * 49;
        }

        @Override
        public boolean equals(Object obj) {
            Triplet that = (Triplet) obj;
            if ((a == that.a && b == that.b && c == that.c) || (a == that.b && b == that.a && c == that.c)
                    || (a == that.c && b == that.b && c == that.a) || (a == that.a && b == that.c && c == that.b)
                    || (a == that.b && b == that.c && c == that.a) || (a == that.c && b == that.c && c == that.b)) {
                return true;
            }
            return false;
        }
    }

}
