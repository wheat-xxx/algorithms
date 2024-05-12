package algorithms_03;

import java.util.Arrays;

/**
 * @author wheat
 * @date 2023/12/02  14:56
 */
public class Solution_152 {

    private int[] nums;
    private int[][] dp;

    /**
     * 使用矩阵存储中间结果
     * @param nums
     * @return
     */
    public int maxProduct(int[] nums) {
        this.nums = nums;
        this.dp = new int[nums.length][nums.length];
        int max = nums[0];

        for(int i = 0; i < nums.length; i++) {
            for(int j = i; j < nums.length; j++) {
                if(i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = dp[i][j - 1]*nums[j];
                }
                max = max > dp[i][j] ? max : dp[i][j];
            }
        }

        return max;
    }

    /**
     * 动态规划   转移方程  保存中间结果
     * @param nums
     * @return
     */
    public int maxProduct_2(int[] nums) {
        int length = nums.length;
        int[] maxF = Arrays.copyOf(nums, length);
        int[] minF = Arrays.copyOf(nums, length);

        for(int i = 1; i < length; i++) {
            maxF[i] = Math.max(maxF[i - 1]*nums[i], Math.max(minF[i - 1]*nums[i], nums[i]));
            minF[i] = Math.min(maxF[i - 1]*nums[i], Math.min(minF[i - 1]*nums[i], nums[i]));
        }

        int max = maxF[0];
        for(int val : maxF) {
            max = max >= val ? max : val;
        }
        return max;
    }

}
