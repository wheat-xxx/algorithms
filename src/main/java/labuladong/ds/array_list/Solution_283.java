package labuladong.ds.array_list;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
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
