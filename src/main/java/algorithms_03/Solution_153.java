package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/02  15:29
 */
public class Solution_153 {

    public int findMin(int[] nums) {
        // 判断是否仍是升序排列
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        /*
        * 数组经过旋转，分为两个升序序列，最小数在后一个升序序列
        * */
        int left = 0, right = nums.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return nums[left];
    }

}
