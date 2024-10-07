package labuladong.dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * 假设每一种面额的硬币有无限个。
 *
 * @author wheat
 * @date 2024/04/24  9:36
 */
public class Solution_518 {

    /**
     * 动态规划
     * 有重复解
     * @param amount
     * @param coins
     * @return
     */
    public int change(int amount, int[] coins) {
        memo = new int[amount + 1];
        Arrays.fill(this.memo, -1);
        return dp(coins, amount);
    }

    private int[] memo;

    /**
     * 状态只有一个 - amount
     * 选择 - coins
     * @param coins
     * @param amount
     * @return
     */
    private int dp(int[] coins, int amount) {
        // base case
        if (amount == 0) {
            return 1;
        }
        if (amount < 0) {
            return 0;
        }

        // memo
        if (memo[amount] != -1) return memo[amount];

        int res = 0;
        for (int coin : coins) {
            res += dp(coins, amount - coin);
        }

        memo[amount] = res;
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 转为背包问题
     * dp数组定义：若只使用前 i 个物品（可以重复使用），当背包容量为 j 时，有 dp[i][j] 种方法可以装满背包
     * @param amount
     * @param coins
     * @return
     */
    public int change_2(int amount, int[] coins) {

        int[][] dp = new int[coins.length + 1][amount + 1];
        // base case
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int val = 1; val <= amount; val++) {
                if (coins[i - 1] - val > 0) {
                    dp[i][val] = dp[i - 1][val];
                } else {
                    dp[i][val] = dp[i - 1][val] + dp[i][val - coins[i - 1]];
                }
            }
        }

        return dp[coins.length][amount];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划 空间压缩
     * 空间压缩 上一步的状态必须已经计算过了
     * @param amount
     * @param coins
     * @return
     */
    public int change_3(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // base case
        dp[0] = 1;

        for (int i = 0; i <= coins.length - 1; i++) {
            for (int val = 1; val <= amount; val++) {
                if (coins[i] - val <= 0) {
                    dp[val] = dp[val] + dp[val - coins[i]];
                }
            }
        }

        return dp[amount];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 自底向上 有重复解
     * @param amount
     * @param coins
     * @return
     */
    public int change_4(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] += dp[i - coin];
                }
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {
        new Solution_518().change_4(5, new int[]{1,2,5});
    }

}
