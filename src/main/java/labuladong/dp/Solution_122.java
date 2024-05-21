package labuladong.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * 返回 你能获得的 最大 利润 。
 *
 * @author wheat
 * @date 2024/05/21  11:33
 */
public class Solution_122 {

    /**
     * 选择每个上升期购买股票 -> 求prices的峰谷值
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        List<Integer> profits = new ArrayList<>();
        int i = 0, j = 0;
        while (i < prices.length && j < prices.length) {
            while (i + 1 < prices.length && prices[i] >= prices[i + 1]) {
                i++;
            }
            j = i;
            while (j + 1 < prices.length && prices[j] <= prices[j + 1]) {
                j++;
            }
            // i = j = prices.length - 1
            if (i == j) break;
            profits.add(prices[j] - prices[i]);
            i = j;
        }

        int res = 0;
        for (i = 0; i < profits.size(); i++) {
            res += profits.get(i);
        }
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划解法
     * 如何判断这是一个dp问题？
     * @param prices
     * @return
     */
    public int maxProfit_2(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                dp[0][0] = 0;
                dp[0][1] = -prices[0];
                continue;
            }

            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[prices.length - 1][0];
    }
}
