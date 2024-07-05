package algorithms_09;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组 points ，
 * 其中points[i] = [xstart, xend] 表示水平直径在 xstart 和 xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，
 * 若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足  xstart ≤ x ≤ xend，则该气球会被 引爆 。可以射出的弓箭的数量 没有限制 。
 * 弓箭一旦被射出之后，可以无限地前进。
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数 。
 *
 * @author wheat
 * @date 2024/06/12  9:35
 */
public class Solution_452 {

    public int findMinArrowShots(int[][] points) {

        if (points == null || points.length == 0) return 0;

        // 按 end 升序排序
        Arrays.sort(points, (a, b) -> {
            if (a[1] > b[1]) return 1;
            else return -1;
        });

        int x_end = points[0][1];
        int res = 1;
        for (int[] point : points) {
            if (point[0] > x_end) {
                res++;
                x_end = point[1];
            }
        }

        return res;
    }

}
