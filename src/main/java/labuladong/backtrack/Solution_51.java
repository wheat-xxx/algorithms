package labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * N皇后问题
 * @author wheat
 * @date 2024/03/21  19:51
 */
public class Solution_51 {

    /**
     * 保存最终返回结果
     */
    private List<List<String>> res;

    /**
     * n是棋盘的维度
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<List<String>>();

        // 初始化棋盘
        List<char[]> board = setupBoard(n);

        backtrack(board, 0);

        return res;
    }

    /**
     * 初始化棋盘
     * @param n
     * @return
     */
    private List<char[]> setupBoard(int n) {
        List<char[]> board = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            char[] chs = new char[n];
            for (int j = 0; j < n; j++) {
                chs[j] = '.';
            }
            board.add(chs);
        }

        return board;
    }

    /**
     * 路径：board 中小于 row 的那些行都已经成功放置了皇后
     * 选择列表：第 row 行的所有列都是放置皇后的选择
     * 结束条件：row 超过 board 的最后一行
     * @param board
     * @param row
     */
    private void backtrack(List<char[]> board, int row) {
        // 结束条件
        if (row == board.size()) {
            List<String> list = new ArrayList<>();
            for (char[] chars : board) {
                list.add(String.copyValueOf(chars));
            }
            res.add(list);
            return;
        }

        // 用Q填充棋盘
        int n = board.get(0).length;
        for (int col = 0; col < n; col++) {
            // 排除不合法的选择
            if (!isValid(board, row, col)) {
                continue;
            }

            // 做选择
            board.get(row)[col] = 'Q';
            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            board.get(row)[col] = '.';
        }
    }

    /**
     * 判断当前位置插入皇后是否合法
     * 只需要判断 上 左上 右上
     * @param board
     * @param row
     * @param col
     * @return
     */
    private boolean isValid(List<char[]> board, int row, int col) {
        // 检查列是否有皇后互相冲突
        for (int i = row - 1; i >= 0; i--) {
            if (board.get(i)[col] == 'Q') return false;
        }
        // 检查左上方是否有皇后互相冲突
        int left = col - 1, up = row - 1;
        while (left >= 0 && up >= 0) {
            if (board.get(up--)[left--] == 'Q') return false;
        }
        // 检查右上方是否有皇后互相冲突
        int right = col + 1;
        up = row - 1;
        int n = board.get(0).length;
        while(right < n && up >= 0) {
            if (board.get(up--)[right++] == 'Q') return false;
        }

        return true;
    }

}
