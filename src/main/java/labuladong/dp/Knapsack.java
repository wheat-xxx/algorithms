package labuladong.dp;

import org.junit.Test;

/**
 * 0-1背包问题：给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。其中第 i 个物品的重量为 wt[i]，价值为 val[i]。
 *            现在让你用这个背包装物品，每个物品只能用一次，在不超过背包容量的前提下，最多能装的价值是多少？
 *
 * dp思路：
 *  1. 明确状态和选择
 *      状态：背包的容量、可选择的物品
 *      选择：装进背包 不装进背包
 *  2. dp数组的定义：
 *  3. 根据选择，思考状态转移的逻辑
 *
 * 选择引起状态的改变
 *
 * @author wheat
 * @date 2024/04/23  11:21
 */
public class Knapsack {

    /**
     * 动态规划 - 迭代解法
     * @param W 背包容量
     * @param N 物品数量
     * @param wt 物品重量
     * @param val 物品价值
     * @return
     */
    public int knapsack(int W, int N, int[] wt, int[] val) {

        // dp数组：
        int[][] dp = new int[N + 1][W + 1];

        for (int i = 1; i <= N; i++) {
            for (int w = 1; w <= W; w++) {
                // 当前物品大小超出背包限制
                if (w - wt[i - 1] < 0) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    // 装入或者不装入背包，择优
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - wt[i - 1]] + val[i - 1]);
                }
            }
        }

        return dp[N][W];

    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 自顶向下解法
     * @param W
     * @param N
     * @param wt
     * @param val
     * @return
     */
    public int knapsack_2(int W, int N, int[] wt, int[] val) {
        this.wt = wt;
        this.val =val;
        return dp(W, N, W, N);
    }

    private int[] wt;
    private int[] val;


    /**
     * dp函数定义：背包重量为w，物品数量为n的情况下，最大价值
     * @param W
     * @param N
     * @param w
     * @param n
     * @return
     */
    private int dp(int W, int N, int w, int n) {
        // base case
        if (w < 0 || n < 0) {
            return Integer.MIN_VALUE;
        }
        if (w == 0 || n == 0) {
            return 0;
        }

        int res = 0;
        // 两种选择
        // 不选择物品 n
        res = Math.max(res, dp(W, N, w, n - 1));
        // 选择当前物品
        res = Math.max(res, dp(W, N, w - wt[n - 1], n - 1));

        return res;
    }

}
