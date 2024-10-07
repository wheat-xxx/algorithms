package labuladong.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wheat
 * @date 2024/09/23  21:51
 */
public class Solution_787_dfs {

    private Graph graph;
    // 返回结果
    private int res = Integer.MAX_VALUE;
    // 路径
    private int track = 0;
    //  记录在一次dfs中是否遍历过
    private boolean[] visited;

    /**
     * 构建图结构
     * dfs遍历 - 遍历思路
     *
     * @param n
     * @param flights
     * @param src
     * @param dst
     * @param k
     * @return
     */
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        buildGraph(n, flights);
        this.visited = new boolean[n];
        dfs(src, dst, k);
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    /**
     * 构建图结构
     *
     * @param n
     * @param flights
     */
    private void buildGraph(int n, int[][] flights) {
        this.graph = new Graph(n);
        for (int[] flight : flights) {
            int from = flight[0];
            int to = flight[1];
            int weight = flight[2];
            graph.adjList[from].add(new int[]{to, weight});
        }
    }

    private void dfs(int src, int dst, int k) {

        // base case
        if (visited[src]) return;

        // 到达终点
        if (src == dst) {
            res = Math.min(res, track);
            return;
        }

        // 达到最多跳数
        if (k == -1) {
            return;
        }

        // 对节点的遍历
        visited[src] = true;
        for (int[] adj : graph.adjList[src]) {
            // 对边的遍历
            track += adj[1];
            // 进入下一层递归
            dfs(adj[0], dst, k - 1);
            track -= adj[1];
        }
        visited[src] = false;
    }

    /**
     * 图结构
     */
    private class Graph {
        /**
         * 邻接表 {to, weight}
         */
        List<int[]>[] adjList;

        Graph(int n) {
            adjList = new List[n];
            for (int i = 0; i < n; i++) {
                adjList[i] = new ArrayList<int[]>();
            }
        }
    }

}
