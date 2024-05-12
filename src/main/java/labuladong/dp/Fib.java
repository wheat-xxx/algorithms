package labuladong.dp;

/**
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和
 * @author wheat
 * @date 2024/04/18  21:03
 */
public class Fib {

    /**
     * 自顶向下递归求解
     * @param n
     * @return
     */
    public int fib(int n) {
        // base case
        if (n == 0 || n == 1) return n;
        else return fib(n - 1) + fib(n - 2);
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 自顶向下递归求解
     * 重叠子问题
     * 备忘录
     * @param n
     * @return
     */
    public int fib_2(int n) {
        // 备忘录
        int[] memo = new int[n + 1];
        // 进行带备忘录的递归
        return dp(memo, n);
    }

    /**
     * 决策树 通过备忘录进行剪枝
     * @param memo
     * @param n
     * @return
     */
    private int dp(int[] memo, int n) {
        // base case
        if (n == 0 || n == 1) return n;
        // 已经计算过，不用再计算了
        if (memo[n] != 0) return memo[n];
        memo[n] = dp(memo, n - 1) + dp(memo, n - 2);
        return memo[n];
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 自底向上进行迭代
     * @param n
     * @return
     */
    public int fib_3(int n) {
        if (n == 0) return 0;   // 后面需要设置dp[1]
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0; dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 自底向上进行迭代
     * 优化备忘录结构
     * @param n
     * @return
     */
    public int fib_4(int n) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }

        // 分别代表 dp[i - 1] 和 dp[i - 2]
        int dp_i_1 = 1, dp_i_2 = 0;
        for (int i = 2; i <= n; i++) {
            // dp[i] = dp[i - 1] + dp[i - 2];
            int dp_i = dp_i_1 + dp_i_2;
            // 滚动更新
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }
        return dp_i_1;
    }

}
