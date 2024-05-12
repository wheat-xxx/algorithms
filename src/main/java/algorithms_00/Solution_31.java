package algorithms_00;

import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 *      下一个排列
 * @author wheat
 * @date 2023/02/27  14:47
 */
public class Solution_31 {

    /**
     * 利用字典序法计算下一个排序。
     * @param nums
     */
    public void nextPermutation(int[] nums) {

        if(nums == null || nums.length == 0) return;

        int i = nums.length - 1;
        while(i > 0 && nums[i] <= nums[i - 1]){
            i--;
        }
        // 最大排序的下一个排序是最小排序
        if(i == 0){
            Arrays.sort(nums);
            return;
        }

        // 这时 i - 1 是第一个出现降序的值
        // 找出 i - 1 右边比 i-1 大的第一个数 进行交换
        int j = nums.length - 1;
        while(nums[i-1] >= nums[j]){
            j--;
        }
        swap(nums, i - 1, j);
        Arrays.sort(nums, i, nums.length);

    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    @Test
    public void test(){
        int[] nums = {2, 3, 1, 2, 4};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

}
