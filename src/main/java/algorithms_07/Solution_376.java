package algorithms_07;

/**
 * 摆动序列
 * @author wheat
 * @date 2024/07/15  15:08
 */
public class Solution_376 {

    /**
     * 贪心算法 - 连着增或者连着降 选择最后一个元素
     * 我是真的牛逼
     * @param nums
     * @return
     */
    public int wiggleMaxLength(int[] nums) {
        // 边界情况
        if (nums.length == 1) {
            return 1;
        }
        if (nums.length == 2 && nums[0] == nums[1]) {
            return 1;
        }

        int count = 1;
        int left = 0, right = 1;
        while (right < nums.length) {
            while (right < nums.length && nums[right] == nums[left]) {
                right++;
            }
            if (right < nums.length && nums[right] > nums[left]) {
                while (right < nums.length && nums[right] >= nums[right - 1]) {
                    right++;
                }
                count++;
                left = right - 1;
            } else if (right < nums.length && nums[right] < nums[left]) {
                while (right < nums.length && nums[right] <= nums[right - 1]) {
                    right++;
                }
                count++;
                left = right - 1;
            }
        }

        return count;
    }

}
