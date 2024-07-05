package algorithms_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 m x n 二维字符网格 board 和一个单词（字符串）列表 words， 返回所有二维网格上的单词 。
 * 单词必须按照字母顺序，通过 相邻的单元格 内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 *
 * @author wheat
 * @date 2024/07/01  17:20
 */
public class Solution_212 {

    public List<String> findWords(char[][] board, String[] words) {

        int m = board.length;
        int n = board[0].length;

        List<String> res = new ArrayList<>();

        for (String word : words) {
            boolean flag = false;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    flag = dfs(board, i, j, word, 0, new boolean[m][n]);
                    if (flag) {
                        res.add(word);
                        break;
                    }
                }
                if (flag) break;
            }
        }

        return res;

    }

    // 方向数组
    private static final int[][] directions = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 深度优先遍历 - 有点像回溯算法
     * @param board
     * @param i
     * @param j
     * @param word
     * @param index
     * @param visited
     * @return
     */
    private boolean dfs(char[][] board, int i, int j, String word, int index, boolean[][] visited) {

        if (word.charAt(index) != board[i][j]) return false;

        if (index == word.length() - 1) return true;

        int m = board.length;
        int n = board[0].length;

        // 做选择
        visited[i][j] = true;
        for (int[] direction : directions) {
            int i_new = i + direction[0];
            int j_new = j + direction[1];
            if (i_new >= 0 && i_new < m && j_new >= 0 && j_new < n && !visited[i_new][j_new]) {
                boolean flag = dfs(board, i_new, j_new, word, index + 1, visited);
                if (flag) return true;
            }
        }
        // 撤销选择
        visited[i][j] = false;

        return false;
    }

}
