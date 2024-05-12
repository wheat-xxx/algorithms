package labuladong.dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * 你可以认为每种硬币的数量是无限的。
 *
 * @author wheat
 * @date 2024/03/21  14:42
 */
public class CoinChange {

    /**
     * 如何列出正确的状态转移方程：
     * 1. base case: amount = 0;
     * 2. 状态：原问题和子问题中会变化的变量，amount
     * 3. 选择：硬币面值，导致状态产生变化的行为
     * 4. 明确dp函数/数组的定义：函数参数就是状态，返回值就是求的最值
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return dp(coins, amount);
    }

    /**
     * dp函数定义：要凑出金额 n，至少要 dp(coins, n) 个硬币
     * @param coins
     * @param amount
     * @return
     */
    private int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) return 0;
        if (amount < 0) return -1;  // 无解

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中寻找最优解
            res = Math.min(res, subProblem + 1);
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    private int[] memo;

    /**
     * 带备忘录的递归
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange_2(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memo, -666);

        return dp_2(coins, amount);
    }

    private int dp_2(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 查备忘录，防止重复计算
        if(memo[amount] != -666) {
            return memo[amount];
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp_2(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        res = res == Integer.MAX_VALUE ? -1 : res;
        memo[amount] = res;
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * dp数组的迭代解法
     * 可以自底向上使用 dp table 来消除重叠子问题
     * dp 数组的定义：当目标金额为 i 时，至少需要 dp[i] 枚硬币凑出
     * @param coins
     * @param amount
     * @return
     */
    int coinChange_3(int[] coins, int amount) {
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
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
            }
        }
        return (dp[amount] == amount + 1) ? -1 : dp[amount];
    }

}
