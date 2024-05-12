package labuladong.ds.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，
 * 其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 *
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 * @author wheat
 * @date 2024/04/18  11:00
 */
public class Solution_207 {

    /**
     * 问题分析：如果存在环，则不能完成，转换成图中是否存在环的问题
     * DFS解决
     * 虽然做对了 但思路不是很清晰
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 先将prerequisites转换成图
        // 邻接表存储
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 遍历prerequisites，构造图
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // 记录已经访问过的节点
        boolean[] visited = new boolean[numCourses];
        // 路径
        boolean[] path = new boolean[numCourses];
        // 对图进行遍历判断是否存在环
        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                // 从i开始是否存在环
                boolean res = traverse(graph, visited, path, i);
                if (res) return !res;
            }
        }
        return true;
    }

    /**
     * 在一次遍历中，如果遇到相同的起点说明存在环
     * @param graph
     * @param visited
     * @param path
     * @param s
     * @return true-环
     */
    private boolean traverse(List<List<Integer>> graph, boolean[] visited, boolean[] path, int s) {
        // 如果visited访问过说明什么？如果path访问过说明什么？
        // visited有两种情况，一个是上一次遍历访问过，一个是这次遍历访问过
        // path说明这次遍历访问过
        // 如果是上次遍历访问过则可以跳过
        if (!path[s] && visited[s]) {
            return false;
        }
        visited[s] = true;
        // 如果这次遍历访问过 说明存在环
        if (path[s]) {
            return true;
        }
        path[s] = true;
        for (Integer neighbor : graph.get(s)) {
            boolean res = traverse(graph, visited, path, neighbor);
            if (res) return true;
        }
        path[s] = false;
        return false;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * labuladong
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish_2(int numCourses, int[][] prerequisites) {
        // 先将prerequisites转换成图
        // 邻接表存储
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 遍历prerequisites，构造图
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        this.visited = new boolean[numCourses];
        this.onPath = new boolean[numCourses];

        // 判断图中是否存在环
        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(graph, i);
        }
        return !hasCycle;
    }

    // 记录遍历过的节点，防止走回头路
    private boolean[] visited;
    // 记录一次递归堆栈中的节点
    private boolean[] onPath;
    private boolean hasCycle = false;

    /**
     * 图的dfs遍历
     * 每个节点只能被遍历一次 要不然会超时
     * @param graph
     * @param s
     */
    private void traverse(List<List<Integer>> graph, int s) {
        if (hasCycle) return;
        // 发现环！！！
        if (onPath[s]) {
            hasCycle = true;
            return;
        }

        // 每个节点只能被遍历一次 要不然会超时
        if (visited[s]) return;
        // 将节点 s 标记为已遍历
        visited[s] = true;

        // 开始遍历节点 s
        onPath[s] = true;
        for (Integer neighbor : graph.get(s)) {
            traverse(graph, neighbor);
        }
        // 节点 s 遍历完成
        onPath[s] = false;

    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * BFS实现
     * 借助队列
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public boolean canFinish_3(int numCourses, int[][] prerequisites) {
        // 先将prerequisites转换成图
        // 邻接表存储
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }
        // 遍历prerequisites，构造图
        for (int i = 0; i < prerequisites.length; i++) {
            graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }

        // 构建入度数组
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int from = edge[1], to = edge[0];
            // 节点to的入度+1
            indegree[to]++;
        }

        // 根据入度初始化队列中的节点
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                // 节点 i 没有入度，即没有依赖的节点
                // 可以作为拓扑排序的起点，加入队列
                queue.offer(i);

            }
        }

        // 记录遍历的节点个数
        int count = 0;
        // 开始执行 BFS 循环
        while (!queue.isEmpty()) {
            // 弹出节点 cur，并将它指向的节点的入度减一
            int cur = queue.poll();
            count++;
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                    queue.offer(next);
                }
            }
        }

        // 如果所有节点都被遍历过，说明不成环
        return count == numCourses;
    }

}
