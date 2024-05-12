package algorithms_02;

/**
 * 处于同一直线上最多的点数
 * @author wheat
 * @date 2023/09/27  10:46
 */
public class Solution_149 {

    public int maxPoints(int[][] points) {

        // 边界情况
        if(points == null){
            return 0;
        }
        if(points.length < 3){
            return points.length;
        }

        // 至少三个点
        int maxCount = 2;
        for(int i = 0; i < points.length - 1; i++){
            int[] point_1 = points[i];
            for(int j = i + 1; j < points.length; j++) {
                int[] point_2 = points[j];
                int count = 2;
                for(int k = j + 1; k < points.length; k++) {
                    int[] point_3 = points[k];
                    boolean key = (point_2[1] - point_1[1]) * (point_3[0] - point_1[0]) ==
                            (point_3[1] - point_1[1]) * (point_2[0] - point_1[0]);
                    if(key){
                        count++;
                    }
                }
                if(maxCount < count) maxCount = count;
            }
        }

        return maxCount;

    }

}
