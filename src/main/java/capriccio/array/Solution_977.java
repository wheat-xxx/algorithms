package capriccio.array;

/**
 * @author wheat
 * @date 2024/03/19  9:12
 */
public class Solution_977 {

    /**
     * 双指针遍历数组
     * @param nums
     * @return
     */
    public int[] sortedSquares(int[] nums) {
        // 求平方
        for (int i = 0; i < nums.length; i++) {
            nums[i] = nums[i] * nums[i];
        }

        // 寻找平方之后的最小值
        int minIndex = 0;
        while(minIndex < nums.length - 1 && nums[minIndex] >= nums[minIndex + 1]) {
            minIndex++;
        }

        int leftIndex = minIndex, rightIndex = minIndex + 1;
        int[] res = new int[nums.length];
        int i = 0;
        while(leftIndex >= 0 && rightIndex < nums.length) {
            if(nums[leftIndex] < nums[rightIndex]) {
                res[i++] = nums[leftIndex--];
            } else {
                res[i++] = nums[rightIndex++];
            }
        }

        // 处理剩余数字
        while(leftIndex >= 0) {
            res[i++] = nums[leftIndex--];
        }
        while(rightIndex < nums.length) {
            res[i++] = nums[rightIndex++];
        }
        return res;
    }

    /**
     * 做题一定要有反向思维
     * 不一定先要从最小的开始找起
     * @param nums
     * @return
     */
    public int[] sortedSquares_2(int[] nums) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        int[] res = new int[nums.length];
        int i = nums.length - 1;
        while(leftIndex <= rightIndex) {
            if (nums[leftIndex] * nums[leftIndex] > nums[rightIndex] * nums[rightIndex]) {
                res[i--] = nums[leftIndex] * nums[leftIndex];
                leftIndex++;
            } else {
                res[i--] = nums[rightIndex] * nums[rightIndex];
                rightIndex--;
            }
        }
        return res;
    }

}
