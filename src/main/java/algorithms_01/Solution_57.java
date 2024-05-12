package algorithms_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 *      给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
 *
 *      在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
 *
 * @author wheat
 * @date 2023/03/07  16:49
 */
public class Solution_57 {

    // 不要给自己增加难度
    public int[][] insert(int[][] intervals, int[] newInterval) {

        // 保存返回结果
        List<int[]> res = new ArrayList<>();
        int len = intervals.length;
        int i = 0;

        // 找出左边位置
        while(i < len && intervals[i][1] < newInterval[0]){
            res.add(intervals[i]);
            i++;
        }

        // 重叠部分
        while(i < len && intervals[i][0] <= newInterval[1]){
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;
        }
        res.add(newInterval);

        while(i < len){
            res.add(intervals[i]);
            i++;
        }

        return res.toArray(new int[0][]);
    }

}
