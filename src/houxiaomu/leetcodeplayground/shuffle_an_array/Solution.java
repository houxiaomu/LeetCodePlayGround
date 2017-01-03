package houxiaomu.leetcodeplayground.shuffle_an_array;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Simon on 2017/1/1.
 */
public class Solution extends BaseSolution {
    private int[] origin;
    private Random r;

    public Solution() {

    }

    public Solution(int[] nums) {
        origin = Arrays.copyOf(nums, nums.length);
        r = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return Arrays.copyOf(origin, origin.length);
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int[] array = Arrays.copyOf(origin, origin.length);
        for (int i = 0; i < array.length; i++) {
            int target = r.nextInt(array.length);
            int tmp = array[target];
            array[target] = array[i];
            array[i] = tmp;
        }
        return array;
    }

    @Override
    public boolean runCustomizedTestCases() {
        Solution s = new Solution(new int[]{1, 2, 3});
        s.shuffle();
        s.reset();
        s.shuffle();
        return true;
    }
}
