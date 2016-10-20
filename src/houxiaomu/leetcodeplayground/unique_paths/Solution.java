package houxiaomu.leetcodeplayground.unique_paths;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Simon on 2016/10/20.
 */
public class Solution extends BaseSolution {
    public int uniquePaths(int m, int n) {
        return doRecursive(m, n, new HashMap<String, Integer>());
    }

    private int doRecursive(int m, int n, Map<String, Integer> cache) {
        if (m == 1 || n == 1) return 1;
        String key1 = m + "_" + n;
        String key2 = n + "_" + m;
        if (cache.containsKey(key1)) return cache.get(key1);
        if (cache.containsKey(key2)) return cache.get(key2);
        int value = doRecursive(m - 1, n, cache) + doRecursive(m, n - 1, cache);
        cache.put(key1, value);
        return value;
    }
}
