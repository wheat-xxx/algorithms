package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/14  10:27
 */
public class Solution_81 {

    public boolean search(int[] nums, int target) {

        if(nums == null || nums.length == 0) return false;

        int left = 0, right = nums.length - 1;
        while(left <= right){
            int middle = (left + right) / 2;

            if(target == nums[middle]) return true;

            if(nums[left] == nums[middle]){
                left++;
                continue;
            }

            //middle前半部分有序
            if(nums[middle] > nums[left]){
                if(target >= nums[left] && target < nums[middle]) right = middle - 1;
                else left = middle + 1;
            }else{ // middle 的后半部分有序
                if(target > nums[middle] && target <= nums[right]) left = middle + 1;
                else right = middle - 1;
            }

        }
        return false;

    }

}
