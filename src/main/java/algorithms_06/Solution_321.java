package algorithms_06;

import java.util.PriorityQueue;
import java.util.Stack;

/**
 *
 * 给你两个整数数组 nums1 和 nums2，它们的长度分别为 m 和 n。数组 nums1 和 nums2 分别代表两个数各位上的数字。同时你也会得到一个整数 k。
 * 请你利用这两个数组中的数字中创建一个长度为 k <= m + n 的最大数，在这个必须保留来自同一数组的数字的相对顺序。
 * 返回代表答案的长度为 k 的数组。
 *
 * 重要：合并两个无序数组时，如果对应位置的元素相等，则需要进一步比较后续元素的大小
 *
 * @author wheat
 * @date 2024/07/11  11:16
 */
public class Solution_321 {

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] max = new int[k];
        for (int i = 0; i <= k; i++) {
            if (i <= nums1.length && (k - i) <= nums2.length) {
                int[] res1 = remainKDigits(nums1, i);
                int[] res2 = remainKDigits(nums2, k - i);
                int[] temp = merge(res1, res2);
                max = max(max, temp);
            }
        }

        return max;
    }

    /**
     * 剔除多余元素
     * @param nums
     * @param k
     * @return
     */
    private int[] remainKDigits(int[] nums, int k) {
        Stack<Integer> stack = new Stack<>();
        int del = nums.length - k;
        for (int num : nums) {
            while (del > 0 && !stack.isEmpty() && stack.peek() < num) {
                stack.pop();
                del--;
            }
            stack.push(num);
        }

        // 弹出多余的元素
        while (del-- > 0) {
            stack.pop();
        }

        int[] res = new int[stack.size()];
        for (int i = res.length - 1; i >= 0; i--) {
            res[i] = stack.pop();
        }

        return res;
    }

    /**
     * 合并两个数组
     * 合并两个无序数组时，如果对应位置的元素相等，则需要进一步比较后续元素的大小
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] merge(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length + nums2.length];
        int i = 0, j = 0;
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] > nums2[j]) {
                res[index++] = nums1[i];
                i++;
            } else if (nums1[i] < nums2[j]) {
                res[index++] = nums2[j];
                j++;
            } else {
                if (compare(nums1, i, nums2, j)) {
                    res[index++] = nums1[i++];
                } else {
                    res[index++] = nums2[j++];
                }
            }
        }

        // 处理剩余元素
        while (i < nums1.length) {
            res[index++] = nums1[i++];
        }
        while (j < nums2.length) {
            res[index++] = nums2[j++];
        }

        return res;
    }

    /**
     * 比较两个数组的大小
     * 合并两个无序数组时，如果对应位置的元素相等，则需要进一步比较后续元素的大小
     * @param nums1
     * @param i
     * @param nums2
     * @param j
     * @return
     */
    private boolean compare(int[] nums1, int i, int[] nums2, int j) {
        int x = i, y = j;
        while (x < nums1.length && y < nums2.length && nums1[x] == nums2[y]) {
            x++;
            y++;
        }
        if (x == nums1.length) return false;
        if (y == nums2.length) return true;

        return nums1[x] > nums2[y];
    }

    /**
     * 比较两个用数组保存的大数的大小
     * @param nums1
     * @param nums2
     * @return
     */
    private int[] max(int[] nums1, int[] nums2) {
        int len = nums1.length;
        for (int i = 0; i < len; i++) {
            if (nums1[i] > nums2[i]) {
                return nums1;
            } else if (nums1[i] < nums2[i]) {
                return nums2;
            } else {
                continue;
            }
        }
        return nums1;
    }

}
