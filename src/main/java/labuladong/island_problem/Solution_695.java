package labuladong.island_problem;

/**
 * 给你一个大小为 m x n 的二进制矩阵 grid 。
 * 岛屿 是由一些相邻的 1 (代表土地) 构成的组合，这里的「相邻」要求两个 1 必须在 水平或者竖直的四个方向上 相邻。你可以假设 grid 的四个边缘都被 0（代表水）包围着。
 * 岛屿的面积是岛上值为 1 的单元格的数目。
 * 计算并返回 grid 中最大的岛屿面积。如果没有岛屿，则返回面积为 0 。
 *
 * @author wheat
 * @date 2024/04/24  21:23
 */
public class Solution_695 {

    /**
     * 二维数组的遍历
     * @param grid
     * @return
     */
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    this.count = 0;
                    dfs(grid, i, j, visited);
                    res = Math.max(res, this.count);
                }
            }
        }

        return res;
    }

    /**
     * 方向数组
     */
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    /**
     * dfs遍历框架的辅助数组
     */
    private int count = 0;

    /**
     * dfs算法框架
     * @param grid
     * @param i
     * @param j
     * @param visited
     */
    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length, n = grid[0].length;
        // 边界情况
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return;
        }
        // 水
        if (grid[i][j] == 0) {
            return;
        }
        // 已访问过
        if (visited[i][j]) {
            return;
        }

        // 访问（i,j）
        visited[i][j] = true;
        // 统计一次dfs遍历的面积
        count++;
        // 访问上下左右
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1], visited);
        }
    }

}
