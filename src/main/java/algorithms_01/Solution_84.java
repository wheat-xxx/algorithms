package algorithms_01;

import org.junit.Test;

import java.util.Arrays;
import java.util.Stack;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/14  15:06
 */
public class Solution_84 {

//    /**
//     * 分析：
//     *      第一种方法 一行一行进行处理
//     * @param heights
//     * @return
//     */
//    public int largestRectangleArea(int[] heights) {
//        if(heights == null) return 0;
//
//        int maxHeight = -1;
//        for(int i = 0; i < heights.length; i++)
//            if(heights[i] > maxHeight) maxHeight = heights[i];
//
//        int maxArea = 0;
//        for(int i = 1; i <= maxHeight; i++){
//            // 寻找最长连续宽度
//            int maxWidth = 0;
//            int left = 0, right = 0;
//            while(right < heights.length){
//                while(right < heights.length && heights[right] >= i) right++;
//
//                if(left == right && heights[left] < i){
//
//                }else{
//                    maxWidth = maxWidth < (right - left) ? (right - left) : maxWidth;
//                    maxArea = maxArea < maxWidth*i ? maxWidth * i : maxArea;
//                }
//
//                left = ++right;
//            }
//
//        }
//        return maxArea;
//    }

//    /**
//     * 按列进行遍历
//     * @param heights
//     * @return
//     */
//    public int largestRectangleArea(int[] heights){
//
//        if(heights == null) return 0;
//
//        int maxArea = 0;
//        int left = 0, right = 0;
//        while(right < heights.length){
//            // 寻找最大宽度
//            while(right < heights.length && heights[left] >= heights[right]) right++;
//
//            maxArea = maxArea < (right - left) * heights[left] ? (right - left) * heights[left] : maxArea;
//
//            // 数据更新
//            right = ++left;
//        }
//        return maxArea;
//    }

    public int largestRectangleArea(int[] heights){

        if(heights == null) return 0;

        Stack<Integer> stack = new Stack<>();

        int resArea = 0;

        int[] arr = new int[heights.length + 2];
        for(int i = 0; i < heights.length; i++){
            arr[i + 1] = heights[i];
        }

        stack.push(0);
        for(int i = 1; i < arr.length; i++){
            // 当前柱形高度严格小于栈顶元素 则计算面积
            while(arr[i] < arr[stack.peek()]){
                int area = arr[stack.pop()] * (i - stack.peek() - 1);
                resArea = resArea < area ? area : resArea;
            }

            // 更新数据
            stack.push(i);
        }
        return resArea;
    }

    @Test
    public void test(){
        int[] heights = {2,1,5,6,2,3};

        int res = largestRectangleArea(heights);

    }

}
