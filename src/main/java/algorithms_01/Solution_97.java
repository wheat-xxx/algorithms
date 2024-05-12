package algorithms_01;

/**
 * Description:
 *
 *      交错字符串 使用动态规划
 *
 * @author wheat
 * @date 2023/04/04  11:21
 */
public class Solution_97 {

    public boolean isInterleave(String s1, String s2, String s3) {

        if(s1.length() + s2.length() != s3.length()) return false;

        boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];

        dp[0][0] = true;

        // 状态转移方程
        for(int i = 0; i <= s1.length(); i++){
            for(int j = 0; j <= s2.length(); j++){
                if(i > 0) dp[i][j] = dp[i][j] || dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
                if(j > 0) dp[i][j] = dp[i][j] || dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
            }
        }

        return dp[s1.length()][s2.length()];
    }


}
