package algorithms_02;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/12  16:42
 */
public class Solution_115 {

    public int numDistinct(String s, String t) {

        int m = s.length(), n = t.length();
        if(m < n) return 0;

        int[][] dp = new int[m + 1][n + 1];

        // 空字符串是任何字符串的子串
        for(int i = 0; i <= m; i++){
            dp[i][n] = 1;
        }

        // 先行后列
        for(int i = m - 1; i >= 0; i--){
            for(int j = n - 1; j >= 0; j--){
                if(s.charAt(i) == t.charAt(j)){
                    dp[i][j] = dp[i + 1][j + 1] + dp[i + 1][j];
                }else {
                    dp[i][j] = dp[i + 1][j];
                }
            }
        }

        return dp[0][0];
    }

}
