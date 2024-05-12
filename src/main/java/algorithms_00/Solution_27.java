package algorithms_00;

/**
 * Description:
 *      给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * @author wheat
 * @date 2023/02/26  18:51
 */
public class Solution_27 {

    public int removeElement(int[] nums, int val) {

        if(nums == null || nums.length == 0) return 0;

        int i = -1, j = i + 1;
        while(j < nums.length){
            if(nums[j] == val){
                j++;
            }else{
                nums[++i] = nums[j++];
            }
        }

        return i + 1;
    }

}
