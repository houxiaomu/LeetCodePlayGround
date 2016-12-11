package houxiaomu.leetcodeplayground.course_schedule_ii;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/10.
 */
public class Solution extends BaseSolution {
    int count;

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        count = 0;
        List<Integer>[] map = new List[numCourses];
        for (int[] prerequisite : prerequisites) {
            List<Integer> dep = map[prerequisite[0]];
            if (dep == null) {
                dep = new ArrayList<>();
                map[prerequisite[0]] = dep;
            }
            dep.add(prerequisite[1]);
        }

        boolean[] processed = new boolean[numCourses];
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i, result, map, new LinkedList<Integer>(), processed)) {
                return new int[0];
            }
        }

        return result;
    }

    boolean dfs(int i, int[] result, List<Integer>[] map, LinkedList<Integer> path, boolean[] processed) {
        if (path.contains(i)) return false;
        if (processed[i]) return true;

        List<Integer> dep = map[i];
        if (dep != null) {
            path.addLast(i);
            for (int d : dep) {
                if (!dfs(d, result, map, path, processed)) return false;
            }
            path.removeLast();
            map[i] = null;
        }
        processed[i] = true;
        result[count++] = i;
        return true;
    }
}
