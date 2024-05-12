package algorithms_00;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/05  18:56
 */
public class Solution_48 {

    public void rotate(int[][] matrix) {

        // 从外至内 或 从内之外 一圈一圈的进行调整
        for(int i = 0; i < matrix.length/2; i++){
            for(int j = 0; j < matrix.length - i * 2 - 1; j++){
                int temp = matrix[i][i + j];
                matrix[i][i + j] = matrix[matrix.length - 1 - i - j][i];
                matrix[matrix.length - 1 - i - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - i - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - i - j] = matrix[i + j][matrix.length - 1 - i];
                matrix[i + j][matrix.length - 1 - i] = temp;
            }
        }

    }

}
