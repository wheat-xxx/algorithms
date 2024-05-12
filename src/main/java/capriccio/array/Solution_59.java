package capriccio.array;

/**
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

    public static void main(String[] args) {
        Solution_59 obj = new Solution_59();
        obj.generateMatrix(3);
        obj.generateMatrix(4);
    }

}
