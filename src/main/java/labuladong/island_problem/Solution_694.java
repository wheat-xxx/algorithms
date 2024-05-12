package labuladong.island_problem;

import java.util.HashSet;

/**
 * 不同岛屿的数量
 * 对于形状相同的岛屿，如果从同一起点出发，dfs 函数遍历的顺序肯定是一样的
 * @author wheat
 * @date 2024/04/24  22:32
 */
public class Solution_694 {

    public int numDistinctIslands(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 记录所有岛屿的序列化结果
        HashSet<String> islands = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    // 淹掉这个岛屿，同时存储岛屿的序列化结果
                    StringBuilder sb = new StringBuilder();
                    // 初始的方向可以随便写，不影响正确性
                    dfs(grid, i, j, sb, 666);
                    islands.add(sb.toString());

                }
            }
        }
        // 不相同的岛屿数量
        return islands.size();
    }

    /**
     * 方向数组
     */
    private int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 二维矩阵的dfs遍历
     * @param grid
     * @param i
     * @param j
     * @param sb
     */
    private void dfs(int[][] grid, int i, int j, StringBuilder sb, int dir) {
        int m = grid.length, n = grid[0].length;
        if (i < 0 || j < 0 || i >= m || j >= n
                || grid[i][j] == 0) {
            return;
        }

        // 前序遍历位置：进入 (i, j)
        grid[i][j] = 0;
        sb.append(dir).append(",");

        int dir_temp = 0;   // 1-上 2-下 3-左 4-右
        for (int[] direction : directions) {
            dfs(grid, i + direction[0], j + direction[1], sb, ++dir_temp);
        }

        // 后序遍历位置
        sb.append(-dir).append(",");
    }

}
