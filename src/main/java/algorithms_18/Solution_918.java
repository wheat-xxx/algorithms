package algorithms_18;

/**
 * 给定一个长度为 n 的环形整数数组 nums ，返回 nums 的非空 子数组 的最大可能和 。
 * 环形数组 意味着数组的末端将会与开头相连呈环状。形式上， nums[i] 的下一个元素是 nums[(i + 1) % n] ， nums[i] 的前一个元素是 nums[(i - 1 + n) % n] 。
 * 子数组 最多只能包含固定缓冲区 nums 中的每个元素一次。
 * 形式上，对于子数组 nums[i], nums[i + 1], ..., nums[j] ，不存在 i <= k1, k2 <= j 其中 k1 % n == k2 % n 。
 *
 * @author wheat
 * @date 2024/06/24  22:20
 */
public class Solution_918 {

    /**
     * 动态规划
     * 正确 - 超出内存限制
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular(int[] nums) {

        int n = nums.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][(i + j) % n] = dp[i][(i + j - 1) % n] + nums[(i + j) % n];
            }
        }

        int res_max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res_max = Math.max(res_max, dp[i][j]);
            }
        }

        return res_max;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划 - 降低空间复杂度
     * @param nums
     * @return
     */
    public int maxSubarraySumCircular_2(int[] nums) {

        int n = nums.length;
        // 后缀数组的最大和 [0:i] 以0为起点 以0-i中的某一个点作为终点
        int[] leftMax = new int[n];
        leftMax[0] = nums[0];

        int res = nums[0];
        int preMax = nums[0];
        int leftSum = nums[0];
        for (int i = 1; i < n; i++) {
            // 子数组[i:j] i <= j 最大值更新
            preMax = Math.max(preMax + nums[i], nums[i]);
            res = Math.max(res, preMax);
            // 后缀数组最大和
            leftSum += nums[i];
            leftMax[i] = Math.max(leftMax[i - 1], leftSum);
        }

        // 相当于固定前缀数组的起点
        int rightSum = 0;
        for (int i = n - 1; i > 0; i--) {
            rightSum += nums[i];
            res = Math.max(res, rightSum + leftMax[i - 1]);
        }

        return res;
    }

}
