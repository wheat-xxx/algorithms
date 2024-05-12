package capriccio.array;

/**
 * 给定一个含有 n 个正整数的数组和一个正整数 s ，找出该数组中满足其和 ≥ s 的长度最小的 连续 子数组，并返回其长度。如果不存在符合条件的子数组，返回 0。
 * @author wheat
 * @date 2024/03/19  9:49
 */
public class Solution_209 {

    /**
     * 滑动窗口解法
     * 窗口初始大小要为0
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int leftIndex = 0, rightIndex = 0;
        int sum = 0;
        int result = nums.length + 1;
        while(rightIndex < nums.length) {
            sum += nums[rightIndex];
            if(sum >= target) {
                while(sum >= target) {
                    result = result < (rightIndex - leftIndex + 1) ? result : (rightIndex - leftIndex + 1);
                    sum -= nums[leftIndex++];
                }
            }
            rightIndex++;
        }
        return result == nums.length + 1 ? 0 : result;
    }



    public static void main(String[] args) {
        int[] nums = {2,3,1,2,4,3};
        Solution_209 obj = new Solution_209();
        obj.minSubArrayLen(7, nums);
    }

}
