package algorithms_06;

import java.util.*;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你返回其中出现频率前 k 高的元素。你可以按 任意顺序 返回答案。
 *
 * @author wheat
 * @date 2024/05/27  15:15
 */
public class Solution_347 {

    public int[] topKFrequent(int[] nums, int k) {
        // num -> count
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        // 需要对count进行排序
        Collection<Integer> counts = map.values();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        priorityQueue.addAll(counts);

        // 求要求的最低词频数
        int max_min = 0;
        for (int i = 0; i < k; i++) {
            max_min = priorityQueue.poll();
        }

        int[] res = new int[k];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() >= max_min) {
                res[index++] = entry.getKey();
            }
        }

        return res;
    }

}
