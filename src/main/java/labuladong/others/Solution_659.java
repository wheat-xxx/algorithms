package labuladong.others;

import java.util.*;

/**
 * 给你一个按 非递减顺序 排列的整数数组 nums 。
 * 请你判断是否能在将 nums 分割成 一个或多个子序列 的同时满足下述 两个 条件：
 * 每个子序列都是一个 连续递增序列（即，每个整数 恰好 比前一个整数大 1 ）。
 * 所有子序列的长度 至少 为 3 。
 * 如果可以分割 nums 并满足上述条件，则返回 true ；否则，返回 false 。
 * <p>
 * 类似于挖红4
 *
 * @author wheat
 * @date 2024/05/07  16:23
 */
public class Solution_659 {

    /**
     * 两种情况：
     * 前元素 v 自成一派，「以自己开头」构成一个长度至少为 3 的序列。
     * 当前元素 v 接到已经存在的子序列后面。
     *
     * @param nums
     * @return
     */
    public boolean isPossible(int[] nums) {
        // 维护每个数在 nums 数组中出现的次数
        Map<Integer, Integer> freq = new HashMap<>();
        // 维护每个数作为结尾的连续子序列的需求量
        Map<Integer, Integer> need = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
        }

        for (int v : nums) {
            // 如果 v 已经被用到其他子序列中则无法再被用到
            if (freq.get(v) == 0) {
                continue;
            }

            // 尝试将 v 接到之前的某个序列后面
            if (need.containsKey(v) && need.get(v) > 0) {
                // 1. v 可以接到之前的某个序列后面
                freq.put(v, freq.get(v) - 1);
                need.put(v, need.get(v) - 1);
                need.put(v + 1, need.getOrDefault(v + 1, 0) + 1);
            } else if (freq.containsKey(v) && freq.get(v) > 0
                    && freq.containsKey(v + 1) && freq.get(v + 1) > 0
                    && freq.containsKey(v + 2) && freq.get(v + 2) > 0) {
                // 第二种情况，新建一个长度为 3 的子序列 [v, v+1, v+2]
                freq.put(v, freq.get(v) - 1);
                freq.put(v + 1, freq.get(v + 1) - 1);
                freq.put(v + 2, freq.get(v + 2) - 1);
                need.put(v + 3, need.getOrDefault(v + 3, 0) + 1);
            } else {
                // 两种情况都不符合，则无法分配
                return false;
            }
        }

        return true;
    }

    /**
     * 如果想要的不只是一个布尔值，想要把子序列都打印出来
     *
     * @param nums
     * @return
     */
    public boolean isPossible_2(int[] nums) {
        // 统计每个数字出现的频率
        Map<Integer, Integer> freq = new HashMap<>();
        for (int v : nums) freq.put(v, freq.getOrDefault(v, 0) + 1);

        // 以哈希表 {end: list} 维护每个以 end 为结尾的子序列
        Map<Integer, List<List<Integer>>> need = new HashMap<>();

        for (int v : nums) {
            if (freq.get(v) == 0) {
                continue;
            }

            if (need.containsKey(v) && !need.get(v).isEmpty()) {
                // 如果已经存在以 v - 1 结尾的子序列，就将当前 v 接到它后面
                freq.put(v, freq.get(v) - 1);
                // 取出需要 v 的最短子序列
                List<Integer> seq = need.get(v).remove(need.get(v).size() - 1);
                seq.add(v);
                // 将更新后的子序列添加到 map 中
                if (!need.containsKey(v + 1)) {
                    need.put(v + 1, new ArrayList<>());
                }
                need.get(v + 1).add(seq);

            } else if (freq.get(v) > 0 && freq.getOrDefault(v + 1, 0) > 0
                    && freq.getOrDefault(v + 2, 0) > 0) {
                // 否则如果存在 v, v + 1, v + 2，就新建一个以 v, v + 1, v + 2 为顺序的子序列
                freq.put(v, freq.get(v) - 1);
                freq.put(v + 1, freq.get(v + 1) - 1);
                freq.put(v + 2, freq.get(v + 2) - 1);
                List<Integer> seq = new ArrayList<>();
                seq.add(v);
                seq.add(v + 1);
                seq.add(v + 2);
                // 将更新后的子序列添加到 map 中
                if (!need.containsKey(v + 3)) {
                    need.put(v + 3, new ArrayList<>());
                }
                need.get(v + 3).add(seq);

            } else {
                // 如果既没有可以接到的子序列，也无法新建新的子序列，则返回 false
                return false;
            }
        }

        // 遍历所有序列(序列长度都>=3)
        for (List<List<Integer>> allSeq : need.values()) {
            for (List<Integer> seq : allSeq) {
                System.out.println(seq);
            }
        }

        // 如果所有序列长度都大于等于 3，则返回 true
        return true;
    }

}
