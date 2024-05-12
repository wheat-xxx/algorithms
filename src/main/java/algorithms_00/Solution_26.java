package algorithms_00;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/26  18:35
 */
public class Solution_26 {

    public int removeDuplicates(int[] nums) {

        // 边界条件
        if(nums == null || nums.length == 0) return 0;

        int count = 0;

        // 删除重复元素(标记)
        int i = 0, j = i+1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
            }else{
                nums[++i] = nums[j++];
            }
        }

        return i + 1;
    }

}
