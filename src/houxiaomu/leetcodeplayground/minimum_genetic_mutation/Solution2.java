package houxiaomu.leetcodeplayground.minimum_genetic_mutation;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution2 extends BaseSolution {
    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0)
            return -1;
        if (bank.length == 1 && !bank[0].equals(end))
            return -1;
        if (caculateLength(end, start) == 1) return 1;
        Map<String, Set<String>> map = new HashMap<>();
        for (int i = 0; i < bank.length; i++) {
            for (int j = i + 1; j < bank.length; j++) {
                if (caculateLength(bank[i], bank[j]) == 1) addData(map, bank[i], bank[j]);
            }
        }

        int min = Integer.MAX_VALUE;
        for (String s : bank) {
            if (caculateLength(s, start) == 1) {
                min = Math.min(min, search(s, end, map, new HashSet<String>()));
            }
        }

        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    int search(String start, String end, Map<String, Set<String>> map, Set<String> path) {
        if (end.equals(start)) {
            return path.size() + 1;
        }
        int min = Integer.MAX_VALUE;
        Set<String> neighbors = map.get(start);
        if (neighbors != null) {
            path.add(start);
            for (String neighbor : neighbors) {
                if (path.contains(neighbor)) continue;
                min = Math.min(min, search(neighbor, end, map, path));
            }
            path.remove(start);
        }
        return min;
    }

    void addData(Map<String, Set<String>> map, String s1, String s2) {
        Set<String> set = map.get(s1);
        if (set == null) {
            set = new HashSet<>();
            map.put(s1, set);
        }
        set.add(s2);

        set = map.get(s2);
        if (set == null) {
            set = new HashSet<>();
            map.put(s2, set);
        }
        set.add(s1);
    }

    int caculateLength(String s1, String s2) {
        if (s1.length() != s2.length()) return -1;
        int len = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) len++;
        }
        return len;
    }
}
