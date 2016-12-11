package houxiaomu.leetcodeplayground.clone_graph;

import houxiaomu.leetcodeplayground.BaseSolution;
import houxiaomu.leetcodeplayground.UndirectedGraphNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        UndirectedGraphNode result = null;
        Set<UndirectedGraphNode> todo = new HashSet<>();
        Set<UndirectedGraphNode> done = new HashSet<>();
        Map<Integer, UndirectedGraphNode> newMap = new HashMap<>();
        if (node != null) {
            todo.add(node);
        }

        while (!todo.isEmpty()) {
            UndirectedGraphNode n = todo.iterator().next();
            todo.remove(n);
            done.add(n);

            UndirectedGraphNode newNode = newMap.get(n.label);
            if (newNode == null) {
                newNode = new UndirectedGraphNode(n.label);
                newMap.put(n.label, newNode);

                if (result == null)
                    result = newNode;
            }

            for (UndirectedGraphNode neighbor : n.neighbors) {
                if (!todo.contains(neighbor) && !done.contains(neighbor))
                    todo.add(neighbor);

                UndirectedGraphNode newNeighbor = newMap.get(neighbor.label);
                if (newNeighbor == null) {
                    newNeighbor = new UndirectedGraphNode(neighbor.label);
                    newMap.put(neighbor.label, newNeighbor);
                }
                newNode.neighbors.add(newNeighbor);
            }
        }
        return result;
    }
}
