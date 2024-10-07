package labuladong.dp;

import java.util.Arrays;

/**
 * 地下城游戏
 * @author wheat
 * @date 2024/04/29  9:42
 */
public class Solution_174 {

    /**
     * 动态规划问题
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length, n = dungeon[0].length;
        this.memo = new int[m][n];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(dungeon, 0, 0);
    }

    /**
     * 备忘录
     */
    private int[][] memo;

    /**
     * dp函数定义：从（i,j）至（m-1,n-1）需要的最低血量
     * @param grid
     * @param i
     * @param j
     * @return
     */
    private int dp(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // base case
        if (i == m || j == n) return Integer.MAX_VALUE;
        if (i == m - 1 && j == n - 1) return grid[m - 1][n - 1] <= 0 ? 1 - grid[m - 1][n - 1] : 1;

        // 避免重复计算
        if (memo[i][j] != -1) return memo[i][j];

        // 状态转移逻辑
        int res = Math.min(
                dp(grid, i + 1, j),
                dp(grid, i, j + 1)) - grid[i][j];
        res = res <= 0 ? 1 : res;
        memo[i][j] = res;
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 自底向上
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP_2(int[][] dungeon) {

        int m = dungeon.length, n = dungeon[0].length;

        // dp[]
        int[][] dp = new int[m][n];
        // 初始化
        dp[m - 1][n - 1] = dungeon[m - 1][n - 1] >= 0 ? 1 : 1 - dungeon[m - 1][n - 1];

        // 边界值
        // 最后一行
        for (int j = n - 2; j >= 0; j--) {
            int val = dungeon[m - 1][j] - dp[m - 1][j + 1];
            dp[m - 1][j] = val >= 0 ? 1 : -val;
        }
        // 最后一列
        for (int i = m - 2; i >= 0; i--) {
            int val = dungeon[i][n - 1] - dp[i + 1][n - 1];
            dp[i][n - 1] = val >= 0 ? 1 : -val;
        }

        // 迭代
        for (int i = m - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                int val = dungeon[i][j] - Math.min(dp[i + 1][j], dp[i][j + 1]);
                dp[i][j] = val >= 0 ? 1 : -val;
            }
        }

        return dp[0][0];
    }

    public static void main(String[] args) {
//        int[][] dungeon = new int[][] {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        int[][] dungeon = new int[][] {{0,0}};
        new Solution_174().calculateMinimumHP_2(dungeon);
    }


}
