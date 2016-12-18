package houxiaomu.leetcodeplayground.minimum_genetic_mutation;

import houxiaomu.leetcodeplayground.BaseSolution;

import java.util.*;

/**
 * Created by Simon on 2016/12/18.
 */
public class Solution extends BaseSolution {
    class Node {
        String val;
        Set<String> neighbors;
        int startDist;
        int endDist;

        Node(String v) {
            val = v;
            neighbors = new HashSet<>();
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }

    public int minMutation(String start, String end, String[] bank) {
        if (bank.length == 0)
            return -1;
        if (bank.length == 1 && !bank[0].equals(end))
            return -1;
        if (caculateLength(end, start) == 1) return 1;

        if (caculateLength(end, start) == 1) return 1;
        Map<String, Node> map = new HashMap<>();
        for (int i = 0; i < bank.length; i++) {
            for (int j = i + 1; j < bank.length; j++) {
                if (caculateLength(bank[i], bank[j]) == 1) {
                    addData(map, bank[i], bank[j]);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (String s : bank) {
            if (caculateLength(s, start) == 1) {
                min = Math.min(min, search(s, end, map));
            }
        }

        if (min == Integer.MAX_VALUE) return -1;
        return min;
    }

    private int search(String start, String end, Map<String, Node> map) {
        Queue<String> sq = new LinkedList<>();
        sq.add(start);
        Queue<String> eq = new LinkedList<>();
        eq.add(end);
        int dist = 1;
        int min = Integer.MAX_VALUE;
        Set<String> sqVisited = new HashSet<>();
        Set<String> eqVisited = new HashSet<>();
        while (!sq.isEmpty() && !eq.isEmpty()) {
            int remain = sq.size();
            for (int i = 0; i < remain; i++) {
                Node n = map.get(sq.poll());
                if (n == null) break;
                if (n.startDist != 0 && n.startDist < dist) continue;
                n.startDist = dist;
                sqVisited.add(n.val);
                for (String neighbor : n.neighbors) {
                    if(sqVisited.contains(neighbor)) continue;
                    sq.add(neighbor);
                }
            }

            remain = eq.size();
            for (int i = 0; i < remain; i++) {
                Node n = map.get(eq.poll());
                if (n == null) break;
                if (n.endDist != 0 && n.endDist < dist) continue;
                n.endDist = dist;
                eqVisited.add(n.val);
                if (n.startDist > 0 && n.endDist > 0) {
                    //meet here
                    int len = n.startDist + n.endDist - 1;
                    min = Math.min(min, len);
                } else {
                    for (String neighbor : n.neighbors) {
                        if(eqVisited.contains(neighbor)) continue;
                        eq.add(neighbor);
                    }
                }
            }
            dist++;

        }
        return min;
    }

    private void addData(Map<String, Node> map, String s1, String s2) {
        Node node = map.get(s1);
        if (node == null) {
            node = new Node(s1);
            map.put(s1, node);
        }
        node.neighbors.add(s2);

        node = map.get(s2);
        if (node == null) {
            node = new Node(s2);
            map.put(s2, node);
        }
        node.neighbors.add(s1);
    }

    int caculateLength(String s1, String s2) {
        int len = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) len++;
        }
        return len;
    }
}
