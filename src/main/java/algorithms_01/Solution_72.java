package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/11  16:46
 */
public class Solution_72 {

    public int minDistance(String word1, String word2){
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // 初始化动态规划矩阵
        for(int j = 1; j <= n2; j++) dp[0][j] = j;
        for(int i = 1; i <= n1; i++) dp[i][0] = i;

        // dp填充
        for(int i = 1; i <= n1; i++){
            for(int j = 1; j <= n2; j++){
                if(word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i-1][j-1];
                else{
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
                }
            }
        }

        return dp[n1][n2];
    }

}
