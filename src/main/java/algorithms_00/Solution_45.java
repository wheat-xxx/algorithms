package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *      跳跃游戏 II
 * @author wheat
 * @date 2023/03/05  10:59
 */
public class Solution_45 {

//    private int minJump;
//
//    /**
//     * 问题分析：
//     *      可以利用决策树进行处理
//     * @param nums
//     * @return
//     */
//    public int jump(int[] nums) {
//
//        // 边界检查
//        if(nums == null || nums.length == 0) return 0;
//
//        minJump = nums.length - 1;
//
//        //使用递归进行处理
//        dfs(nums, 0, 0);
//
//        return minJump;
//    }
//
//    public void dfs(int[] nums, int index, int count){
//        // 递归结束条件
//        if(index >= nums.length - 1){
//            if(count < minJump) minJump = count;
//            return;
//        }
//
//        // 递推关系
//        // 如果 nums[index]=0需要进行特殊处理
//        for(int i = 1; i <= nums[index]; i++){
//            if(index + i < nums.length) {
//                if (i + nums[index + i] >= nums[index]) {
//                    dfs(nums, index + i, count + 1);
//                }
//            }else{
//                if(count + 1< minJump) minJump = count + 1;
//                return;
//            }
//        }
//
//    }


    public int jump(int[] nums) {
        // 边界检验
        if(nums == null ||nums.length == 0) return 0;

        int border = 0;
        int maxPosition = 0;
        int steps = 0;
        for(int i = 0; i < nums.length-1; i++){
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if(i == border){
                border = maxPosition;
                steps++;
            }
        }
        return steps;
    }





    @Test
    public void test(){
        int[] nums = {9,7,9,4,8,1,6,1,5,6,2,1,7,9,0};
        int ret = jump(nums);
    }

}
