package labuladong.ds.stack_queue;

import java.util.ArrayList;
import java.util.List;

/**
 * 单调队列：队列中的元素全都是单调递增（或递减）的
 * 场景：给你一个数组 window，已知其最值为 A，如果给 window 中添加一个数 B，那么比较一下 A 和 B 就可以立即算出新的最值；
 *     但如果要从 window 数组中减少一个数，就不能直接得到最值了，因为如果减少的这个数恰好是 A，就需要遍历 window 中的所有元素重新寻找新的最值。
 * 优先级队列：通过设置Comparator决定元素出队顺序
 * 堆：
 *
 * 问题：给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *     返回 滑动窗口中的最大值 。
 * @author wheat
 * @date 2024/04/17  10:10
 */
public class Solution_239 {

    /**
     * 单调队列思路
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                //先把窗口的前 k - 1 填满
                window.push(nums[i]);
            } else {
                // 窗口开始向前滑动
                // 移入新元素
                window.push(nums[i]);
                // 将当前窗口中的最大元素记入结果
                res.add(window.max());
                // 移出最后的元素
                window.pop(nums[i - k + 1]);
            }
        }
        // 将 List 类型转化成 int[] 数组作为返回值
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

}
