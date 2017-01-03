package houxiaomu.leetcodeplayground.find_right_interval;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.Interval;

import java.util.*;

/**
 * Created by Simon on 2016/12/25.
 */
public class Solution extends BaseSolution {
    class Data {
        Interval interval;
        int index;

        public Data(Interval in, int i) {
            interval = in;
            index = i;
        }
    }

    public int[] findRightInterval(Interval[] intervals) {
        List<Data> list = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            list.add(new Data(intervals[i], i));
        }
        Collections.sort(list, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.interval.start - o2.interval.start;
            }
        });

        int[] result = new int[intervals.length];
        Arrays.fill(result, -1);
        for (int i = 0; i < list.size(); i++) {
            Data d = list.get(i);
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(j).interval.start >= d.interval.end) {
                    result[d.index] = list.get(j).index;
                    break;
                }
            }
        }
        return result;
    }
}
