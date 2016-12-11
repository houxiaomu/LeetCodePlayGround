package houxiaomu.leetcodeplayground.course_schedule;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/9.
 */
public class Solution extends BaseSolution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null) return true;
        Map<Integer, List<Integer>> map = new HashMap<>();
        Set<Integer> remain = new HashSet<>();
        for (int[] list : prerequisites) {
            List<Integer> dep = map.get(list[0]);
            if (dep == null) {
                dep = new ArrayList<>();
                remain.add(list[0]);
                map.put(list[0], dep);
            }
            dep.add(list[1]);
        }

        while (!remain.isEmpty()) {
            int i = remain.iterator().next();
            if (hasSelfDep(i, map, remain, new HashSet<Integer>())) return false;
        }
        return true;
    }

    boolean hasSelfDep(int i, Map<Integer, List<Integer>> map, Set<Integer> remain, Set<Integer> path) {
        if (path.contains(i)) return true;
        remain.remove(i);
        path.add(i);
        List<Integer> dep = map.get(i);
        if (dep != null) {
            for (int d : dep) {
                if (hasSelfDep(d, map, remain, path)) return true;
            }
        }
        path.remove(i);
        return false;
    }

}
