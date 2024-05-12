package labuladong.BFS;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * @author wheat
 * @date 2024/03/24  20:59
 */
public class Solution_111 {

    /**
     * BFS 找最短路径
     * @param root
     * @return
     */
    public int minDepth(TreeNode root) {

        if (root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        int res = 0;
        while(!queue.isEmpty()) {
            int size = queue.size();
            // 记录层数
            res++;
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                /* 判断是否到达终点 */
                if(node.left == null && node.right == null) {
                    return res;
                }
                /* 将 cur 的相邻节点加入队列 */
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }
        return res;
    }

}
