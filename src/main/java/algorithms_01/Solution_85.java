package algorithms_01;

/**
 * Description:
 *      使用递归进行解决
 * @author wheat
 * @date 2023/03/14  17:03
 */
public class Solution_85 {

//    public int maximalRectangle(char[][] matrix) {
//
//        int[][] dp = new int[matrix.length][matrix[0].length];
//
//        for(int i = 0; i < matrix.length; i++) dp[i][0] = matrix[i][0] - '0';
//
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 1; j < matrix[i].length; j++){
//                if(matrix[i][j] == '1') dp[i][j] = dp[i][j - 1] + 1;
//            }
//        }
//
//        int res = 0;
//        for(int i = 0; i < matrix.length; i++){
//            for(int j = 0; j < matrix[i].length; j++){
//                int width = Integer.MAX_VALUE;
//                for(int k = i; k >= 0; k--){
//                    int height = i - k + 1;
//                    width = width <= dp[k][j] ? width : dp[k][j];
//                    int area = height * width;
//                    res = res >= area ? res : area;
//                }
//            }
//        }
//        return res;
//    }


}
