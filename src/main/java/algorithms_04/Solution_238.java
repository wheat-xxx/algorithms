package algorithms_04;

/**
 * 给你一个整数数组 nums，返回 数组 answer ，其中 answer[i] 等于 nums 中除 nums[i] 之外其余各元素的乘积 。
 * 题目数据 保证 数组 nums之中任意元素的全部前缀元素和后缀的乘积都在  32 位 整数范围内。
 * 请 不要使用除法，且在 O(n) 时间复杂度内完成此题。
 *
 * @author wheat
 * @date 2024/05/13  21:57
 */
public class Solution_238 {

    public int[] productExceptSelf(int[] nums) {
        // 前缀元素乘积
        int[] prefixProduct = new int[nums.length + 1];
        prefixProduct[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            prefixProduct[i + 1] = prefixProduct[i] * nums[i];
        }
        // 后缀元素乘积
        int[] suffixProduct = new int[nums.length + 1];
        suffixProduct[nums.length] = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            suffixProduct[i] = suffixProduct[i + 1] * nums[i];
        }

        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            res[i] = prefixProduct[i] * suffixProduct[i + 1];
        }
        return res;
    }

}
