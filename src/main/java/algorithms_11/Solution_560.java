package algorithms_11;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个整数数组 nums 和一个整数 k ，请你统计并返回 该数组中和为 k 的子数组的个数 。
 * 子数组是数组中元素的连续非空序列。
 * @author wheat
 * @date 2024/05/12  11:05
 */
public class Solution_560 {

    /**
     * 滑动窗口算法  [left, right) 只能解决不存在负数的情况
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {

        int left = 0, right = 0;
        int sum = 0;
        int count = 0;
        while (right < nums.length) {
            // 扩大滑动窗口
            sum += nums[right];
            right++;

            // 缩小窗口
            while (left < right && sum >= k) {
                // 更新返回结果
                if (sum == k) {
                    count++;
                }
                sum -= nums[left];
                left++;
            }
        }

        return count;

    }

    /**
     * 暴力解法
     * @param nums
     * @param k
     */
    public int subarraySum_2(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 前缀和数组
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum_3(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        int sum = 0;
        map.put(0, 1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }

            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return count;
    }

}
