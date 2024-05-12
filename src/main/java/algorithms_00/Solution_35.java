package algorithms_00;

/**
 * Description:
 *      给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置
 * @author wheat
 * @date 2023/02/28  16:45
 */
public class Solution_35 {

    public int searchInsert(int[] nums, int target){

        if(nums == null && nums.length == 0) return -1;

        int i = 0, j = nums.length - 1;
        int middle = 0;
        while(i <= j){
            middle = (i + j) / 2;
            if(target == nums[middle]) return middle;
            else if(target < nums[middle]){
                j = middle - 1;
            }else{
                i = middle + 1;
            }
        }

        if(i == middle){
            return middle;
        }else{
            return middle + 1;
        }
    }

}
