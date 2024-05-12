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

}
