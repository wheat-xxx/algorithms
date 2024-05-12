package labuladong.dp;

import java.util.Arrays;

/**
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列
 *
 * 设计动态规划算法，不是需要一个 dp 数组吗？我们可以假设 dp[0...i-1] 都已经被算出来了，然后问自己：怎么通过这些结果算出 dp[i]？
 * 这里需要明确dp数组的含义
 *
 * 动态规划找状态转移方程的步骤：
 *  1. 明确dp数组的定义。很重要
 *  2. 根据 dp 数组的定义，运用数学归纳法的思想，假设 dp[0...i-1] 都已知，想办法求出 dp[i]
 *
 * @author wheat
 * @date 2024/04/19  9:52
 */
public class Solution_300 {

    /**
     * 动态规划 迭代解法
     * dp数组定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        // 定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        for (int i = 1; i < nums.length; i++) {
            int j = i;
            while (--j >= 0) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

}
