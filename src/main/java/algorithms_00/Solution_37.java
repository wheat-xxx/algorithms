package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/28  17:56
 */
public class Solution_37 {

    // 保存递归过程中的全部变量
    private boolean[][] rows = new boolean[9][10];
    private boolean[][] cols = new boolean[9][10];
    private boolean[][][] cells = new boolean[3][3][10];


    public void solveSudoku(char[][] board) {

        // 初始化递归过程需要的全局变量
        for(int row = 0; row < board.length; row++){
            for(int col = 0; col < board[row].length; col++){
                if(board[row][col] != '.'){     // 未赋值==false
                    int temp = board[row][col] - '0';
                    rows[row][temp] = true;
                    cols[col][temp] = true;
                    cells[row/3][col/3][temp] = true;
                }
            }
        }

        recursiveSolveSudoku(board, 0,0);

    }

    public boolean recursiveSolveSudoku(char[][] board, int row, int col){

        // 边界检验，如果已经填充完成，则返回true
        if(col == board[row].length){
            row++;
            col = 0;
        }
        if(row == board.length){
            return true;
        }

        // 逐个格子进行填充，如果是空则进行填充，否则跳过尝试下一个位置
        if(board[row][col] == '.'){
            for(int i = 1; i <= 9; i++){
                boolean flag = rows[row][i] || cols[col][i] || cells[row/3][col/3][i];
                if(!flag){
                    // 先进行假设性填充
                    rows[row][i] = true;
                    cols[col][i] = true;
                    cells[row/3][col/3][i] = true;
                    board[row][col] = (char)('0' + i);
                    if(recursiveSolveSudoku(board, row, col + 1)){
                        return true;
                    }else{
                        // 如果数字不符合进行复原
                        rows[row][i] = false;
                        cols[col][i] = false;
                        cells[row/3][col/3][i] = false;
                        board[row][col] = '.';
                    }
                }
            }
        } else{
            return recursiveSolveSudoku(board, row, col+1);
        }

        return false;
    }




    @Test
    public void test(){
        System.out.println((char)(9 + '0'));
    }

}
