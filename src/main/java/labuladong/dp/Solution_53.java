package labuladong.dp;

import java.util.Arrays;
import java.util.Map;

/**
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组是数组中的一个连续部分。
 *
 * 总结：像子数组、子序列的问题，可以尝试定义dp[i] 是以 nums[i] 为结尾的最大子数组和/最长递增子序列，
 *      因为这样定义更容易将 dp[i+1] 和 dp[i] 建立起联系，利用数学归纳法写出状态转移方程。
 *
 * @author wheat
 * @date 2024/04/23  9:12
 */
public class Solution_53 {

    /**
     * 动态规划 - dp函数 - 自顶向下
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        this.memo = new int[nums.length];
        Arrays.fill(memo, Integer.MIN_VALUE);

        dp(nums, nums.length - 1);

        int res = Integer.MIN_VALUE;
        for (int i = 0; i < memo.length; i++) {
            res = Math.max(res, memo[i]);
        }

        return res;
    }

    /**
     * 备忘录
     */
    private int[] memo;

    /**
     * dp函数定义：以 nums[i] 为结尾的「最大子数组和」为 dp[i]
     * @param nums
     * @param index
     * @return
     */
    private int dp(int[] nums, int index) {
        // base case
        if (index == -1) return 0;

        // 备忘录
        if (this.memo[index] != Integer.MIN_VALUE) return this.memo[index];

        int subProblem = dp(nums, index - 1);
        this.memo[index] = subProblem > 0 ? subProblem + nums[index] : nums[index];
        return this.memo[index];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 滑动窗口解法 窗口内值总和大于0扩大窗口 否则缩小窗口
     * @param nums
     * @return
     */
    public int maxSubArray_2(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while(right < nums.length){
            // 扩大窗口并更新窗口内的元素和
            windowSum += nums[right];
            right++;

            // 更新答案
            maxSum = windowSum > maxSum ? windowSum : maxSum;

            // 判断窗口是否要收缩
            while(windowSum < 0) {
                // 缩小窗口并更新窗口内的元素和
                windowSum -= nums[left];
                left++;
            }
        }
        return maxSum;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划 - 迭代解法
     * @param nums
     * @return
     */
    public int maxSubArray_3(int[] nums) {
        // 定义：dp[i] 记录以 nums[i] 为结尾的「最大子数组和」
        int[] dp = new int[nums.length];

        // base case
        dp[0] = nums[0];

        // 状态转移方程
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }

        // 得到 nums 的最大子数组
        int res = Integer.MIN_VALUE;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 前缀和思路
     * 前缀和数组：前缀和数组 preSum 就是 nums 元素的累加和，preSum[i+1] - preSum[j] 其实就是子数组 nums[j..i] 之和
     * @param nums
     * @return
     */
    public int maxSubArray_4(int[] nums) {
        int[] preSum = new int[nums.length + 1];
        preSum[0] = 0;
        // 构造 nums 的前缀和数组
        for (int i = 0; i < nums.length; i++) {
            preSum[i + 1] = preSum[i] + nums[i];
        }
        
        int res = Integer.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            // 维护 minVal 是 preSum[0..i] 的最小值
            minVal = Math.min(minVal, preSum[i]);
            // 以 nums[i] 结尾的最大子数组和就是 preSum[i+1] - min(preSum[0..i])
            res = Math.max(res, preSum[i + 1] - minVal);
        }

        return res;
    }

}
