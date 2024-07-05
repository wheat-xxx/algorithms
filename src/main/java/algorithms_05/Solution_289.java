package algorithms_05;

import java.util.Arrays;

/**
 * 生命游戏
 *
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态： 1 即为 活细胞 （live），或 0 即为 死细胞 （dead）。
 * 每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 *      如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 *      如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 *      如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 *      如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。给你 m x n 网格面板 board 的当前状态，返回下一个状态。
 *
 * @author wheat
 * @date 2024/06/09  15:58
 */
public class Solution_289 {

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        int[][] board_new = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int[] environment = getEnvironment(board, i, j);
                if (board[i][j] == 1) {
                    if (environment[1] < 2) {
                        board_new[i][j] = 0;
                    } else if (environment[1] > 3) {
                        board_new[i][j] = 0;
                    } else {
                        board_new[i][j] = 1;
                    }
                } else if (board[i][j] == 0) {
                    if (environment[1] == 3) {
                        board_new[i][j] = 1;
                    } else {
                        board_new[i][j] = 0;
                    }
                }
            }
        }

        for (int i = 0; i < m; i++) {
            board[i] = board_new[i];
        }
    }

    private int[][] directions = {{-1, -1}, {-1, 0}, {-1, 1},
            {0, -1}, {0, 1},
            {1, -1}, {1, 0}, {1, 1}};

    private int[] getEnvironment(int[][] board, int i, int j) {
        int m = board.length;
        int n = board[0].length;
        int[] environment = new int[2];
        for (int[] direction : directions) {
            int i_new = i + direction[0];
            int j_new = j + direction[1];
            if (i_new >= 0 && i_new < m && j_new >= 0 && j_new < n) {
                if (board[i_new][j_new] == 0) {
                    environment[0] += 1;
                } else {
                    environment[1] += 1;
                }
            }
        }
        return environment;
    }

}
