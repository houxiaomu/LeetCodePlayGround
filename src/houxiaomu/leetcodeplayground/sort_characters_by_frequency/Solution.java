package houxiaomu.leetcodeplayground.sort_characters_by_frequency;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    class Data {
        char c;
        int count;

        Data(char c) {
            this.c = c;
            count = 0;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Data> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            Data data = map.get(c);
            if (data == null) {
                data = new Data(c);
                map.put(c, data);
            }
            data.count++;
        }

        List<Data> list = new ArrayList<>();
        for (char c : map.keySet()) {
            list.add(map.get(c));
        }

        Collections.sort(list, new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o2.count - o1.count;
            }
        });

        StringBuilder sb = new StringBuilder();
        for (Data data : list) {
            for (int i = 0; i < data.count; i++) {
                sb.append(data.c);
            }
        }
        return sb.toString();
    }
}
