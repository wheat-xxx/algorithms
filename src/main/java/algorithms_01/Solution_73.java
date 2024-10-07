package algorithms_01;

import java.util.*;
import java.util.zip.ZipEntry;

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

        int m = matrix.length;
        int n = matrix[0].length;
        HashSet<Data> set = new HashSet<>();
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == 0) {
                    set.add(new Data(i, j));
                }
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(set.contains(new Data(i, j))){
                    for(int k = 0; k < m; k++) matrix[k][j] = 0;
                    for(int k = 0; k < n; k++) matrix[i][k] = 0;
                }
            }
        }
    }

    private class Data {
        int i;
        int j;
        public Data(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Data data = (Data) o;

            if (i != data.i) return false;
            return j == data.j;
        }

        @Override
        public int hashCode() {
            int result = i;
            result = 31 * result + j;
            return result;
        }
    }

}
