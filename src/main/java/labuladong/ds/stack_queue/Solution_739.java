package labuladong.ds.stack_queue;

import java.util.Stack;

/**
 * 给定一个整数数组 temperatures ，表示每天的温度，返回一个数组 answer ，其中 answer[i] 是指对于第 i 天，下一个更高温度出现在几天后。
 * 如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * @author wheat
 * @date 2024/04/17  9:30
 */
public class Solution_739 {

    /**
     * 单调栈 无非是添加个索引用于计算元素之间的距离
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        // 0是value 1是index
        Stack<int[]> stack = new Stack<>();
        int[] res = new int[temperatures.length];
        /* 单调栈模板 */
        for (int i = temperatures.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek()[0] <= temperatures[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                res[i] = stack.peek()[1] - i;
            } else {
                res[i] = 0;
            }

            stack.push(new int[]{temperatures[i], i});
        }
        return res;
    }

}
