package labuladong.island_problem;

/**
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * 此外，你可以假设该网格的四条边均被水包围。
 *
 * @author wheat
 * @date 2024/04/24  20:34
 */
public class Solution_200 {

    /**
     * dfs遍历二维数组
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    // 一次dfs相当于遍历一个岛
                    dfs(grid, i, j, visited);
                    res++;
                }
            }
        }

        return res;
    }

    /**
     * dfs算法框架
     * @param grid
     * @param i
     * @param j
     * @param visited
     */
    private void dfs(char[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        // 超出索引边界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        // 如果是水 直接返回
        if (grid[i][j] == '0') {
            return;
        }
        // 已遍历过 (i, j)
        if (visited[i][j]) {
            return;
        }

        // 进入节点 (i, j)
        visited[i][j] = true;
        dfs(grid, i - 1, j, visited);   // 上
        dfs(grid, i + 1, j, visited);   // 下
        dfs(grid, i, j - 1, visited);   // 左
        dfs(grid, i, j + 1, visited);   // 右
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * bfs解法 - Queue
     * @param grid
     * @return
     */
    public int numIslands_2(char[][] grid) {
        return -1;
    }

}
