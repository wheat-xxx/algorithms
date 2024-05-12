package capriccio.array;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * @author wheat
 * @date 2024/03/18  22:10
 */
public class Solution_283 {

    /**
     * 双指针法 夹逼定理
     * 解法错误：没有保证相对顺序
     * @param nums
     */
    public void moveZeroes(int[] nums) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        while(leftIndex < rightIndex) {
            while(leftIndex < rightIndex && nums[leftIndex] != 0) {
                leftIndex++;
            }
            while(leftIndex < rightIndex && nums[rightIndex] == 0) {
                rightIndex--;
            }
            swap(nums, leftIndex, rightIndex);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 双指针法 快慢指针
     * @param nums
     */
    public void moveZeroes_2(int[] nums) {
        int slowIndex = -1, fastIndex = 0;
        while(fastIndex < nums.length) {
            if(nums[fastIndex] != 0) {
                nums[++slowIndex] = nums[fastIndex];
            }
            fastIndex++;
        }
        for (int i = slowIndex + 1; i < nums.length; i++) {
            nums[i] = 0;
        }
    }

}
