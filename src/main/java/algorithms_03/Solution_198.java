package algorithms_03;

import java.util.Arrays;

/**
 * 动态规划问题总结：
 *  1. 定义子问题：问题可以由递推关系进行表示
 *  2. 递推关系
 *  3. base case
 *  3. 确定 dp 数组的计算顺序
 *  4. 空间优化
 * @author wheat
 * @date 2023/12/18  14:28
 */
public class Solution_198 {

    /**
     * 动态规划 - 自顶向下
     *
     * 1. 选择导致状态发生变化
     * 2. dp[n, n - 1, ... , 0] -> dp[n]
     *
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }

    private int[] memo;

    private int dp(int[] nums, int start) {
        // base case
        if (start >= nums.length) return 0;

        // memo
        if (memo[start] != -1) {
            return memo[start];
        }

        // 每个位置共两种选择
        // 选择当前位置
        int subProblem1 = dp(nums, start + 2);
        // 不选择当前位置
        int subProblem2 = dp(nums, start + 1);

        int res = Math.max(subProblem1 + nums[start], subProblem2);
        memo[start] = res;
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划 - 自底向上
     * @param nums
     * @return
     */
    public int rob_2(int[] nums) {
        // 边界情况
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);

        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[nums.length - 1];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划 - 自底向上
     * 保存每个位置的两种状态
     * @param nums
     * @return
     */
    public int rob_3(int[] nums) {
        if(nums == null || nums.length == 0) return 0;

        int n = nums.length;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = nums[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1]);
            dp[i][1] = dp[i - 1][0] + nums[i];
        }

        return Math.max(dp[n - 1][0], dp[n - 1][1]);
    }

}
