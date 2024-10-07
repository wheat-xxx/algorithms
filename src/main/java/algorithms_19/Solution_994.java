package algorithms_19;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一：
 *   值 0 代表空单元格；
 *   值 1 代表新鲜橘子；
 *   值 2 代表腐烂的橘子。
 * 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。
 * 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。
 *
 * @author wheat
 * @date 2024/05/21  22:55
 */
public class Solution_994 {

    /**
     * 方向数组
     */
    private int[][] direction = new int[][] {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

//    private boolean[][] visited;

    /**
     * BFS
     * @param grid
     * @return
     */
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

//        this.visited = new boolean[m][n];

        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int[] node = queue.poll();
//                visited[node[0]][node[1]] = true;
                for (int j = 0; j < 4; j++) {
                    if (node[0] + direction[j][0] >= 0 && node[0] + direction[j][0] < m
                    && node[1] + direction[j][1] >= 0 && node[1] + direction[j][1] < n
                    && grid[node[0] + direction[j][0]][node[1] + direction[j][1]] == 1) {
                        grid[node[0] + direction[j][0]][node[1] + direction[j][1]] = 2;
                        queue.offer(new int[]{node[0] + direction[j][0], node[1] + direction[j][1]});
                    }
                }
            }

            if (!queue.isEmpty()) {
                res++;
            }
        }

        boolean flag = true;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    flag = false;
                    break;
                }
                if (!flag) break;
            }
        }

        return flag ? res : -1;
    }


}
