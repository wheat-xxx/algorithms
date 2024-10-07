package algorithms_04;

import java.util.Arrays;

/**
 * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
 * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
 * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。
 *
 * @author wheat
 * @date 2024/07/14  15:58
 */
public class Solution_213 {

    /**
     * 动态规划 - 递归解法
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        // base case
        if (nums.length == 1) return nums[0];

        int len = nums.length;
        memo = new int[len];
        Arrays.fill(memo, -666);
        // 包含第一个 不包含最后一个
        int res1 = dp(nums, 0, len - 2);
        Arrays.fill(memo, -666);
        // 包含最后一个，不包含第一个
        int res2 = dp(nums, 1, len - 1);
        return Math.max(res1, res2);
    }

    /**
     * 备忘录
     */
    private int[] memo;

    /**
     * 递归解法 - 自顶向下
     * 是否具有最优解
     * @param nums
     * @param start
     * @param end
     * @return
     */
    private int dp(int[] nums, int start, int end) {

        // base case
        if (start > end) {
            return 0;
        }

        if (memo[start] != -666) {
            return memo[start];
        }

        int res = Math.max(
          dp(nums, start + 2, end) + nums[start],
          dp(nums, start + 1, end)
        );

        this.memo[start] = res;

        return res;

    }

}
