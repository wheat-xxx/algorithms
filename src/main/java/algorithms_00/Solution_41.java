package algorithms_00;

import org.junit.Test;

import java.awt.*;

/**
 * Description:
 *
 *      给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 *
 * @author wheat
 * @date 2023/03/02  14:04
 */
public class Solution_41 {

    public int firstMissingPositive(int[] nums) {
        if(nums == null || nums.length == 0) return 1;

        for(int i = 0; i < nums.length; i++){
            if (nums[i] > 0 && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i]){
                swap(nums, nums[i] - 1, i);
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                return i + 1;
            }
        }

        return nums.length + 1;
    }

    public void swap(int[] nums, int index1, int index2){
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    @Test
    public void test() {
        firstMissingPositive(new int[] {3,4,-1,1});
    }

}
