package houxiaomu.leetcodeplayground.gas_station;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        final int len = gas.length;
        for (int start = 0; start < len; start++) {
            int curGas = 0;
            for (int i = 0; i < len; i++) {
                int curIndex = (start + i) % len;
                curGas += gas[curIndex];
                curGas -= cost[curIndex];
                if (curGas < 0) {
                    start += i;
                    break;
                }
            }
            if (curGas >= 0) return start;
        }
        return -1;
    }
}
