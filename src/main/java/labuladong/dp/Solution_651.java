package labuladong.dp;

/**
 * 假设你有一个特殊的键盘，上面只有四个键，它们分别是：
 * 1、A 键：在屏幕上打印一个 A。
 * 2、Ctrl-A 键：选中整个屏幕。
 * 3、Ctrl-C 键：复制选中的区域到缓冲区。
 * 4、Ctrl-V 键：将缓冲区的内容输入到光标所在的屏幕上。
 *
 * 现在要求你只能进行 N 次操作，请你计算屏幕上最多能显示多少个 A？
 * @author wheat
 * @date 2024/05/17  17:14
 */
public class Solution_651 {

    /**
     * 动态规划 迭代解法
     * 
     * @param N
     * @return
     */
    public int maxA(int N) {
        int[] dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        int buffer = 0;
        for (int i = 3; i < N + 1; i++) {
            int res = 0;
            // 1. A键
            int subProblem1 = dp[i - 1] + 1;
            // 2. Ctrl-V 键
            int subProblem2 = dp[i - 1] + buffer;
            res = Math.max(subProblem1, subProblem2);
            if (res <= dp[i - 3] + buffer) {
                // 3. ctrl-A + ctrl-C + ctrl-V  具有更新缓冲区的作用
                res = dp[i - 3] * 2;
                buffer = dp[i - 3];
            }
            dp[i] = res;
        }
        return dp[N];
    }

}
