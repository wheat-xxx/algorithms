package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/08  15:37
 */
public class Solution_63 {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // 保存中间结果
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];

        for(int i = 0; i < obstacleGrid.length && obstacleGrid[i][0] != 1; i++) dp[i][0] = 1;
        for(int i = 0; i < obstacleGrid[0].length && obstacleGrid[0][i] != 1; i++) dp[0][i] = 1;
        for(int i = 1; i < obstacleGrid.length; i++){
            for(int j = 1; j < obstacleGrid[0].length; j++){
                if(obstacleGrid[i][j] == 1) continue;
                else dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[dp.length - 1][dp[0].length - 1];
    }

}
