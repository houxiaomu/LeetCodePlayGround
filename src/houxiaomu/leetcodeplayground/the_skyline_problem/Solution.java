package houxiaomu.leetcodeplayground.the_skyline_problem;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/11.
 */
public class Solution extends BaseSolution {
    class Edge implements Comparable<Edge> {
        int pos;
        int height;

        Edge(int pos, int height) {
            this.pos = pos;
            this.height = height;
        }

        @Override
        public int compareTo(Edge o) {
            return this.pos - o.pos;
        }
    }

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>();
        List<Edge> edges = new ArrayList<>();
        for (int[] building : buildings) {
            edges.add(new Edge(building[0], building[2]));
            edges.add(new Edge(building[1], -building[2]));
        }
        Collections.sort(edges);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(11, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        pq.add(0);
        int current = 0;
        for (Edge edge : edges) {
            if (edge.height > 0) {
                pq.add(edge.height);
            } else {
                pq.remove(-edge.height);
            }
            int highest = pq.peek();
            if (highest != current) {
                if (result.size() >= 2 && result.get(result.size() - 1)[0] == edge.pos
                        && result.get(result.size() - 2)[1] == highest) {
                    result.remove(result.size() - 1);
                    current = highest;
                    continue;
                } else if (result.size() > 0 && result.get(result.size() - 1)[0] == edge.pos) {
                    int lastValue = result.get(result.size() - 1)[1];
                    if (highest <= lastValue) {
                        continue;
                    }
                    result.remove(result.size() - 1);
                }
                int[] pos = new int[2];
                pos[0] = edge.pos;
                pos[1] = highest;
                result.add(pos);
                current = highest;
            }
        }

        return result;
    }

    @Override
    protected void printResult(Object result) {
        List<int[]> points = (List<int[]>) result;
        for (int[] point : points) {
            System.out.print(Arrays.toString(point) + " ");
        }
        System.out.println();
    }
}
