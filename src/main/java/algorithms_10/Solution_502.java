package algorithms_10;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 假设 力扣（LeetCode）即将开始 IPO 。为了以更高的价格将股票卖给风险投资公司，力扣 希望在 IPO 之前开展一些项目以增加其资本。
 * 由于资源有限，它只能在 IPO 之前完成最多 k 个不同的项目。帮助 力扣 设计完成最多 k 个不同项目后得到最大总资本的方式。
 * 给你 n 个项目。对于每个项目 i ，它都有一个纯利润 profits[i] ，和启动该项目需要的最小资本 capital[i] 。
 * 最初，你的资本为 w 。当你完成一个项目时，你将获得纯利润，且利润将被添加到你的总资本中。
 * 总而言之，从给定项目中选择 最多 k 个不同项目的列表，以 最大化最终资本 ，并输出最终可获得的最多资本。
 * 答案保证在 32 位有符号整数范围内。
 *
 * @author wheat
 * @date 2024/06/24  17:13
 */
public class Solution_502 {

    /**
     * 超出时间限制
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n = profits.length;
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            data[i] = new int[]{profits[i], capital[i]};
        }

        Arrays.sort(data, (a, b) -> (b[0] - a[0]));
        boolean[] visited = new boolean[n];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if (data[j][1] <= w && !visited[j]) {
                    w += data[j][0];
                    visited[j] = true;
                    break;
                }
            }
        }

        return w;

    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 利用堆的贪心算法
     * @param k
     * @param w
     * @param profits
     * @param capital
     * @return
     */
    public int findMaximizedCapital_2(int k, int w, int[] profits, int[] capital) {

        int n = profits.length;
        int[][] data = new int[n][2];

        for (int i = 0; i < n; i++) {
            data[i][0] = capital[i];
            data[i][1] = profits[i];
        }

        Arrays.sort(data, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);

        int index = 0;
        for (int i = 0; i < k; i++) {
            while (index < n && data[index][0] <= w) {
                pq.add(data[index][1]);
                index++;
            }
            if (!pq.isEmpty()) {
                w += pq.poll();
            } else {
                break;
            }
        }

        return w;
    }

}
