package labuladong.ds.array_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
 *
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

    /*
    * ------------------------------------------------------------------------------------------------------------------
    * */


    List<Integer> spiralOrder_2(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int upper_bound = 0, lower_bound = m - 1;
        int left_bound = 0, right_bound = n - 1;
        List<Integer> res = new LinkedList<>();
        // res.size() == m * n 则遍历完整个数组
        while (res.size() < m * n) {
            if (upper_bound <= lower_bound) {
                // 在顶部从左向右遍历
                for (int j = left_bound; j <= right_bound; j++) {
                    res.add(matrix[upper_bound][j]);
                }
                // 上边界下移
                upper_bound++;
            }

            if (left_bound <= right_bound) {
                // 在右侧从上向下遍历
                for (int i = upper_bound; i <= lower_bound; i++) {
                    res.add(matrix[i][right_bound]);
                }
                // 右边界左移
                right_bound--;
            }

            if (upper_bound <= lower_bound) {
                // 在底部从右向左遍历
                for (int j = right_bound; j >= left_bound; j--) {
                    res.add(matrix[lower_bound][j]);
                }
                // 下边界上移
                lower_bound--;
            }

            if (left_bound <= right_bound) {
                // 在左侧从下向上遍历
                for (int i = lower_bound; i >= upper_bound; i--) {
                    res.add(matrix[i][left_bound]);
                }
                // 左边界右移
                left_bound++;
            }
        }
        return res;
    }

}
