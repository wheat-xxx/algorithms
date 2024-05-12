package labuladong.BFS;

import java.util.*;

/**
 * 在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示。一次 移动 定义为选择 0 与一个相邻的数字（上下左右）进行交换.
 * 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。
 * 给出一个谜板的初始状态 board ，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。
 *
 * 思路：0-5共有多少种排列方式？
 *      6！
 *      即板上共有6！种情况
 *      由于0的移动受限制，所有不一定所有排列都可以移动到（123450）
 * 由于是求最短距离，可以使用BFS算法解决
 *
 * @author wheat
 * @date 2024/04/25  11:20
 */
public class Solution_773 {

    /**
     * BFS算法
     * @param board
     * @return
     */
    public int slidingPuzzle(int[][] board) {
        // 将 2x3 的数组转化成字符串作为 BFS 的起点
        String start = boardToStr(board);
        // 终点
        String target = "123450";
        // 防止重复遍历
        Set<String> visited = new HashSet<>();
        // BFS遍历 - 队列
        Queue<String> queue = new LinkedList<>();

        // 记录一维字符串的相邻索引
//        int[][] neighbor = new int[][]{
//                {1, 3},
//                {0, 4, 2},
//                {1, 5},
//                {0, 4},
//                {3, 1, 5},
//                {4, 2}
//        };
        int[][] neighbor = generateNeighborMapping(board.length, board[0].length);

        /******* BFS 算法框架开始 *******/
        // 从起点开始 BFS 搜索
        queue.offer(start);
        visited.add(start);
        int step = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            for (int i = 0; i < sz; i++) {
                String cur = queue.poll();
                // 判断是否到达目标局面
                if (cur.equals(target)) {
                    return step;
                }
                // 找到数字 0 的索引
                int index_0 = 0;
                for (; cur.charAt(index_0) != '0'; index_0++);
                // 将数字 0 和相邻的数字交换位置
                for (int adj : neighbor[index_0]) {
                    String new_board = swap(cur.toCharArray(), index_0, adj);
                    // 防止走回头路
                    if (!visited.contains(new_board)) {
                        queue.add(new_board);
                        visited.add(new_board);
                    }
                }
            }
            step++;
        }
        /******* BFS 算法框架结束 *******/
        return -1;
    }

    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

    private String boardToStr(int[][] board) {
        StringBuilder sb = new StringBuilder();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sb.append(board[i][j]);
            }
        }
        return sb.toString();
    }

    /**
     * 对于一个 m x n 的二维数组，转为一维数组之后，生成一维索引映射
     * @param m
     * @param n
     * @return
     */
    private int[][] generateNeighborMapping(int m, int n) {
        int[][] neighbor = new int[m * n][];
        for (int i = 0; i < m * n; i++) {
            List<Integer> neighbors = new ArrayList<Integer>();

            // 如果不是第一列，有左侧邻居
            if (i % n != 0) neighbors.add(i - 1);
            // 如果不是最后一列，有右侧邻居
            if (i % n != n - 1) neighbors.add(i + 1);
            // 如果不是第一行，有上方邻居
            if (i / n != 0) neighbors.add(i - n);
            // 如果不是最后一行，有下方邻居
            if (i / n != m - 1) neighbors.add(i + n);

            neighbor[i] = neighbors.stream().mapToInt(Integer::intValue).toArray();
        }
        return neighbor;
    }

}
