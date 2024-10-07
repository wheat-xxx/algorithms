package labuladong.dp;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 有 n 个城市通过一些航班连接。给你一个数组 flights ，
 * 其中 flights[i] = [fromi, toi, pricei] ，表示该航班都从城市 fromi 开始，以价格 pricei 抵达 toi。
 * 现在给定所有的城市和航班，以及出发城市 src 和目的地 dst，
 * 你的任务是找到出一条最多经过 k 站中转的路线，使得从 src 到 dst 的 价格最便宜 ，并返回该价格。 如果不存在这样的路线，则输出 -1。
 *
 * @author wheat
 * @date 2024/05/13  15:26
 */
public class Solution_787 {

    /**
     * 邻接表存储
     * from -> [to, price]
     */
    private List<int[]>[] graph;
    /**
     * 备忘录
     */
    private int[][] memo;

    /**
     * 动态规划 - 自顶向下 - 递归思路
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // 构建图
        graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int price = flight[2];
            graph[from].add(new int[] {to, price});
        }
        // 备忘录初始化
        // memo[i][j]：在j步之内，从i到dst最少需要多少钱
        memo = new int[n][k+2];
        for (int i = 0; i < n; i++) {
            Arrays.fill(memo[i], -666);
        }

        return dp(src, dst, k + 1);
    }

    /**
     * dp函数定义：从src出发，k步之内，到达节点dst的最小路径权重为dp(src, dst, k)
     * @return 如果到不了 返回-1
     */
    private int dp(int src, int dst, int k) {

        // base case
        if (src == dst) {
            return 0;
        }

        // 备忘录
        if (memo[src][k] != -666) {
            return memo[src][k];
        }

        // k步之内
        if (k == 0) {
            return -1;
        }

        int res = Integer.MAX_VALUE;
        for (int[] adj : graph[src]) {
            int subProblem = dp(adj[0], dst, k - 1);
            if (subProblem != -1) {
                res = Math.min(res, adj[1] + subProblem);
            }
        }

        res = res == Integer.MAX_VALUE ? -1 : res;
        // 备忘录
        memo[src][k] = res;
        return res;
    }

}
