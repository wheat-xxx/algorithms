package algorithms_00;

/**
 * Description:
 *      搜索旋转排序数组 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题
 * @author wheat
 * @date 2023/02/28  15:03
 */
public class Solution_33 {

    public int search(int[] nums, int target) {

        // 边界条件
        if(nums == null || nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while(left <= right){

            int middle = (left + right) / 2;

            if(target == nums[middle]) return middle;

            if(nums[left] <= nums[middle]){     // left middle 单调递增
                if(nums[left] <= target && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            }else{  // middle right 单调递增
                if(nums[middle] < target && target <= nums[right]) left = middle + 1;
                else right = middle - 1;
            }


        }

        return -1;
    }

}
