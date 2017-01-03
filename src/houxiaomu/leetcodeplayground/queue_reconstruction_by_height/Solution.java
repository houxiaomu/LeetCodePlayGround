package houxiaomu.leetcodeplayground.queue_reconstruction_by_height;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/28.
 */
public class Solution extends BaseSolution {
    public int[][] reconstructQueue(int[][] people) {
        List<int[]> list = Arrays.asList(people);
        Collections.sort(list, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] == o2[1] ? o1[0] - o2[0] : o1[1] - o2[1];
            }
        });
        List<int[]> newList = new ArrayList<>();
        for (int[] pair : list) {
            int i = 0, count = 0;
            while (count != pair[1] && i < newList.size()) {
                if (newList.get(i)[0] >= pair[0]) count++;
                i++;
            }
            while (i < newList.size() && pair[1] == newList.get(i)[1]) {
                i++;
            }
            newList.add(i, pair);
        }

        int[][] result = new int[newList.size()][];
        int i = 0;
        for (int[] pair : newList) {
            result[i++] = pair;
        }
        return result;
    }
}
