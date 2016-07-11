package houxiaomu.leetcodeplayground.roman_to_integer;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by houxiaomu on 16-7-11.
 */
public class Solution extends BaseSolution {
    static Map<String, Integer> sMap1 = new HashMap<>();
    static Map<String, Integer> sMap2 = new HashMap<>();

    static {
        sMap1.put("I", 1);
        sMap1.put("V", 5);
        sMap1.put("X", 10);
        sMap1.put("L", 50);
        sMap1.put("C", 100);
        sMap1.put("D", 500);
        sMap1.put("M", 1000);

        sMap2.put("IV", 4);
        sMap2.put("IX", 9);
        sMap2.put("XL", 40);
        sMap2.put("XC", 90);
        sMap2.put("CD", 400);
        sMap2.put("CM", 900);
    }

    public int romanToInt(String s) {
        int result = 0;
        final int len = s.length();
        int pos = 0;
        while (pos < len) {
            if (len - pos >= 2) {
                String str = s.substring(pos, pos + 2);
                if (sMap2.containsKey(str)) {
                    result += sMap2.get(str);
                    pos += 2;
                    continue;
                }
            }
            result += sMap1.get(s.substring(pos, pos + 1));
            pos++;
        }
        return result;
    }
}
