package labuladong.ds.graph;

/**
 * 图的遍历
 *
 * 各种数据结构被发明出来无非就是为了遍历和访问，所以「遍历」是所有数据结构的基础
 *
 * 图和多叉树最大的区别是，图是可能包含环的，你从图的某一个节点开始遍历，有可能走了一圈又回到这个节点
 * 如果图包含环，遍历框架就要一个 visited 数组进行辅助
 *
 * 适用于树的 DFS/BFS 遍历算法，全部适用于图
 * DFS-递归遍历
 * BFS-层序遍历
 *
 * 类比贪吃蛇游戏，visited 记录蛇经过过的格子，而 onPath 仅仅记录蛇身。在图的遍历过程中，onPath 用于判断是否成环，类比当贪吃蛇自己咬到自己（成环）的场景
 * 如果处理路径相关的问题，这个 onPath 变量是肯定会被用到的
 *
 * @author wheat
 * @date 2024/04/17  16:39
 */
public class TraverseGraph {

//    // 记录被遍历过的节点
//    boolean[] visited;
//    // 记录从起点到当前节点的路径
//    boolean[] onPath;
//
//    /* 图遍历框架 */
//    void traverse(Graph graph, int s) {
//        if (visited[s]) return;
//        // 经过节点 s，标记为已遍历
//        visited[s] = true;
//        // 做选择：标记节点 s 在路径上
//        onPath[s] = true;
//        for (int neighbor : graph.neighbors(s)) {
//            traverse(graph, neighbor);
//        }
//        // 撤销选择：节点 s 离开路径
//        onPath[s] = false;
//    }

}
