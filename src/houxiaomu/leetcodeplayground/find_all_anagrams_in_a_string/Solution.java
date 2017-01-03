package houxiaomu.leetcodeplayground.find_all_anagrams_in_a_string;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/25.
 */
public class Solution extends BaseSolution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] array = new int[26];
        for (char c : p.toCharArray()) {
            array[c - 'a']++;
        }

        int left = 0, right = 0, count = p.length();
        while (left < s.length() && right < s.length()) {
            array[s.charAt(right) - 'a']--;
            if (array[s.charAt(right) - 'a'] >= 0)
                count--;
            right++;
            if (count == 0)
                result.add(left);

            if (right - left == p.length()) {
                array[s.charAt(left) - 'a']++;
                if (array[s.charAt(left) - 'a'] > 0)
                    count++;
                left++;
            }
        }
        return result;
    }
}
