package labuladong.ds.array_list;

/**
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 * @author wheat
 * @date 2024/03/20  10:20
 */
public class Solution_59 {

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int cycles = n / 2;
        int count = 1;
        for (int i = 0; i < cycles; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 上
                res[i][j] = count++;
            }
            for (int j = i; j < n - i - 1; j++) {
                // 右
                res[j][n - i - 1] = count++;
            }
            for (int j = i; j < n - i - 1; j++) {
                // 下
                res[n - i - 1][n - j - 1] = count++;
            }
            for (int j = i; j < n - i - 1; j++) {
                // 左
                res[n - j - 1][i] = count++;
            }

        }

        // 填充最中心的位置
        if(n % 2 == 1) {
            res[n / 2][n / 2] = n * n;
        }

        return res;
    }

    /*
    * ------------------------------------------------------------------------------------------------------------------
    * */

    public int[][] generateMatrix_2(int n) {
        int[][] res = new int[n][n];
        int cycles = n / 2;
        int count = 1;
        for (int i = 0; i < cycles; i++) {
            for (int j = i; j < n - i - 1; j++) {
                // 上
                res[i][j] = count++;
                // 右
                res[j][n - i - 1] = count++;
                // 下
                res[n - i - 1][n - j - 1] = count++;
                // 左
                res[n - j - 1][i] = count++;
            }

        }

        // 填充最中心的位置
        if(n % 2 == 1) {
            res[n / 2][n / 2] = n * n;
        }

        return res;
    }

    /*
    * ------------------------------------------------------------------------------------------------------------------
    * */

    public int[][] generateMatrix_3(int n) {
        int[][] matrix = new int[n][n];
        int upper_bound = 0, lower_bound = n - 1;
        int left_bound = 0, right_bound = n - 1;
        // 需要填入矩阵的数字
        int num = 1;

        while (num <= n * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    matrix[upper_bound][j] = num++;
                }
                // 上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    matrix[i][right_bound] = num++;
                }
                // 右边界左移
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    matrix[lower_bound][j] = num++;
                }
                // 下边界上移
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    matrix[i][left_bound] = num++;
                }
                // 左边界右移
                left_bound++;
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        Solution_59 obj = new Solution_59();
        obj.generateMatrix(3);
        obj.generateMatrix(4);
    }

}
