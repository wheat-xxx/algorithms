package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/08  15:47
 */
public class Solution_64 {

    /**
     * 动态规划
     * @param grid
     * @return
     */
    public int minPathSum(int[][] grid) {
        // 利用二维数组保存走到当前格子最小值
        int[][] dp = new int[grid.length][grid[0].length];
        //初始化
        dp[0][0] = grid[0][0];
        for(int i = 1; i < grid.length; i++) dp[i][0] = dp[i - 1][0] + grid[i][0];
        for(int i = 1; i < grid[0].length; i++) dp[0][i] = dp[0][i - 1] + grid[0][i];
        for(int i = 1; i < grid.length; i++){
            for(int j = 1; j < grid[0].length; j++){
                dp[i][j] = dp[i - 1][j] < dp[i][j - 1] ? (dp[i - 1][j] + grid[i][j]) : (dp[i][j - 1] + grid[i][j]);
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

}
