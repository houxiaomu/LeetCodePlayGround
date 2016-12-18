package houxiaomu.leetcodeplayground.first_bad_version;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/14.
 */
public class Solution extends BaseSolution {
    public int firstBadVersion(int n) {
        int low = 1, high = n;
        while (low < high) {
            int mid = (int) (((long)high + (long)low) / 2);
            if (isBadVersion(mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return isBadVersion(low) ? low : low + 1;
    }

    boolean isBadVersion(int n) {
        return n >= 1702766719;
    }

    @Override
    public boolean runCustomizedTestCases() {
        System.out.println("2126753390-1702766719 -> " + firstBadVersion(2126753390));
        return true;
    }
}
