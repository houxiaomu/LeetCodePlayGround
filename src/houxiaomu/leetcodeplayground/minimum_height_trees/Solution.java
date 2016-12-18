package houxiaomu.leetcodeplayground.minimum_height_trees;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/17.
 */
public class Solution extends BaseSolution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<>();
        List[] paths = new List[n];
        for (int[] edge : edges) {
            List<Integer> path = paths[edge[0]];
            if (path == null) {
                path = new ArrayList<>();
                paths[edge[0]] = path;
            }
            path.add(edge[1]);

            path = paths[edge[1]];
            if (path == null) {
                path = new ArrayList<>();
                paths[edge[1]] = path;
            }
            path.add(edge[0]);
        }

        int minHeight = Integer.MAX_VALUE;
        int heights[] = new int[n];
        for (int i = 0; i < n; i++) {
            heights[i] = getTreeHeight(i, null, paths, new int[n]);
            minHeight = Math.min(heights[i], minHeight);
        }
        for (int i = 0; i < n; i++) {
            if (heights[i] == minHeight) result.add(i);
        }

        return result;
    }

    int getTreeHeight(int root, Integer from, List[] paths, int cache[]) {
        //if (cache[root] != 0) return cache[root];
        int h = 1;
        List path = paths[root];
        if (path != null) {
            for (Object o : path) {
                Integer child = (int) o;
                if (!child.equals(from)) {
                    h = Math.max(getTreeHeight(child, root, paths, cache) + 1, h);
                }
            }
        }
        cache[root] = h;
        return h;
    }
}
