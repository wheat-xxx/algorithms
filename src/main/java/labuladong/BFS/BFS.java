package labuladong.BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wheat
 * @date 2025/02/21  15:21
 */
public class BFS {

    private List<List<Integer>> graph;

    /**
     * 从 s 开始 BFS 遍历图的所有节点，且记录遍历的步数
     * 当走到目标节点 target 时，返回步数
     * @param s
     * @param target
     * @return
     */
    public int bfs(int s, int target) {
        // 防止存在环路
        boolean[] visited = new boolean[graph.size()];
        // 层序遍历 - Queue
        Queue<Integer> queue = new LinkedList<>();
        // 起始节点
        queue.offer(s);
        visited[s] = true;
        // 记录从 s 开始走到当前节点的步数
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                System.out.println("visit " + cur + " at step " + step);
                // 判断是否到达终点
                if (cur == target) {
                    return step;
                }
                // 将邻居节点加入队列，向四周扩散搜索
                for(int to : neighborsOf(cur)) {
                    if (!visited[to]) {
                        queue.offer(to);
                        visited[to] = true;
                    }
                }
            }

            step++;
        }

        // 不可达
        return -1;
    }

    /**
     * 获取某个节点的邻居节点
     * @param cur
     * @return
     */
    public List<Integer> neighborsOf(int cur) {
        return null;
    }

}
