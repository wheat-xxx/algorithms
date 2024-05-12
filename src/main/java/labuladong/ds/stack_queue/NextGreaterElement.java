package labuladong.ds.stack_queue;

import java.util.Stack;

/**
 * 单调栈：使得每次新元素入栈后，栈内的元素都保持有序（单调递增或单调递减）
 * 问题：输入一个数组 nums，请你返回一个等长的结果数组，结果数组中对应索引存储着下一个更大元素，如果没有更大的元素，就存 -1
 *
 * 这就是单调队列解决问题的模板。for 循环要从后往前扫描元素，因为我们借助的是栈的结构，倒着入栈，其实是正着出栈。
 * while 循环是把两个「个子高」元素之间的元素排除，因为他们的存在没有意义，
 * 前面挡着个「更高」的元素，所以他们不可能被作为后续进来的元素的下一个更大元素了。
 * @author wheat
 * @date 2024/04/16  21:12
 */
public class NextGreaterElement {

    public int[] nextGreaterElement(int[] nums) {
        int len = nums.length;
        int[] res = new int[len];
        Stack<Integer> stack = new Stack<>();
        // 倒着往栈里放
        for (int i = len - 1; i >= 0; i--) {
            // 判定个子高矮
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                // 矮个起开，反正也被挡着了。。。
                stack.pop();
            }
            // nums[i] 身后的更大元素
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }

        return res;
    }

}
