package algorithms_01;

/**
 * Description:
 *      给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。
 *      数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *      判断你是否能够到达最后一个下标。
 * @author wheat
 * @date 2023/03/07  9:10
 */
public class Solution_55 {

    public boolean canJump(int[] nums) {
        int border = 0;
        int max_position = 0;
        for(int i = 0; i < nums.length && i <= max_position; i++){
            if(i + nums[i] > max_position) max_position = i + nums[i];
        }
        if(max_position >= nums.length - 1) return true;
        else return false;
    }

}
