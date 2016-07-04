package houxiaomu.leetcodeplayground.palindrome_number;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by houxiaomu on 16-7-4.
 */
public class Solution extends BaseSolution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        if (x < 10) return true;

        int len = 0;
        int i = x;
        while (i != 0) {
            len++;
            i = i / 10;
        }

        for (i = 0; i < len / 2; i++) {
            final int right = (x / (int) Math.pow(10, i)) % 10;
            final int left = (x / (int) Math.pow(10, len - i - 1)) % 10;
            if (left != right) {
                return false;
            }
        }
        return true;
    }
}
