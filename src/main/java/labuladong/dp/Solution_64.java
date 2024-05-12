package labuladong.dp;

import java.util.Arrays;

/**
 * 给定一个包含非负整数的 m x n 网格 grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 *
 * @author wheat
 * @date 2024/04/24  14:56
 */
public class Solution_64 {

    /**
     * 动态规划 - 迭代解法
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];

        // base case
        dp[0][0] = grid[0][0];
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划 - 递归解法
     * @param grid
     * @return
     */
    public int minPathSum_2(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // dp table
        this.memo = new int[m][n];
        // 初始化
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }
        return dp(grid, m - 1, n - 1);
    }

    /**
     * dp table
     */
    private int[][] memo;

    /**
     * 递归函数定义：
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dp(int[][] grid, int i, int j) {
        // base case
        if (i == 0 && j == 0) {
            return grid[0][0];
        }

        if (i < 0 || j < 0) {
            return Integer.MAX_VALUE;
        }

        // 备忘录 避免重复计算
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        // 左边和上面的最小路径和加上 grid[i][j]
        // 就是到达 (i, j) 的最小路径和
        int res = Math.min(dp(grid, i - 1, j), dp(grid, i, j - 1)) + grid[i][j];
        // 计算过的结果存入备忘录
        memo[i][j] = res;
        return res;
    }

}
