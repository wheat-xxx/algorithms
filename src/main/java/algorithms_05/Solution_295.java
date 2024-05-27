package algorithms_05;

import java.util.PriorityQueue;

/**
 * 数据流的中位数
 *
 * @author wheat
 * @date 2024/05/27  16:25
 */
public class Solution_295 {

    /**
     * 优先级队列 - 二叉堆
     */
    class MedianFinder {

        // 保存排序后的上半部分元素 堆顶是最大值
        private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        // 保存排序后的下半部分元素 堆顶是最小值
        private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        private boolean flag = true;

        public MedianFinder() {

        }

        /**
         * minHeap.size() > maxHeap.size()
         * @param num
         */
        public void addNum(int num) {
            if (flag) {
                maxHeap.offer(num);
                minHeap.offer(maxHeap.poll());
                flag = false;
            } else {
                minHeap.offer(num);
                maxHeap.offer(minHeap.poll());
                flag = true;
            }
        }

        public double findMedian() {
            if ((minHeap.size() + maxHeap.size()) % 2 != 0) {
                return minHeap.peek();
            } else {
                return (minHeap.peek() + maxHeap.peek()) / 2.0;
            }
        }

    }

}
