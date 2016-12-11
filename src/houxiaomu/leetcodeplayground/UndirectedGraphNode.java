package houxiaomu.leetcodeplayground;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Simon on 2016/12/4.
 */
public class UndirectedGraphNode {
    public int label;
    public List<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
