package algorithms_06;

import java.util.HashMap;
import java.util.Map;

/**
 * 有 n 个气球，编号为0 到 n - 1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 * 现在要求你戳破所有的气球。戳破第 i 个气球，你可以获得 nums[i - 1] * nums[i] * nums[i + 1] 枚硬币。
 * 这里的 i - 1 和 i + 1 代表和 i 相邻的两个气球的序号。如果 i - 1或 i + 1 超出了数组的边界，那么就当它是一个数字为 1 的气球。
 * 求所能获得硬币的最大数量。
 *
 * @author wheat
 * @date 2024/07/20  20:28
 */
public class Solution_312 {

    /**
     * 动态规划 - 迭代解法
     * dp数组定义：dp[i][j] = x 表示，戳破气球 i 和气球 j 之间（开区间，不包括 i 和 j）的所有气球，可以获得的最高分数为 x。
     * @param nums
     * @return
     */
    public int maxCoins(int[] nums) {
        int n = nums.length;
        // 添加两侧的虚拟气球
        int[] points = new int[n + 2];
        points[0] = points[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            points[i + 1] = nums[i];
        }

        int[][] dp = new int[n + 2][n + 2];
        // 开始状态转移
        // 从下往上 从左往右
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j < n + 2; j++) {
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][k] + points[i] * points[k] * points[j] + dp[k][j]);
                }
            }
        }

        return dp[0][n+1];
    }

}
