package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/27  18:18
 */
public class Solution_32 {

    @Test
    public void test(){

    }

    /**
     * 动态规划
     * @param s
     * @return
     */
//    public int longestValidParentheses(String s) {
//
//        // 边界情况
//        if(s == null || s.length() == 0){
//            return 0;
//        }
//
//        // 动态规划 保存子问题的解
//        int[] res = new int[s.length()];
//
//        for(int i = 1; i < s.length(); i++){
//            // 有效括号序列不可能以‘(’结尾
//            if(s.charAt(i) == ')'){
//                if(s.charAt(i - 1) == '(') {
//                    res[i] = (i > 1 ? res[i-2] : 0) + 2;
//                }else if (s.charAt(i - 1) == ')'){
//                    if(i - res[i - 1] > 0 && s.charAt(i - res[i - 1] - 1) == '('){
//                        res[i] = (i - res[i - 1] - 2 >= 0 ? res[i - res[i - 1] - 2] : 0) + res[i - 1] + 2;
//                    }
//                }
//            }
//        }
//
//
//        int max = 0;
//        for(int i = 0; i < res.length; i++){
//            if(res[i] > max) max = res[i];
//        }
//        return max;
//    }

    /**
     * 利用栈寻找最大有效括号序列长度
     */


}
