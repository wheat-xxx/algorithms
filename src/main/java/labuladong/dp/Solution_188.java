package labuladong.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 *
 *
 * @author wheat
 * @date 2024/05/21  10:43
 */
public class Solution_188 {

//    /**
//     * 选择每个上升期购买股票 -> 求prices的峰谷值
//     * 考虑不够周全 如果 k < 上升期的个数 那么有可能几个上升期可以合并从而使利润最大化
//     * @param k
//     * @param prices
//     * @return
//     */
//    public int maxProfit(int k, int[] prices) {
//        List<Integer> profits = new ArrayList<>();
//        int i = 0, j = 0;
//        while (i < prices.length && j < prices.length) {
//            while (i + 1 < prices.length && prices[i] >= prices[i + 1]) {
//                i++;
//            }
//            j = i;
//            while (j + 1 < prices.length && prices[j] <= prices[j + 1]) {
//                j++;
//            }
//            // i = j = prices.length - 1
//            if (i == j) break;
//            profits.add(prices[j] - prices[i]);
//            i = j;
//        }
//
//        profits.sort((a, b) -> (b - a));
//        int res = 0;
//        for (i = 0; i < profits.size() && i < k; i++) {
//            res += profits.get(i);
//        }
//        return res;
//    }

    /**
     * 动态规划问题
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k][2];

        for (int i = 0; i < prices.length; i++) {
            // base case
            if (i == 0) {
                for (int j = 0; j < k; j++) {
                    dp[0][j][0] = 0;
                    dp[0][j][1] = -prices[0];
                }
                continue;
            }
            for (int j = 0; j < k; j++) {   // 0对应交易一次
                // base case
                if (j == 0) {
                    dp[i][0][0] = Math.max(dp[i - 1][0][0], dp[i - 1][0][1] + prices[i]);
                    dp[i][0][1] = Math.max(dp[i - 1][0][1], -prices[i]);
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[prices.length - 1][k - 1][0];
    }

}
