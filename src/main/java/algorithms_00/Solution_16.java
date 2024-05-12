package algorithms_00;

import java.util.Arrays;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/23  15:50
 */
public class Solution_16 {
    /**
     * 分析：
     *      三个数字之和最接近 target
     *      长度为n的数组，三个数相加的结果数C(3,n) 直接使用暴力搜索
     * @param nums
     * @param target
     * @return
     */
//    public int threeSumClosest(int[] nums, int target) {
//
//        // 边界条件
//        if(nums == null || nums.length < 3){
//            return target;
//        }
//
//        int ret = nums[0] + nums[1] + nums[2];
//        for (int i = 0; i < nums.length-2; i++) {
//            for(int j = i+1; j < nums.length - 1; j++){
//                for(int k = j + 1; k < nums.length ; k++){
//                    int others = nums[i] + nums[j] + nums[k];
//                    if(Math.abs(ret - target) > Math.abs(others - target)){
//                        ret = others;
//                    }
//                }
//            }
//        }
//        return ret;
//    }

    /**
     * 分析：
     * 三个数字可以固定一个数字，从而将问题分解为两个数字，在利用双指针进行解决 时间复杂度为n2
     *
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {

        // 边界条件
        if (nums == null || nums.length < 3) {
            return target;
        }

        Arrays.sort(nums);

        int ret = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int j = i + 1, k = nums.length - 1;
            // 与 abs(target - nums[i]) 比较
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                // 更新返回值
                if (Math.abs(target - ret) > Math.abs(target - sum)) {
                    ret = sum;
                }
                // 更新游标值
                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }


        return ret;
    }

}
