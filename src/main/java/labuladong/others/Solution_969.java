package labuladong.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 arr ，请使用 煎饼翻转 完成对数组的排序。
 * 一次煎饼翻转的执行过程如下：
 *   选择一个整数 k ，1 <= k <= arr.length
 *   反转子数组 arr[0...k-1]（下标从 0 开始）
 *
 * @author wheat
 * @date 2024/05/07  20:31
 */
public class Solution_969 {

    /**
     *
     * @param arr
     * @return 以数组形式返回能使 arr 有序的煎饼翻转操作所对应的 k 值序列
     */
    public List<Integer> pancakeSort(int[] arr) {
        sort(arr, arr.length);
        return res;
    }

    private List<Integer> res = new ArrayList<>();

    /**
     *
     * @param nums
     * @param n 数组长度
     */
    private void sort(int[] nums, int n) {

        // base case
        if (n == 1) return;

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > nums[max]) max = i;
        }

        // 第一次翻转，将最大饼翻到最上面
        reverse(nums, 0, max);
        res.add(max + 1);
        // 第二次翻转，将最大饼翻到最下面
        reverse(nums, 0, n - 1);
        res.add(n);

        // 进入下一层递归
        sort(nums, n - 1);
    }

    /**
     * [i,j]
     * @param nums
     * @param i
     * @param j
     */
    private void reverse(int[] nums, int i, int j) {
        for (; i < j; i++, j--) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }

}
