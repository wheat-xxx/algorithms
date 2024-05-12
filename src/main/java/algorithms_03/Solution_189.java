package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/14  17:06
 */
public class Solution_189 {

    public void rotate(int[] nums, int k) {
        // 边界情况
        if(k <= 0 || nums == null || nums.length == 0) return;

        // 如果 k > nums.length
        k = k % nums.length;

        int[] buffer = new int[k];

        for(int i = k - 1; i >= 0; i--) {
            buffer[i] = nums[nums.length - k + i];
        }

        for(int i = nums.length - 1; i >= k; i--) {
            nums[i] = nums[i - k];
        }

        for (int i = 0; i < k; i++) {
            nums[i] = buffer[i];
        }
    }

}
