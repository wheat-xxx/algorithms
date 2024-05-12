package labuladong.dp;

/**
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 *
 * 暴力解法 - 穷举 2^n
 * @author wheat
 * @date 2024/04/24  8:33
 */
public class Solution_416 {

    /**
     * 暴力解法
     * 超出时间限制
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false;

        return dp(nums, nums.length - 1, sum / 2);
    }

    /**
     * target = 总和的一半
     * dp函数定义：nums[0...index]是否可以凑齐target
     *
     * 暴力解法 - 穷举所有解
     * @param nums
     * @param index
     * @param target
     * @return
     */
    private boolean dp(int[] nums, int index, int target) {
        // base case
        if (index == -1 && target != 0) {
            return false;
        }
        if (target == 0) {
            return true;
        }
        if (target < 0) {
            return false;
        }

        // 两种选择
        // 加入set1
        boolean state1 = dp(nums, index - 1, target - nums[index]);
        // 不加入set1
        boolean state2 = dp(nums, index - 1, target);

        return state1 || state2;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划 - 转为背包问题
     * @param nums
     * @return
     */
    public boolean canPartition_2(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        // dp数组的定义：
        // 初始化
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        // base case
//        dp[0][0] = true;
        for (int i = 0; i <= nums.length; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= nums.length; i++) {
            for (int val = 1; val <= target; val++) {
                if (val - nums[i - 1] < 0) {
                    // 背包容量不足，不能装入第 i 个物品
                    dp[i][val] = dp[i - 1][val];
                    continue;
                }
                // 装入或不装入背包
                dp[i][val] = dp[i - 1][val] || dp[i - 1][val - nums[i - 1]];
            }
        }

        return dp[nums.length][target];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * dp数组优化 - 空间优化
     * dp[i][val] 都是通过上一行 dp[i-1][..] 转移过来的
     * @param nums
     * @return
     */
    public boolean canPartition_3(int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }

        if (sum % 2 != 0) return false;
        int target = sum / 2;

        // dp数组的定义：
        // 初始化
        boolean[] dp = new boolean[target + 1];
        // base case
        dp[0] = true;

        for (int i = 0; i < nums.length; i++) {
            for (int val = target; val >= 1; val--) {
                if (val - nums[i] >= 0) {
                    dp[val] = dp[val] || dp[val - nums[i]];
                }
            }
        }

        return dp[target];
    }

}
