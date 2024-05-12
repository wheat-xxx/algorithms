package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *      请你判断一个 9 x 9 的数独是否有效 只需要验证已经填入的数字是否有效即可
 * @author wheat
 * @date 2023/02/28  17:04
 */
public class Solution_36 {

    // 先行 后列 最后小方格
    public boolean isValidSudoku(char[][] board) {

        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];

        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){

                // 对每个位置进行处理
                if(board[i][j] == '.') continue;
                else {
                    int temp = board[i][j] - '0';
                    // 行
                    if (row[i][temp] == 0) row[i][temp] = 1;
                    else return false;

                    // 列
                    if(col[j][temp] == 0) col[j][temp] = 1;
                    else return false;

                    // 小格子
                    if(box[j/3 + (i/3)*3][temp] == 0) box[j/3 + (i/3)*3][temp] = 1;
                    else return false;
                }
            }
        }


        return true;
    }

    @Test
    public void test(){
        System.out.println('9' - '0');;
    }

}
