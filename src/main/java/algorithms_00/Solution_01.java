package algorithms_00;

import java.util.*;

/**
 * @author wheat
 * @date 2024/07/26  9:22
 */
public class Solution_01 {

    /**
     * nums中可能会有重复元素，不能先把所有数存入map，然后排序nums，利用双指针求解
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        // 维护 val -> index 的映射
        HashMap<Integer, Integer> valToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            // 查表，看看是否有能和 nums[i] 凑出 target 的元素
            int need = target - nums[i];
            if (valToIndex.containsKey(need)) {
                return new int[]{valToIndex.get(need), i};
            }
            // 存入 val -> index 的映射
            valToIndex.put(nums[i], i);
        }
        return null;
    }



}
