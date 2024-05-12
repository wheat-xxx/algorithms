package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/07  17:39
 */
public class Solution_59 {

    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int upper = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        int index = 1;
        while(true){
            for(int i = left; i <= right; i++){
                matrix[upper][i] = index++;
            }
            if(++upper > down) break;
            for(int i = upper; i <= down; i++){
                matrix[i][right] = index++;
            }
            if(--right < left) break;
            for(int i = right; i >= left; i--){
                matrix[down][i] = index++;
            }
            if(--down < upper) break;
            for(int i = down; i >= upper; i--){
                matrix[i][left] = index++;
            }
            if(++left > right) break;
        }

        return matrix;

    }

}
