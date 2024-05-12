package labuladong.backtrack;

/**
 * 编写一个程序，通过填充空格来解决数独问题。
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 *
 * @author wheat
 * @date 2024/04/25  8:25
 */
public class Solution_37 {

    public void solveSudoku(char[][] board) {
        backtrack(board, 0, 0);
    }

    /**
     * 回溯算法框架
     * @param board
     * @param i
     * @param j
     * @return
     */
    private boolean backtrack(char[][] board, int i, int j) {
        // 使i j数字合法
        // 穷举到最后一列的话就换到下一行重新开始。
        if (j == 9) {
            i += 1;
            j = 0;
        }
        // 找到一个可行解，触发 base case
        if (i == 9) {
            return true;
        }

        // 如果有预设数字，不用我们穷举
        if (board[i][j] != '.') {
            return backtrack(board, i, j + 1);
        }

        // 回溯算法框架
        for (char ch = '1'; ch <= '9'; ch++) {
            // 如果遇到不合法数字跳过
            if (!isValid(board, i, j, ch)) {
                continue;
            }
            // 做选择
            board[i][j] = ch;
            // 进入下一层回溯
            boolean subProblem = backtrack(board, i, j + 1);
            if (subProblem) return true;
            // 撤销选择
            board[i][j] = '.';
        }
        // 穷举完 1~9，依然没有找到可行解，此路不通
        return false;
    }

    /**
     * // 判断 board[i][j] 是否可以填入 ch
     * @param board
     * @param i
     * @param j
     * @param ch
     * @return
     */
    private boolean isValid(char[][] board, int i, int j, char ch) {
        for (int k = 0; k < 9; k++) {
            // 判断行是否存在重复
            if (board[i][k] == ch) return false;
            // 判断列是否存在重复
            if (board[k][j] == ch) return false;
            // 判断 3 x 3 方框是否存在重复
            if (board[i / 3 * 3 + k / 3][j / 3 * 3 + k % 3] == ch) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(4 / 3 * 3);
    }

}
