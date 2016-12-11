package houxiaomu.leetcodeplayground.best_time_to_buy_and_sell_stock;

import houxiaomu.leetcodeplayground.BaseSolution;

/**
 * Created by Simon on 2016/12/4.
 */
public class Solution extends BaseSolution {
    public int maxProfit(int[] prices) {
        int max = 0, maxSoFar = 0;
        for (int i = 1; i < prices.length; i++) {
            max += prices[i] - prices[i - 1];
            max = Math.max(0, max);
            maxSoFar = Math.max(max, maxSoFar);
        }
        return maxSoFar;
    }
}
