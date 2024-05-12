package labuladong.backtrack;

import java.security.Key;
import java.util.Arrays;

/**
 * 给定一个整数数组  nums 和一个正整数 k，找出是否有可能把这个数组分成 k 个非空子集，其总和都相等。
 *
 * 球盒模型站在谁的视角如何判断？
 *      每一次调用backtrack都有一个index索引（通过参数列表传递），该index在每一次递归中是确定的；index就是视角
 *      在backtrack函数中，选择列表对应的是盒或球中的另一个
 * @author wheat
 * @date 2024/03/24  15:22
 */
public class Solution_698 {

    /**
     * 球盒模型：站在球的视角 球选择是否进入某个盒子
     * 回溯算法核心框架的for循环的选择列表就是盒子
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets(int[] nums, int k) {
        // 边界情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;

        // nums 降序排序
        Arrays.sort(nums);
        for (int i = 0, j = nums.length - 1; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // k 个桶（集合），记录每个桶装的数字之和
        int[] bucket = new int[k];
        // 理论上每个桶（集合）中数字的和
        int target = sum / k;
        // 穷举，看看 nums 是否能划分成 k 个和为 target 的子集
        return backtrack(nums, 0, bucket, target);
    }

    /**
     * 递归穷举 nums 中的每个数字
     * 球的视角
     * @param nums
     * @param index
     * @param bucket
     * @param target
     * @return
     */
    private boolean backtrack(int[] nums, int index, int[] bucket, int target) {
        // 结束条件
        if (index == nums.length) {
            for (int i = 0; i < bucket.length; i++) {
                if (bucket[i] != target) {
                    return false;
                }
            }
            return true;
        }

        // 穷举 nums[index] 可能装入的桶
        for (int i = 0; i < bucket.length; i++) {
            // 剪枝，桶装满了
            if (bucket[i] + nums[index] > target) {
                continue;
            }

            // 做选择 将 nums[index] 装入 bucket[i]
            bucket[i] += nums[index];

            // 递归穷举下一个数字的选择
            if (backtrack(nums, index + 1, bucket, target)) {
                return true;
            }

            // 撤销选择
            bucket[i] -= nums[index];
        }

        // nums[index] 装入哪个桶都不行
        return false;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 球盒模型：桶的视角
     * 回溯算法核心框架的for循环的选择列表就是球
     * @param nums
     * @param k
     * @return
     */
    public boolean canPartitionKSubsets_2(int[] nums, int k) {
        // 边界情况
        if (k > nums.length) return false;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) sum += nums[i];
        if (sum % k != 0) return false;

        boolean[] used = new boolean[nums.length];
        int target = sum / k;


        return backtrack(nums, used, target, k, 0, 0);
    }

    /**
     * 回溯算法
     * 球盒模型：盒的视角
     * @return
     */
    private boolean backtrack(int[] nums, boolean[] used, int target, int k, int bucket, int start) {
        if (k == 0) {
            // 所有桶都被装满了，而且 nums 一定全部用完了
            // 因为 target == sum / k
            return true;
        }

        if (bucket == target) {
            // 装满了当前桶，递归穷举下一个桶的选择
            // 让下一个桶从 nums[0] 开始选数字
            return backtrack(nums, used, target, k - 1, 0, 0);
        }

        // 从 start 开始向后探查有效的 nums[i] 装入当前桶
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (used[i]) {
                // nums[i] 已经被装入别的桶中
                continue;
            }

            // 当前桶装不下 nums[i]
            if (bucket + nums[i] > target) {
                continue;
            }

            // 做选择
            bucket += nums[i];
            used[i] = true;

            // 递归穷举下一个数字是否装入当前桶
            if (backtrack(nums, used, target, k, bucket, i + 1)) {
                return true;
            }

            // 撤销选择
            bucket -= nums[i];
            used[i] = false;
        }

        // 穷举了所有数字，都无法装满当前桶
        return false;
    }

}
