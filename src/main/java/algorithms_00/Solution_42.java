package algorithms_00;

import org.junit.Test;

import java.util.Stack;

/**
 * Description:
 *
 *      给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 *
 * @author wheat
 * @date 2023/03/02  14:38
 */
public class Solution_42 {


    /**
     * 超出时间限制
     */
//    public int trap(int[] height){
//        // 边界检查
//        if(height == null || height.length == 0) return 0;
//
//        // 保存最终结果和中间结果
//        int res = 0;
//        int height_max = getMax(height);
//
//        // 逐层遍历
//        for(int i = 1; i <= height_max; i++){
//
//            boolean start = false;
//            int others = 0;
//            for(int j = 0; j < height.length; j++){
//                // 寻找积水的起始位置
//                if(start == false && height[j] >= i){
//                    start = true;
//                }
//
//                // 计算两个柱子间的积水
//                if(start == true && height[j] < i){
//                    others++;
//                }
//                if(start == true && height[j] >= i){
//                    res += others;
//                    others = 0;
//                }
//            }
//
//        }
//        return res;
//
//    }
//
//    public int getMax(int[] height){
//        int max = 0;
//        for(int i = 0; i < height.length; i++){
//            if(max < height[i]) max = height[i];
//        }
//        return max;
//    }


    /**
     * 动态规划
     * @param height
     * @return
     */
//    public int trap(int[] height){
//
//        // 边界检查
//        if(height == null || height.length == 0) return 0;
//
//        // 保存中间结果和最终结果
//        int res = 0;
//
//        // 利用数组保存当前列两边墙的最高高度
//        int[] max_left = new int[height.length];
//        int[] max_right = new int[height.length];
//
//        for(int i = 1; i < height.length - 1; i++){
//            max_left[i] = (max_left[i-1] > height[i-1]) ? max_left[i-1] : height[i-1];
//            max_right[height.length -1-i] = (max_right[height.length-i] > height[height.length-i]) ? max_right[height.length-i] : height[height.length-i];
//        }
//
//        for(int i = 1; i < height.length - 1; i++){
//            int min = (max_left[i] < max_right[i]) ? max_left[i] : max_right[i];
//            if(min > height[i]) res += min - height[i];
//        }
//
//        return res;
//    }


//    public int trap(int[] height){
//
//        // 边界情况
//        if(height == null || height.length < 3) return 0;
//
//        // 保存最终结果和中间变量
//        int res = 0;
//        int max_left = 0;
//        int max_right = 0;
//        int left = 1;
//        int right = height.length - 2;
//
//        for(int i = 1; i < height.length - 1; i++){
//            // 从左往右
//            if(height[left - 1] < height[right + 1]){
//                max_left = Math.max(max_left, height[left - 1]);
//                if(max_left > height[left]) res += max_left - height[left];
//                left++;
//            }else{      // 从右往左
//                max_right = Math.max(max_right, height[right + 1]);
//                if(max_right > height[right]) res += max_right - height[right];
//                right--;
//            }
//        }
//        return res;
//    }


    public int trap(int[] height){
        // 边界检查
        if(height == null || height.length <= 2) return 0;

        // 保存中间变量和结果
        int res = 0;
        Stack<Integer> stack = new Stack<Integer>();

        for(int i = 0; i < height.length; i++){
            while(!stack.isEmpty() && height[i] > height[stack.peek()]){
                int h = height[stack.pop()];
                if(stack.isEmpty()){
                    break;
                }
                int distance = i - stack.peek() - 1;
                int min = Math.min(height[stack.peek()], height[i]);
                res += distance * (min - h);
            }
            stack.push(i);
        }
        return res;
    }


    @Test
    public void test(){
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        trap(height);
    }

}
