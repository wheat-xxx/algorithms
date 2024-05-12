package algorithms_02;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/25  18:52
 */
public class Solution_123 {

    public int maxProfit(int[] prices){

        if(prices == null || prices.length <= 1) return 0;

        // 第一维表示天数 第二维表示买入了几次 第三维表示当前是否持有
        int[][][] dp = new int[prices.length][3][2];

        // dp初始化 前两种情况可以不用考虑
        dp[0][0][0] = 0;
        dp[0][0][1] = 0;  // 不存在这种情况
        dp[0][1][0] = 0;  // 不存在这种情况
        dp[0][1][1] = -prices[0];
        dp[0][2][0] = 0;  // 不存在这种情况
        dp[0][2][1] = 0;  // 不存在这种情况

        for(int i = 1; i < prices.length; i++){
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], -prices[i]);
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
        }

        return Math.max(dp[prices.length - 1][1][0], dp[prices.length - 1][2][0]);

    }

}
