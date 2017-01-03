package houxiaomu.leetcodeplayground.evaluate_division;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Simon on 2016/12/29.
 */
public class Solution extends BaseSolution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Set<String>> equationMap = new HashMap<>();
        Map<String, Double> valueMap = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            Set<String> set = equationMap.get(equations[i][0]);
            if (set == null) {
                set = new HashSet<>();
                equationMap.put(equations[i][0], set);
            }
            set.add(equations[i][1]);
            valueMap.put(key(equations[i][0], equations[i][1]), values[i]);

            set = equationMap.get(equations[i][1]);
            if (set == null) {
                set = new HashSet<>();
                equationMap.put(equations[i][1], set);
            }
            set.add(equations[i][0]);
            valueMap.put(key(equations[i][1], equations[i][0]), 1 / values[i]);
        }

        double[] result = new double[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = search(equationMap, valueMap, queries[i], new HashSet<String>());
        }
        return result;
    }

    double search(Map<String, Set<String>> equationMap, Map<String, Double> valueMap, String[] query, Set<String> path) {
        if (valueMap.containsKey(key(query[0], query[1]))) {
            return valueMap.get(key(query[0], query[1]));
        }

        if (!equationMap.containsKey(query[0]) || !equationMap.containsKey(query[1]))
            return -1.0;

        Set<String> set = equationMap.get(query[0]);
        if (set != null) {
            for (String neighbor : set) {
                if (path.contains(neighbor)) continue;
                path.add(neighbor);
                double val = search(equationMap, valueMap, new String[]{neighbor, query[1]}, path);
                if (val != -1.0d) {
                    val *= valueMap.get(key(query[0], neighbor));
                    valueMap.put(key(query[0], query[1]), val);
                    set.add(query[1]);
                    return val;
                }
                path.remove(neighbor);
            }
        }
        return -1.0;
    }

    String key(String k1, String k2) {
        return k1 + "SS^^" + k2;
    }
}
