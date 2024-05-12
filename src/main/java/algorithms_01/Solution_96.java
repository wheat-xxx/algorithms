package algorithms_01;

/**
 * Description:
 *
 *      使用递归实现
 *
 * @author wheat
 * @date 2023/04/03  16:42
 */
public class Solution_96 {

    public int numTrees(int n) {

        int[] dp = new int[n + 1];
        // 初始化
        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2; i <= n; i++){
            for(int j = 0; j < i; j++){
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];
    }


}
