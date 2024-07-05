package algorithms_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 给定两个以 非递减顺序排列 的整数数组 nums1 和 nums2 , 以及一个整数 k 。
 * 定义一对值 (u,v)，其中第一个元素来自 nums1，第二个元素来自 nums2 。
 * 请找到和最小的 k 个数对 (u1,v1),  (u2,v2)  ...  (uk,vk) 。
 *
 *
 * @author wheat
 * @date 2024/06/21  16:36
 */
public class Solution_373 {

    /**
     * 利用优先级队列 -- 超时
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> {
            return a.get(0) + a.get(1) - b.get(0) - b.get(1);
        });

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                pq.add(Arrays.asList(nums1[i], nums2[j]));
            }
        }

        List<List<Integer>> res = new ArrayList<>();
        try {
            for (int i = 0; i < k; i++) {
                res.add(pq.poll());
            }
        } catch (Exception e) {
            System.out.println("参数异常~~");
        }

        return res;

    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 优先级队列合并多个有序列表
     * @param nums1
     * @param nums2
     * @param k
     * @return
     */
    public List<List<Integer>> kSmallestPairs_2(int[] nums1, int[] nums2, int k) {
        // 存储三元组 (num1[i], nums2[i], i)
        // i 记录 nums2 元素的索引位置，用于生成下一个节点
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 按照数对的元素和升序排序
           return (a[0] + a[1]) - (b[0] + b[1]);
        });

        // 初始化优先级队列
        for (int i = 0; i < nums1.length; i++) {
            pq.add(new int[]{nums1[i], nums2[0], 0});
        }

        List<List<Integer>> res = new ArrayList<>();
        while (!pq.isEmpty() && k > 0) {
            k--;

            int[] cur = pq.poll();
            // 链表中的下一个节点加入优先级队列
            int next_index = cur[2] + 1;
            if (next_index < nums2.length) {
                pq.add(new int[]{cur[0], nums2[next_index], next_index});
            }

            // 加入结果
            res.add(Arrays.asList(cur[0], cur[1]));
        }

        return res;
    }

}
