package algorithms_05;

import java.util.Arrays;

/**
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 *
 * @author wheat
 * @date 2024/05/24  15:11
 */
public class Solution_279 {

    public int numSquares(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return dp(n);
    }

    private int[] memo;

    private int dp(int n) {

        if (n == 0) return 0;

        if (memo[n] != -1) return memo[n];

        int res = Integer.MAX_VALUE;
        for (int i = (int)Math.sqrt(n); i >= 1; i--) {
            int subProblem = dp(n - i * i);
            res = Math.min(res, subProblem + 1);
        }

        memo[n] = res;
        return res;
    }

}
