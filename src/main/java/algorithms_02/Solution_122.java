package algorithms_02;

/**
 * Description:
 * @author wheat
 * @date 2023/04/24  17:38
 */
public class Solution_122 {

//    private int[] prices;
//    private int maxProfit;
//
//    public int maxProfit(int[] prices){
//
//        // 边界情况
//        if(prices == null || prices.length <= 1) return 0;
//
//        this.prices = prices;
//        this.maxProfit = 0;
//
//        dfs(0, 0, false);
//
//        return this.maxProfit;
//
//    }
//
//    /**
//     * 模拟真实的股票操作情况 可以不进行买卖直接进入下一天 买或卖
//     * @param currentDay
//     * @param profit 这只股票每日的价格
//     * @param status false-不持有股票 true-持有股票
//     */
//    public void dfs(int currentDay, int profit, boolean status){
//        // 递归结束条件
//        if(currentDay == this.prices.length){
//            this.maxProfit = this.maxProfit > profit ? this.maxProfit : profit;
//            return;
//        }
//
//        // 今天不进行操作
//        dfs(currentDay + 1, profit, status);
//
//        // 进行操作
//        if(status == false){ // 买入
//            dfs(currentDay + 1, profit - prices[currentDay], !status);
//        }else{  //卖出
//            dfs(currentDay + 1, profit + prices[currentDay], !status);
//        }
//    }

    // 动态规划
    public int maxProfit(int[] prices){

        // 边界情况
        if(prices == null || prices.length <= 1) return 0;

        // 第一维表示天数 第二维的下标表示是否持有股票 值表示自己自己手上的利润
        int[][] dp = new int[prices.length][2];

        // 第一天赋初值
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for(int i = 1; i < prices.length; i++){
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[prices.length - 1][0];

    }

}
