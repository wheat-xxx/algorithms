package labuladong.ds.array_list;

/**
 * 区域和检索-数组不可变
 * @author wheat
 * @date 2024/04/11  9:49
 */
public class Solution_303 {

//    /**
//     * 每次调用sumRange 都需要重新计算
//     */
//    private class NumArray {
//
//        private int[] nums;
//
//        public NumArray(int[] nums) {
//            this.nums = nums;
//        }
//
//        public int sumRange(int left, int right) {
//            int sum = 0;
//            for (int i = left; i <= right; i++) {
//                sum += nums[i];
//            }
//            return sum;
//        }
//    }

    /**
     * 保存每个位置的前面所有元素的和
     */
    private class NumArray {

        // 前缀和数组
        private int[] preSum;

        public NumArray(int[] nums) {
            int len = nums.length;
            this.preSum = new int[len];
            preSum[0] = nums[0];
            for (int i = 1; i < len; i++) {
                preSum[i] = preSum[i - 1] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) return preSum[right];
            else return preSum[right] - preSum[left - 1];
        }
    }

}
