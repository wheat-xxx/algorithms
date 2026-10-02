package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *      跳跃游戏 II
 * @author wheat
 * @date 2023/03/05  10:59
 */
public class Solution_45 {

    /**
     * 贪心算法
     * @param nums
     * @return
     */
    public int jump(int[] nums) {
        int preMaxPosition = 0;
        int maxPosition = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            if (preMaxPosition >= nums.length - 1) return res;
            maxPosition = Math.max(maxPosition, i + nums[i]);
            if (i == preMaxPosition) {
                res++;
                preMaxPosition = maxPosition;
            }
        }

        return res;
    }

    @Test
    public void test(){
        int[] nums = {9,7,9,4,8,1,6,1,5,6,2,1,7,9,0};
        int ret = jump(nums);
    }

}
