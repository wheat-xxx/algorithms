package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/11  17:42
 */
public class Solution_74 {

    public boolean searchMatrix(int[][] matrix, int target) {
        // 从右上角或者左下角开始只能由两个方向
        int i = 0, j = matrix[0].length - 1;
        while(i < matrix.length && j >= 0){
            if(target == matrix[i][j]) return true;
            else if(target < matrix[i][j]) j--;
            else i++;
        }
        return false;
    }

}
