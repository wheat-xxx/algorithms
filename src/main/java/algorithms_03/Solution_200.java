package algorithms_03;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ForkJoinPool;

/**
 * @author wheat
 * @date 2023/12/18  16:39
 */
public class Solution_200 {

    private char[][] grid;
    private int m;
    private int n;

    /**
     * 对网格进行遍历，如果发现某个点属于某个岛屿，则通过该点对岛屿进行遍历，并对遍历过的岛屿进行标记
     * 遍历过的岛屿使用x进行标记
     * @param grid
     * @return
     */
    public int numIslands(char[][] grid) {

        int count = 0;

        this.grid = grid;
        m = grid.length;
        n = grid[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(grid[i][j] == '0' || grid[i][j] == 'x') continue;
                else {
                    count++;
                    grid[i][j] = 'x';
                    // 广度优先搜索遍历
                    bfs(i, j);
                }
            }
        }

        return count;
    }

    private void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        // 使用数组表示上下左右
        int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            for (int k = 0; k < 4; k++) {
                i = node[0] + direction[k][0];
                j = node[1] + direction[k][1];
                if(i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == '1') {
                    grid[i][j] = 'x';
                    queue.add(new int[]{i, j});
                }
            }
        }
    }

}
