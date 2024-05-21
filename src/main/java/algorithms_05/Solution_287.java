package algorithms_05;

/**
 * 给定一个包含 n + 1 个整数的数组 nums ，其数字都在 [1, n] 范围内（包括 1 和 n），可知至少存在一个重复的整数。
 * 假设 nums 只有 一个重复的整数 ，返回 这个重复的数 。
 * 你设计的解决方案必须 不修改 数组 nums 且只用常量级 O(1) 的额外空间。
 *
 * @author wheat
 * @date 2024/05/14  9:18
 */
public class Solution_287 {

//    public int findDuplicate(int[] nums) {
//        int n = nums.length;
//        // 1 .... n - 1
//        int numsSum = 0;
//        for (int i = 0; i < nums.length; i++) {
//            numsSum += nums[i];
//        }
//        int sum = (1 + n - 1) * (n - 1) / 2;
//        return numsSum - sum;
//    }

    /**
     * 快慢指针法
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int low = 0, fast = 0;
        do {
            low = nums[low];
            fast = nums[nums[fast]];
        } while (low != fast);

        low = 0;
        while (low != fast) {
            low = nums[low];
            fast = nums[fast];
        }

        return low;
    }

}
