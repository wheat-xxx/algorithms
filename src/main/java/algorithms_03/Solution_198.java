package algorithms_03;

/**
 * 动态规划问题总结：
 *  1. 定义子问题：问题可以由递推关系进行表示
 *  2. 递推关系：初始条件
 *  3. 确定DP数组的计算顺序
 *  4. 空间优化
 * @author wheat
 * @date 2023/12/18  14:28
 */
public class Solution_198 {

    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];

        // 动态规划
        int[] dp = new int[nums.length];
        boolean flag = nums[1] > nums[0];     // 标记子问题最后一个房子是否被偷
        dp[0] = nums[0];
        dp[1] = flag ? nums[1] : nums[0];
        for(int i = 2; i < nums.length; i++) {
            if(flag) {
                flag = dp[i - 1] < dp[i - 2] + nums[i];
                dp[i] = flag ? dp[i - 2] + nums[i] : dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + nums[i];
                flag = true;
            }
        }

        return dp[nums.length - 1];
    }

}
