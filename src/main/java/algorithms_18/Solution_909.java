package algorithms_18;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 *
 * 蛇梯棋
 * 编号如何与ij形成映射
 *
 * @author wheat
 * @date 2024/07/04  11:11
 */
public class Solution_909 {

    /**
     * 广度优先搜索 队列
     * @param board
     * @return
     */
    public int snakesAndLadders(int[][] board) {
        int m = board.length;
        int n = board[0].length;

        boolean[] visited = new boolean[m * n];

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6 && cur[0] + i <= m * n - 1; i++) {
                int next = cur[0] + i;
                int[] loc = calculateNext(board, next);
                if (board[loc[0]][loc[1]] != -1) {  // 蛇或梯子
                    next = board[loc[0]][loc[1]] - 1;
                }

                // 抵达终点
                if (next == m * n - 1) {
                    return cur[1] + 1;
                }

                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cur[1] + 1});
                }
            }
        }

        return -1;
    }

    /**
     * 通过编号计算位置
     * test √
     * @param board
     * @param num 0...n
     * @return
     */
    private int[] calculateNext(int[][] board, int num) { // 0...n
        int m = board.length;
        int n = board[0].length;

        int i = m - num / n - 1;
        int j;
        if ((m - 1 - i) % 2 == 0) {
            j = num % n;
        } else {
            j = n - 1 - num % n;
        }

        return new int[]{i, j};
    }

}
