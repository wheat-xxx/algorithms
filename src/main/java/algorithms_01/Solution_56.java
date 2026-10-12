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
        // 排序
        Arrays.sort(intervals, (interval1, interval2) -> {
            return interval1[0] - interval2[0];
        });

        List<int[]> retVal = new ArrayList<>();

        int[] curWindow = new int[] {intervals[0][0], intervals[0][1]};
        for (int[] interval : intervals) {
            // 满足合并条件
            if (interval[0] > curWindow[1]) {
                retVal.add(Arrays.copyOf(curWindow, curWindow.length));
                curWindow[0] = interval[0];
                curWindow[1] = interval[1];
            } else {
                curWindow[1] = Math.max(curWindow[1], interval[1]);
            }
        }

        // 添加最后一个
        retVal.add(Arrays.copyOf(curWindow, curWindow.length));

        return retVal.toArray(new int[0][]);
    }


    @Test
    public void test(){

        int[][] intervals = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        int[][] res = merge(intervals);

    }

}
