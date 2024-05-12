package labuladong.ds.stack_queue;

import java.util.LinkedList;

/**
 * 单调队列实现
 * @author wheat
 * @date 2024/04/17  10:30
 */
public class MonotonicQueue {

    // 双链表，支持头部和尾部增删元素
    // 维护其中的元素自尾部到头部单调递增
    private LinkedList<Integer> maxq = new LinkedList<>();

    /**
     * 在尾部添加一个元素 n，维护 maxq 的单调性质
     * @param val
     */
    public void push(int val) {
        // 将前面小于自己的元素都删除
        while (!maxq.isEmpty() && maxq.getLast() < val) {
            maxq.pollLast();
        }
        maxq.addLast(val);
    }

    public int max() {
        // 队头的元素肯定是最大的
        return maxq.getFirst();
    }

    /**
     * 之所以要判断 n == maxq.getFirst()，是因为我们想删除的队头元素 n 可能已经被「压扁」了，可能已经不存在了，所以这时候就不用删除了
     * @param val
     */
    public void pop(int val) {
        if (val == maxq.getFirst()) {
            maxq.pollFirst();
        }
    }
}
