package algorithms_01;

import java.util.Arrays;

/**
 * Description:
 *      给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * @author wheat
 * @date 2023/03/06  22:26
 */
public class Solution_53 {

    /**
     * 分析：
     *      利用动态规划进行求解
     * @param nums
     * @return
     */

    public int maxSubArray(int[] nums) {
        // 利用一个数组保存子问题的解
        int[] res = new int[nums.length];

        for(int i = 0; i < nums.length; i++){
            if(i == 0) res[i] = nums[i];
            else{
                res[i] = res[i - 1] > 0 ? (res[i - 1] + nums[i]) : nums[i];
            }
        }

        int max = res[0];
        for(int i = 0; i < res.length; i++){
            if(res[i] > max) max = res[i];
        }

        return max;
    }

    
}
