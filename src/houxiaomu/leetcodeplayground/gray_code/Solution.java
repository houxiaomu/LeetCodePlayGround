package houxiaomu.leetcodeplayground.gray_code;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Created by Simon on 2016/6/19.
 */
public class Solution extends BaseSolution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
            result.add(0);
        } else {
            int len = (int) Math.pow(2, n);
            int[] bits = new int[n];
            HashSet<Integer> map = new LinkedHashSet<>();
            while (map.size() != len) {
                int number = getNumber(bits);
                map.add(number);
                for (int i = 0; i < bits.length; i++) {
                    bits[i] = bits[i] == 0 ? 1 : 0; //reverse bit
                    number = getNumber(bits);
                    if (!map.contains(number)) {
                        break;
                    } else {
                        bits[i] = bits[i] == 0 ? 1 : 0; //reverse back
                    }
                }
            }
            for (Integer i : map) {
                result.add(i);
            }
        }
        return result;
    }

    private int getNumber(int[] bits) {
        int n = 0;
        for (int i = 0; i < bits.length; i++) {
            if (bits[i] != 0) {
                n += Math.pow(2, i);
            }
        }
        return n;
    }
}
