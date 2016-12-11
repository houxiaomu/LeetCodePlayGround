package houxiaomu.leetcodeplayground.happy_number;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Simon on 2016/12/9.
 */
public class Solution extends BaseSolution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        set.add(n);
        while (n != 1) {
            int sum = 0;
            int radix = 1;
            while (n != 0) {
                int digit = (n % 10) * radix;
                sum += digit * digit;
                n /= 10;
            }
            if (set.contains(sum))
                return false;
            n = sum;
            set.add(n);
        }
        return true;
    }
}
