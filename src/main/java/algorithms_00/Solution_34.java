package algorithms_00;

/**
 * Description:
 *      给你一个按照非递减顺序排列的整数数组 nums，和一个目标值 target。请你找出给定目标值在数组中的开始位置和结束位置。
 *      你必须设计并实现时间复杂度为 O(log n) 的算法解决此问题。
 * @author wheat
 * @date 2023/02/28  16:28
 */
public class Solution_34 {

    public int[] searchRange(int[] nums, int target) {

        int[] res = {-1, -1};

        if(nums == null|| nums.length == 0) return res;

        int i = 0, j = nums.length - 1;
        int mid = 0;
        while(i <= j){
            mid = (i + j) / 2;
            if (nums[mid] == target){
                break;
            }else if(nums[mid] < target){
                i = mid + 1;
            }else{
                j = mid - 1;
            }
        }

        if(nums[mid] == target){
            i = j = mid;
            while(i >= 0 && nums[i] == target){
                i--;
            }
            while(j < nums.length && nums[j] == target){
                j++;
            }
            res[0] = i + 1; res[1] = j - 1;
        }
        return res;
    }

}
