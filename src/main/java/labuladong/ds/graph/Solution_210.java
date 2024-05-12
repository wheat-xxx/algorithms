package labuladong.ds.graph;

import java.util.*;

/**
 * 现在你总共有 numCourses 门课需要选，记为 0 到 numCourses - 1。
 * 给你一个数组 prerequisites ，其中 prerequisites[i] = [ai, bi] ，表示在选修课程 ai 前 必须 先选修 bi 。
 * 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示：[0,1] 。
 *
 * 返回你为了学完所有课程所安排的学习顺序。可能会有多个正确的顺序，你只要返回 任意一种 就可以了。如果不可能完成所有课程，返回 一个空数组 。
 * @author wheat
 * @date 2024/04/18  16:26
 */
public class Solution_210 {

    // 记录遍历过的节点，防止走回头路
    private boolean[] visited;
    // 记录一次递归堆栈中的节点
    private boolean[] onPath;
    private boolean hasCycle = false;
    // 记录后序遍历结果
    private List<Integer> postorder = new ArrayList<>();

    /**
     * DFS解法
     * 将图的后序遍历的结果进行反转，就是拓扑排序的结果
     * 二叉树的后序遍历是什么时候？遍历完左右子树之后才会执行后序遍历位置的代码
     * 后序遍历的这一特点很重要，之所以拓扑排序的基础是后序遍历，是因为一个任务必须等到它依赖的所有任务都完成之后才能开始开始执行
     * @param numCourses
     * @param prerequisites
     * @return
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
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

        // 遍历图
        for (int i = 0; i < numCourses; i++) {
            traverse(graph, i);
        }

        // 有环图无法进行拓扑排序
        if (hasCycle) {
            return new int[]{};
        }

        // 逆后序遍历结果即为拓扑排序结果
        Collections.reverse(postorder);
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            res[i] = postorder.get(i);
        }
        return res;
    }

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
        // 前序遍历位置
        // 将节点 s 标记为已遍历
        visited[s] = true;

        // 开始遍历节点 s
        onPath[s] = true;
        for (Integer neighbor : graph.get(s)) {
            traverse(graph, neighbor);
        }
        // 后序遍历位置
        postorder.add(s);
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
    public int[] findOrder_2(int numCourses, int[][] prerequisites) {
        // 记录拓扑排序结果
        int[] res = new int[numCourses];
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
            // 弹出节点的顺序即为拓扑排序结果
            res[count] = cur;
            count++;
            for (int next : graph.get(cur)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    // 如果入度变为 0，说明 next 依赖的节点都已被遍历
                    queue.offer(next);
                }
            }
        }

        // 如果不是所有节点都被遍历过，说明成环
        if (count != numCourses) {
            // 存在环，拓扑排序不存在
            return new int[]{};
        }

        return res;
    }

}
