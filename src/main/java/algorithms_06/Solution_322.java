package algorithms_06;

import java.util.Arrays;

/**
 * @Author: wheat
 * @Date: 2026/10/25 14:09
 * @Version: v1.0.0
 **/
public class Solution_322 {

    /**
     * dp数组的迭代解法
     * 可以自底向上使用 dp table 来消除重叠子问题
     * dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
     * @param coins
     * @param amount
     * @return
     */
    int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);

        // base case
        dp[0] = 0;
        // 外层 for 循环在遍历所有状态的所有取值
        // 状态变量只有一个
        for (int i = 0; i < dp.length; i++) {
            // 内层 for 循环在求所有选择的最小值
            for (int coin : coins) {
                // 子问题无解，跳过
                if (i - coin < 0) continue;

                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
