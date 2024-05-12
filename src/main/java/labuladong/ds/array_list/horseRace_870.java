package labuladong.ds.array_list;

import java.util.Arrays;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * 给定两个长度相等的数组 nums1 和 nums2，nums1 相对于 nums2 的优势可以用满足 nums1[i] > nums2[i] 的索引 i 的数目来描述。
 * 返回 nums1 的任意排列，使其相对于 nums2 的优势最大化。
 *
 * 将齐王和田忌的马按照战斗力排序，然后按照排名一一对比。如果田忌的马能赢，那就比赛，如果赢不了，那就换个垫底的来送人头，保存实力。
 * @author wheat
 * @date 2024/04/12  10:34
 */
public class horseRace_870 {

    /**
     * 使用优先级队列对nums2中的元素进行排序
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] advantageCount(int[] nums1, int[] nums2) {
        // 使用优先级队列给nums2降序排序
        PriorityQueue<int[]> maxpq = new PriorityQueue<>((pair1, pair2) -> pair2[1] - pair1[1]);
        int len = nums2.length;
        for (int i = 0; i < len; i++) {
            maxpq.offer(new int[] {i, nums2[i]});
        }

        // nums1 只能升序排序
        Arrays.sort(nums1);
        int[] res = new int[len];
        int left = 0, right = len - 1;

        while (!maxpq.isEmpty()) {
            int[] pair = maxpq.poll();
            // maxval 是 nums2 中的最大值，i 是对应索引
            int i = pair[0], maxval = pair[1];
            if (nums1[right] > pair[1]) {
                // 如果 nums1[right] 能胜过 maxval，那就自己上
                res[pair[0]] = nums1[right--];
            } else {
                // 否则用最小值混一下，养精蓄锐
                res[pair[0]] = nums1[left++];
            }
        }

        return res;
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> a - b);
        // 向队列中添加元素
        pq.add(5);
        pq.add(3);
        pq.add(8);
        pq.add(1);

        Iterator<Integer> iterator = pq.iterator();
        while(iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        int[] arr = {5, 3, 8, 1};
    }
}
