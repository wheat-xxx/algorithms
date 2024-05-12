package algorithms_01;

import java.util.Arrays;

/**
 * Description:
 *
 *      该题就是一个排序问题 只不过其中只有三个值并含有大量重复元素
 *
 * @author wheat
 * @date 2023/03/11  17:48
 */
public class Solution_75 {

    public void sortColors(int[] nums) {
        // 利用快排进行求解
        quickSort(nums, 0, nums.length - 1);

    }

    public void quickSort(int[] nums, int start, int end){
        if(start >= end) return;

        int left = start, right = end;
        int pivot = nums[start];
        while(left < right){
            while(left < right && nums[right] >= pivot) right--;
            while(left < right && nums[left] <= pivot) left++;
            if(left < right) swap(nums, left, right);
        }

        // 这里 left 和 right 指向相同的位置 且left就是新的切分位置
        if(nums[left] < pivot) swap(nums, start, left);
        quickSort(nums, start, left - 1);
        quickSort(nums, left + 1, end);
    }

    public void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*------------------------------------------------------------------------------------------------*/
    /*第二种解决方法
    * 使用三个指针 第一个指针指向有序0元素的下一个位置 第三个指针指向有序2元素的前一个位置 第二个指针负责完成遍历
    * */
    public void sortColors_2(int[] nums) {
        // 边界情况
        if(nums == null || nums.length == 0) return;

        int i = -1, j = nums.length, k = 0;
        while(k < j) {
            while(nums[i + 1] == 0) i++;
            while(nums[j - 1] == 2) j--;
            k = i + 1;
            while(k < j && nums[k] == 1) k++;
            if(k < j) {
                if(nums[k] == 0) {
                    i++;
                    swap(nums, i, k);
                } else if(nums[k] == 2) {
                    j--;
                    swap(nums, j, k);
                }
            } else return;
        }
    }

}
