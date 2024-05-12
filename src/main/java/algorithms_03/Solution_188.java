package algorithms_03;

import javax.sql.DataSource;
import java.util.*;

/**
 * 动态规划的难点：
 * 1. 动态规划 矩阵或向量如何设定
 * 2. 矩阵或向量 如何初始化
 * 3. 转移方程
 * @author wheat
 * @date 2023/12/14  11:26
 */
public class Solution_188 {

    /**
     *
     * @param k 最多能交易多少次
     * @param prices 每天的股票价格
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        Map<Integer, Integer> map = new HashMap<>();
        // 寻找股票适合的买入时机
        int index = 0;
        while(index < prices.length) {
            if(index + 1 < prices.length && prices[index] >= prices[index + 1]) {
                index++;
                continue;
            }
            // 确定一个股票买入时机
            int start = index;
            index += 1;
            while(index < prices.length && prices[index] >= prices[index - 1]) {
                index++;
            }
            index -= 1;
            if(index > start) {
                map.put(start, index);
            }
            index++;
        }

        List<Integer> profits = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            profits.add(prices[entry.getValue()] - prices[entry.getKey()]);
        }

        Collections.sort(profits);
        Collections.reverse(profits);
        int res = 0;
        for (int i = 0; i < profits.size() && i < k; i++) {
            res += profits.get(i);
        }
        // 特殊情况：如果profits的长度大于k，计算出的利润不一定是最大值
        // 例如：prices = [1,2,4,2,5,7,2,4,9,0]， k = 2

        return res;
    }

    public int maxProfit_2(int k, int[] prices) {
        // 边界情况
        if(k <= 0 || prices == null || prices.length == 0) return 0;

        // 动态规划存储中间计算结果
        int[] buy = new int[k];
        int[] sell = new int[k];

        Arrays.fill(buy, -prices[0]);

        // 买卖一次至少是从第二天开始的
        for(int i = 1; i < prices.length; i++) {
            // 初始化交易一次的情况
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for(int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j-1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }

        return sell[k-1];
    }

}
