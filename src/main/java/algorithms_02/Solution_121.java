package algorithms_02;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/24  15:39
 */
public class Solution_121 {

//    /**
//     * 暴力破解
//     * @param prices
//     * @return
//     */
//    public int maxProfit(int[] prices){
//
//        // 返回值
//        int ret = 0;
//
//        // 边界情况
//        if(prices == null || prices.length == 0 || prices.length == 1) return ret;
//
//        // 暴力破解
//        for(int i = prices.length - 1; i >= 1; i--){
//            for(int j = i - 1; j >= 0; j--){
//                if(ret < prices[i] - prices[j]) ret = prices[i] - prices[j];
//            }
//        }
//
//        return ret;
//    }

    /**
     * 使用动态规划
     * @param prices
     * @return
     */
//    public int maxProfit(int[] prices){
//
//        int ret = 0;
//
//        if(prices == null || prices.length == 0 || prices.length == 1) return ret;
//
//        int[] dp = new int[prices.length];
//
//        for(int i = prices.length - 1; i >= 1; i--){
//            if(i + 1 < prices.length && dp[i + 1] <= i) dp[i] = dp[i + 1];
//            else{
//                int min = i;
//                for(int j = i; j >= 0; j--){
//                    if(prices[min] > prices[j]) min = j;
//                }
//                dp[i] = min;
//            }
//        }
//
//        for(int i = 1; i < prices.length; i++){
//            ret = (ret > (prices[i] - prices[dp[i]])) ? ret : (prices[i] - prices[dp[i]]);
//        }
//
//        return ret;
//    }

    public int maxProfit(int[] prices){

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++)
            if(prices[i] < minPrice) minPrice = prices[i];
            else maxProfit = maxProfit > (prices[i] - minPrice) ? maxProfit : (prices[i] - minPrice);

        return maxProfit;
    }

}
