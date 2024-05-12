package labuladong.greedy;

/**
 * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
 * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
 * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
 *
 * 贪心算法的本质：如果找不到重复计算，那就通过问题中隐藏较深的规律，来减少冗余计算
 *
 * @author wheat
 * @date 2024/05/06  20:21
 */
public class Solution_134 {

    /**
     * 暴力解法 - O(n^2)
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            int currentGas = 0;
            int index = i;
            for (int j = 0; j < gas.length; j++) {
                // 当前站索引
                index = (i + j) % gas.length;
                // 是否能开往下一站
                currentGas = currentGas + gas[index] - cost[index];
                if (currentGas < 0) {
                    break;
                }
            }
            // 是否可以转一圈
            if ((index + 1) % gas.length == i && currentGas >= 0) {
                return i;
            }
        }
        return -1;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 贪心算法
     *
     * 规律：如果选择站点 i 作为起点「恰好」无法走到站点 j，那么 i 和 j 中间的任意站点 k 都不可能作为起点。
     * @param gas
     * @param cost
     * @return
     */
    public int canCompleteCircuit_2(int[] gas, int[] cost) {
        int n = gas.length;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += gas[i] - cost[i];
        }
        if (sum < 0) {
            // 总油量小于总的消耗，无解
            return -1;
        }
        // 记录油箱中的油量
        int tank = 0;
        // 记录起点
        int start = 0;
        for (int i = 0; i < n; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                // 无法从 start 到达 i + 1
                // 所以站点 i + 1 应该是起点
                tank = 0;
                start = i + 1;
            }
        }
        return start == n ? 0 : start;
    }

}
