package labuladong.dp;

/**
 * 预测赢家
 *
 * 如何判断dp问题：首先问问自己该问题是否具有最优子结构？
 * 此题：√
 *
 * 博弈问题的前提一般都是在两个聪明人之间进行，编程描述这种游戏的一般方法是二维 dp 数组，数组中通过元组分别表示两人的最优决策
 * 先手在做出选择之后，就成了后手，后手在对方做完选择后，就变成了先手
 * @author wheat
 * @date 2024/05/16  17:32
 */
public class Solution_486 {

    /**
     * 动态规划问题 - 迭代解法
     * @param nums
     * @return
     */
    public boolean predictTheWinner(int[] nums) {
        return stoneGame(nums) >= 0;
    }

    /**
     * 先手和后手的角色一直在切换
     * @param piles
     * @return
     */
    private int stoneGame(int[] piles) {
        int n = piles.length;
        // 初始化dp数组
        int[][][] dp = new int[n][n][2];
        for (int i = 0; i < n; i++) {
            dp[i][i][0] = piles[i];
            dp[i][i][1] = 0;
        }

        // 迭代填充dp数组 [i...j]
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                // 先手选择最左边或最右边的分数
                int left = piles[i] + dp[i + 1][j][1];
                int right = piles[j] + dp[i][j - 1][1];
                // 状态转移方程
                // 先手肯定会选择更大的结果，后手的选择随之改变
                if (left > right) {
                    dp[i][j][0] = left;
                    dp[i][j][1] = dp[i + 1][j][0];
                } else {
                    dp[i][j][0] = right;
                    dp[i][j][1] = dp[i][j - 1][0];
                }
            }
        }

        return dp[0][n - 1][0] - dp[0][n - 1][1];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划问题 - 递归解法
     * @param nums
     * @return
     */
    public boolean predictTheWinner_2(int[] nums) {
        memo = new int[nums.length][nums.length][];
        int[] res = dp(nums, 0, nums.length - 1);
        return res[0] - res[1] >= 0;
    }

    /**
     * 备忘录
     */
    private int[][][] memo;

    /**
     * dp函数定义：dp(nums, i, j)[0]先手的最大分数 dp(nums, i, j)[1]后手的最大分数
     * [i,j]
     * @param nums
     * @param i 左边界
     * @param j 右边界
     * @return
     */
    private int[] dp(int[] nums, int i, int j) {
        int[] res = new int[2];
        // base case
        if (i == j) {
            return new int[] {nums[i], 0};
        }

        if (memo[i][j] != null) return memo[i][j];

        // 先手选择最左边或最右边的分数
        int left = nums[i] + dp(nums, i + 1, j)[1];
        int right = nums[j] + dp(nums, i, j - 1)[1];
        if (left > right) {
            res[0] = left;
            res[1] = dp(nums, i + 1, j)[0];
        } else {
            res[0] = right;
            res[1] = dp(nums, i, j - 1)[0];
        }

        memo[i][j] = res;

        return res;
    }

}
