package algorithms_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Description:
 *
 *      以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
 *      请你合并所有重叠的区间，并返回 一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间 。
 *
 * @author wheat
 * @date 2023/03/07  9:38
 */
public class Solution_56 {

    public int[][] merge(int[][] intervals) {
        List<int[]> res = new ArrayList<int[]>();

        // 对区间的起始值进行排序 减少后续遍历时间
        sort(intervals);

        // 合并操作
        int i = 0, j;
        int[] temp = new int[2];
        while(i < intervals.length){
            temp[0] = intervals[i][0];
            temp[1] = intervals[i][1];
            j = i + 1;
            // 进行合并操作
            while(j < intervals.length){
                // 满足合并操作
                if(intervals[j][0] <= temp[1]) {
                    if(intervals[j][1] > temp[1]){
                        temp[1] = intervals[j][1];
                    }
                    j++;
                }else{
                    break;
                }
            }
            res.add(new int[]{temp[0], temp[1]});
            // 外层while更新
            i = j;
        }


        //return (int[][])(res.toArray());
        int[][] res_arr = new int[res.size()][];
        for(int k = 0; k < res.size();k++){
            res_arr[k] = res.get(k);
        }
        return res_arr;
    }

    public void sort(int[][] arr){
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] - o2[0] == 0) return o1[1] - o2[1];
                else return o1[0] - o2[0];
            }
        });
    }


    @Test
    public void test(){

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);

    }

}
