package labuladong.search;

/**
 * @author wheat
 * @date 2024/03/24  22:14
 */
public class Solution_BinarySearch {

    /**
     * [] 形式最舒服
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1; // 注意

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] == target)
                return mid;
            else if (nums[mid] < target)
                left = mid + 1; // 注意
            else if (nums[mid] > target)
                right = mid - 1; // 注意
        }
        return -1;
    }

    /**
     * 有序数组 nums = [1,2,2,2,3]，target 为 2。
     * 如果我想得到 target 的左侧边界，即索引 1，或者我想得到 target 的右侧边界，即索引 3
     * 寻找左侧边界的二分搜索 [left, right)
     * 如果 target 不存在，搜索左侧边界的二分搜索返回的索引是大于 target 的最小索引
     * @param nums
     * @param target
     * @return
     */
    public int left_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;    // 注意

        while(left < right) {       // 注意   终止条件：left == right
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;    // 注意
            }
        }
        // 如果索引越界，说明数组中无目标元素，返回 -1
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    /**
     * []
     * @param nums
     * @param target
     * @return
     */
    public int left_bound_2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        // 搜索区间为 [left, right]
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 搜索区间变为 [mid+1, right]
                left = mid + 1;
            } else if (nums[mid] > target) {
                // 搜索区间变为 [left, mid-1]
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 收缩右侧边界
                right = mid - 1;
            }
        }
        // 判断 target 是否存在于 nums 中
        // 如果越界，target 肯定不存在，返回 -1
        if (left < 0 || left >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left] 是不是 target
        return nums[left] == target ? left : -1;
    }

    /**
     * [)
     * 如果 target 不存在，搜索右侧边界的二分搜索返回的索引是小于 target 的最大索引。
     * @param nums
     * @param target
     * @return
     */
    public int right_bound(int[] nums, int target) {
        int left = 0;
        int right = nums.length;

        while(left < right) {   // 终止条件 left == right
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }

        // 判断 target 是否存在于 nums 中
        // left - 1 索引越界的话 target 肯定不存在
        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }
        // 判断一下 nums[left - 1] 是不是 target
        return nums[left - 1] == target ? (left - 1) : -1;
    }

    /**
     * []
     * @param nums
     * @param target
     * @return
     */
    public int right_bound_2(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] == target) {
                // 这里改成收缩左侧边界即可
                left = mid + 1;
            }
        }
        // 最后改成返回 left - 1
        if (left - 1 < 0 || left - 1 >= nums.length) {
            return -1;
        }
        return nums[left - 1] == target ? (left - 1) : -1;
    }


}
