package algorithms_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *      给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 * @author wheat
 * @date 2023/03/07  8:38
 */
public class Solution_54 {

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res =  new ArrayList<Integer>();

        // 保存当前边界位置
        int upper = 0;
        int down = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while(true){
            for(int i = left; i <= right; i++) res.add(matrix[upper][i]);
            if(++upper > down) break;
            for(int i = upper; i <= down; i++) res.add(matrix[i][right]);
            if(--right < left) break;
            for(int i = right; i >= left; i--) res.add(matrix[down][i]);
            if(--down < upper) break;
            for(int i = down; i >= upper; i--) res.add(matrix[i][left]);
            if(++left > right) break;
        }

        return res;
    }



}
