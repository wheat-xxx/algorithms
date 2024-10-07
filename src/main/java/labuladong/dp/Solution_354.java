package labuladong.dp;

import java.util.Arrays;
import java.util.Collections;

/**
 * 给你一个二维整数数组 envelopes ，其中 envelopes[i] = [wi, hi] ，表示第 i 个信封的宽度和高度。
 * 当另一个信封的宽度和高度都比这个信封大的时候，这个信封就可以放进另一个信封里，如同俄罗斯套娃一样。
 * 请计算 最多能有多少个 信封能组成一组“俄罗斯套娃”信封（即可以把一个信封放到另一个信封里面）。
 * 注意：不允许旋转信封。
 *
 * @author wheat
 * @date 2024/04/19  10:58
 */
public class Solution_354 {
    /**
     * 信封大小不是有序的，需要先进行排序
     * 正确：超时
     *
     * @param envelopes
     * @return
     */
    public int maxEnvelopes(int[][] envelopes) {

        // 先对信封大小进行排序
        Arrays.sort(envelopes, (int[] envelop1, int[] envelop2) -> {
            return envelop1[0] == envelop2[0] ? envelop1[1] - envelop2[1] : envelop1[0] - envelop2[0];
        });

        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < envelopes.length; i++) {
            int j = i;
            while (--j >= 0) {
                if (envelopes[i][0] > envelopes[j][0] && envelopes[i][1] > envelopes[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 借助最长递增子序列求解
     * @param envelopes
     * @return
     */
    public int maxEnvelopes_2(int[][] envelopes) {
        int n = envelopes.length;
        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, (int[] a, int[] b) -> {
            return a[0] == b[0] ?
                    b[1] - a[1] : a[0] - b[0];
        });

        // 对高度数组寻找 LIS
        int[] height = new int[n];
        for (int i = 0; i < n; i++)
            height[i] = envelopes[i][1];

        return lengthOfLIS(height);
    }

    /**
     * 动态规划 迭代解法
     * dp数组定义：dp[i] 表示以 nums[i] 这个数结尾的最长递增子序列的长度
     *
     * @param nums
     * @return
     */
    private int lengthOfLIS(int[] nums) {
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
