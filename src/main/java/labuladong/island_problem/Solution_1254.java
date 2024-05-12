package labuladong.island_problem;

/**
 * 统计封闭岛屿的数量
 * @author wheat
 * @date 2024/04/24  20:54
 */
public class Solution_1254 {

    /**
     *
     * @param grid
     * @return
     */
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        // 先遍历边界
        // 上下
        for (int j = 0; j < n; j++) {
            if (!visited[0][j]) {
                dfs(grid, 0, j, visited);
            }
            if (!visited[m - 1][j]) {
                dfs(grid, m - 1, j, visited);
            }
        }
        // 左右
        for (int i = 1; i < m - 1; i++) {
            if (!visited[i][0]) {
                dfs(grid, i, 0, visited);
            }
            if (!visited[i][n - 1]) {
                dfs(grid, i, n - 1, visited);
            }
        }

        // 遍历封闭的岛
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
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
    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        // 超出索引边界
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        // 如果是水 直接返回
        if (grid[i][j] == 1) {
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

}
