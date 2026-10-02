package algorithms_01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/14  15:06
 */
public class Solution_84 {

    /**
     * 分析：逐高度寻找最长宽度
     * 暴力解法 超时
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        if (heights == null) return 0;

        int maxHeight = -1;
        for (int i = 0; i < heights.length; i++)
            if (heights[i] > maxHeight) maxHeight = heights[i];

        int maxArea = 0;
        for (int i = 1; i <= maxHeight; i++) {
            // 寻找最长连续宽度
            int maxWidth = 0;
            int left = 0, right = 0;
            while (right < heights.length) {
                while (right < heights.length && heights[right] >= i) right++;

                if (left == right && heights[left] < i) {

                } else {
                    maxWidth = maxWidth < (right - left) ? (right - left) : maxWidth;
                    maxArea = maxArea < maxWidth * i ? maxWidth * i : maxArea;
                }

                left = ++right;
            }

        }
        return maxArea;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 单调栈思路
     * @param heights
     * @return
     */
    public int largestRectangleArea_2(int[] heights) {
        // 边界
        if (heights == null) return 0;

        int res = 0;
        // 存储 {height, index}
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[] {0, -1});
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                res = Math.max(res, stack.pop()[0] * (i - stack.peek()[1] - 1));
            }

            stack.push(new int[] {heights[i], i});
        }

        while (!stack.isEmpty() && 0 < stack.peek()[0]) {
            res = Math.max(res, stack.pop()[0] * (heights.length - stack.peek()[1] - 1));
        }

        return res;
    }

    @Test
    public void test() {
        int[] heights = {2, 1, 5, 6, 2, 3};

        int res = largestRectangleArea_2(heights);

    }

}
