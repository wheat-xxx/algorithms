package labuladong.ds.array_list;

/**
 * 常规的思路就是去寻找原始坐标和旋转后坐标的映射规律，但我们是否可以让思维跳跃跳跃，尝试把矩阵进行反转、镜像对称等操作，可能会出现新的突破口。
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

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    public void rotate_3(int[][] matrix) {
        int n = matrix.length;

        for (int i = 0; i < n / 2; i++) {
            for (int j = i; j < n - i - 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j - 1][i];
                matrix[n - j - 1][i] = matrix[n - i - 1][n - j - 1];
                matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
                matrix[j][n - i - 1] = temp;
            }
        }
    }

    /*
     * ------------------------------------------------------------------------------------------------------------------
     */


    /**
     * 将二维矩阵原地顺时针旋转 90 度
     * @param matrix
     */
    public void rotate_2(int[][] matrix) {
        int n = matrix.length;
        // 先沿对角线镜像对称二维矩阵
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                // swap(matrix[i][j], matrix[j][i]);
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 然后反转二维矩阵的每一行
        for (int[] row : matrix) {
            reverse(row);
        }
    }

    // 反转一维数组
    void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (j > i) {
            // swap(arr[i], arr[j]);
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

}
