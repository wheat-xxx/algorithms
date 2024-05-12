package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/04  20:02
 */
public class Solution_162 {

    /**
     * 找极值-极大值
     * @param nums
     * @return 返回极值的索引
     */
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        if(nums.length == 1) return 0;

        // 先判断左右两端的元素
        if(nums[0] > nums[1]) return 0;
        if(nums[nums.length - 1] > nums[nums.length - 2]) return nums.length - 1;

        // 峰值元素出现在中间
        for (int i = 1; i < nums.length - 1; i++) {
            if(nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) return i;
        }

        return -1;
    }

}
