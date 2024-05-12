package labuladong.double_ptr_array;

/**
 * @author wheat
 * @date 2024/03/20  22:07
 */
public class Solution_283 {

    /**
     * slow指向已确定数组的下一个位置
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int slow = 0, fast = 0;
        int length = nums.length;
        while(fast < length) {
            if(nums[fast] != 0) {
                nums[slow++] = nums[fast];
            }
            fast++;
        }

        // 其余元素全部赋值为0
        for(int i = slow; i < length; i++) {
            nums[i] = 0;
        }
    }

}
