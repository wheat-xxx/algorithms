package algorithms_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/11  17:15
 */
public class Solution_73 {

    /**
     * 分析：
     *     使用列表记录矩阵的哪些位置原始元素是0
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {

        List<List<Integer>> state = new ArrayList<>();
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(matrix[i][j] == 0) {
                    List<Integer> temp = Arrays.asList(i, j);
                    state.add(temp);
                }
            }
        }

        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                List<Integer> temp = Arrays.asList(i, j);
                if(state.contains(temp)){
                    for(int k = 0; k < matrix.length; k++) matrix[k][j] = 0;
                    for(int k = 0; k < matrix[i].length; k++) matrix[i][k] = 0;
                }
            }
        }
    }

}
