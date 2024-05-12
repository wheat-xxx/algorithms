package labuladong.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *  graph[i] 是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点 graph[i][j]存在一条有向边）。
 * @author wheat
 * @date 2024/04/17  17:08
 */
public class Solution_797 {

    // 记录所有路径
    private List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        // 维护递归过程中经过的路径
        List<Integer> path = new ArrayList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int s, List<Integer> path) {
        // 添加节点s到路径
        path.add(s);

        int n = graph.length;
        if (s == n - 1) {
            // 到达终点
            res.add(new ArrayList<>(path));
            // 可以在这直接 return，但要 removeLast 正确维护 path
             path.remove(path.size() - 1);
             return;
            // 不 return 也可以，因为图中不包含环，不会出现无限递归
        }

        // 递归每个相邻节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }

        // 从路径移出节点 s
        path.remove(path.size() - 1);
    }

}
