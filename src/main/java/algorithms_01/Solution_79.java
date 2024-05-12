package algorithms_01;

import org.junit.Test;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/13  20:27
 */
public class Solution_79 {

    // row col
    private final int[][] DIRECTIONS = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private boolean[][] used;
    private char[][] board;
    private char[] word;



    public boolean exist(char[][] board, String word) {

        this.board = board;
        this.word = word.toCharArray();
        this.used = new boolean[board.length][board[0].length];

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(dfs(i, j, 1)) return true;
            }
        }
        return false;
    }

    private boolean dfs(int row, int col, int len){

        if(len == this.word.length) return this.word[len - 1] == board[row][col];

        if(this.word[len - 1] == this.board[row][col]){
            this.used[row][col] = true;
            for(int[] direction : DIRECTIONS){
                int newRow = row + direction[0];
                int newCol = col + direction[1];
                if(check(newRow, newCol) && !used[newRow][newCol]){
                    if(dfs(newRow, newCol, len + 1)) return true;
                }
            }
            this.used[row][col] = false;
        }

        return false;

    }

    private boolean check(int row, int col){
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }

    @Test
    public void test(){
        char[][] board = {
                {'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}
        };

        String word = "ABCCED";

        exist(board, word);
    }

}
