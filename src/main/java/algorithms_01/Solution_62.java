package algorithms_01;

import org.junit.Test;

import java.math.BigInteger;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/08  11:47
 */
public class Solution_62 {

//    public int uniquePaths(int m, int n) {
//
//        // m 个相同元素 n个相同元素 进行排列的个数
//        BigInteger MN = factorial(m + n - 2);
//        BigInteger M = factorial(m - 1);
//        BigInteger N = factorial(n - 1);
//        BigInteger res = MN.divide(M);
//        res = res.divide(N);
//
//        return res.intValue();
//
//    }
//
//    private BigInteger factorial(int n){
//        BigInteger res = new BigInteger("1");
//        while(n > 1){
//            res = res.multiply(new BigInteger(String.valueOf(n)));
//            n--;
//        }
//        return res;
//    }

    /**
     * 动态规划思路
     * @param m
     * @param n
     * @return
     */
    public int uniquePaths(int m, int n) {

        int[][] dp = new int[m][n];

        for(int i = 0; i < m; i++) dp[i][0] = 1;
        for(int i = 0; i < n; i++) dp[0][i] = 1;
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m-1][n-1];
    }

    @Test
    public void test(){
        System.out.println(uniquePaths(10, 10));
    }

}
