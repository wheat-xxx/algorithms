package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/02  15:54
 */
public class Solution_154 {

    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            if(nums[mid] < nums[right]) {
                right = mid;
            }else if (nums[mid] > nums[right]) {
                left = mid + 1;
            }else {
                right -= 1;
            }
        }
        return nums[left];
    }

}
