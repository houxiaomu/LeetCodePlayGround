package houxiaomu.leetcodeplayground.anagrams;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by houxiaomu on 16-8-29.
 */
public class Solution extends BaseSolution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            if (map.containsKey(key)) {
                List<String> group = map.get(key);
                group.add(s);
            } else {
                ArrayList<String> group = new ArrayList<>();
                group.add(s);
                result.add(group);
                map.put(key, group);
            }
        }
        return result;
    }
}
