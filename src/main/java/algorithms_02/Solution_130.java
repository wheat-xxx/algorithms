package algorithms_02;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wheat
 * @date 2023/10/16  15:00
 */
public class Solution_130 {

    private int rowCount;
    private int colCount;

    int[] dx = {0, 0, -1, 1};
    int[] dy = {-1, 1, 0, 0};

    /**
     * 深度优先遍历
     * @param board
     */
    public void solve_1(char[][] board) {
        if(board == null || board.length < 3) return;

        this.rowCount = board.length;
        this.colCount = board[0].length;

        for(int x = 0; x < this.colCount; x++) {
            dfs(board, x, 0);
            dfs(board, x, rowCount - 1);
        }

        for(int y = 1; y < this.rowCount - 1; y++) {
            dfs(board, 0, y);
            dfs(board, this.colCount - 1, y);
        }

        for(int i =  0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }
    }

    /**
     * 广度优先搜索遍历
     * @param board
     */
    public void solve_2(char[][] board) {
        if(board == null || board.length < 3) return;

        Queue<int[]> queue = new LinkedList<>();

        this.rowCount = board.length;
        this.colCount = board[0].length;

        for(int x = 0; x < this.colCount; x++) {
            if(board[0][x] == 'O'){
                queue.add(new int[]{x, 0});
                board[0][x] = 'T';
            }
            if(board[this.rowCount - 1][x] == 'O'){
                queue.add(new int[]{x, this.rowCount - 1});
                board[this.rowCount - 1][x] = 'T';
            }
        }

        for(int y = 1; y < this.rowCount - 1; y++) {
            if(board[y][0] == 'O') {
                queue.add(new int[]{0, y});
                board[y][0] = 'T';
            }
            if(board[y][this.colCount - 1] == 'O') {
                queue.add(new int[]{this.colCount - 1, y});
                board[y][this.colCount - 1] = 'T';
            }
        }

        while(!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0], y = cell[1];
            for(int index = 0; index < 4; index++) {
                if(x + dx[index] >= 0 && x + dx[index] < this.colCount &&
                        y + dy[index] >= 0 && y + dy[index] < this.rowCount && board[y + dy[index]][x + dx[index]] == 'O'){
                    queue.add(new int[]{x + dx[index], y + dy[index]});
                    board[y + dy[index]][x + dx[index]] = 'T';
                }
            }
        }

        for(int i =  0; i < rowCount; i++) {
            for(int j = 0; j < colCount; j++) {
                if(board[i][j] == 'O') board[i][j] = 'X';
                if(board[i][j] == 'T') board[i][j] = 'O';
            }
        }

    }

    public void dfs(char[][] board, int x, int y){
        if(x < 0 || x >= colCount || y < 0 || y >= rowCount || board[y][x] == 'X' || board[y][x] == 'T') return;
        board[y][x] = 'T';
        dfs(board, x, y - 1);
        dfs(board, x, y + 1);
        dfs(board, x - 1, y);
        dfs(board, x + 1, y);
    }

    @Test
    public void testSolve_2() {
        char[][] board = {{'O','O','O','O','X','X'},{'O','O','O','O','O','O'},{'O','X','O','X','O','O'},
                {'O','X','O','O','X','O'},{'O','X','O','X','O','O'},{'O','X','O','O','O','O'}};
        this.solve_2(board);
    }


}
