package labuladong.search;

/**
 * 给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 * @author wheat
 * @date 2024/03/24  22:39
 */
public class Solution_34 {

    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;

        int left = 0, right = nums.length - 1;  // 寻找左侧边界
        while (left <= right) {     // 终止条件 left = right + 1
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                right = mid - 1;
            }
        }

        if (left < 0 || left >= nums.length) {
            return res;
        }
        if (nums[left] != target) {
            return res;
        }

        res[0] = left;
        while(left < nums.length && nums[left] == target) {
            left++;
        }
        res[1] = left - 1;
        return res;
    }

}
