package algorithms_02;

import java.util.Arrays;

/**
 * 只出现一次的数字
 * @author wheat
 * @date 2023/09/01  15:55
 */
public class Solution_136 {

    public int singleNumber(int[] nums) {
        int res = 0;
        for(int i = 0; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }

    public int singleNumber_2(int[] nums) {
        return Arrays.stream(nums).reduce((a, b) -> a ^ b).getAsInt();
    }

}
