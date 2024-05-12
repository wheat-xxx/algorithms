package algorithms_03;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;

/**
 * @author wheat
 * @date 2023/12/12  15:32
 */
public class Solution_174 {

    /**
     * 右下 -> 左上 dp[i][j]表示从坐标(i,j)到终点所需的最小初始值
     * dp[i][j]=max(min(dp[i+1][j],dp[i][j+1])−dungeon(i,j),1)
     */
    private int[][] dp;

    public int calculateMinimumHP(int[][] dungeon) {
        // 初始化动态规划矩阵
        int m = dungeon.length;
        int n = dungeon[0].length;
        this.dp = new int[m+1][n+1];
        for(int i = 0; i <= m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[m][n-1] = dp[m-1][n] = 1;
        for(int i = m - 1; i >= 0; i--) {
            for(int j = n - 1; j >= 0; j--) {
                int minVal = dp[i+1][j] < dp[i][j+1] ? dp[i+1][j] : dp[i][j+1];
                dp[i][j] = Math.max(minVal - dungeon[i][j], 1);
            }
        }

        return dp[0][0];
    }

    /**
     * 使用动态规划时，扩展动态规划数组可以统一处理边界问题
     * 类似一处理链表时，添加一个preHead，不需要对头节点进行单独处理
     * @param dungeon
     * @return
     */
    public int calculateMinimumHP_2(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];
        dp[m-1][n-1] = Math.max(1-dungeon[m-1][n-1], 1);

        for(int i = m - 2; i >= 0; i--) {
            dp[i][n-1] = Math.max(dp[i+1][n-1]-dungeon[i][n-1], 1);
        }
        for(int i = n - 2; i >= 0; i--) {
            dp[m-1][i] = Math.max(dp[m-1][i+1] - dungeon[m-1][i], 1);
        }
        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                int minTemp = Math.min(dp[i+1][j], dp[i][j+1]);
                dp[i][j] = Math.max(minTemp - dungeon[i][j], 1);
            }
        }
        return dp[0][0];
    }

    public static void main(String[] args) {
        String str = "[[-2,-3,3],[-5,-10,1],[10,30,-5]]";
        str = str.replaceAll("\\[","{");
        str = str.replaceAll("\\]", "}");
//        System.out.println(str);

        int[][] dungeon = {{-2,-3,3},{-5,-10,1},{10,30,-5}};
        new Solution_174().calculateMinimumHP(dungeon);
    }



}
