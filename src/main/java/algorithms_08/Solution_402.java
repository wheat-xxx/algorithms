package algorithms_08;

import java.util.Stack;

/**
 *
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。请你以字符串形式返回这个最小的数字。
 *
 * @author wheat
 * @date 2024/07/11  11:38
 */
public class Solution_402 {

    /**
     * 难点在理解问题上
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        Stack<Character> stack = new Stack<>();
        int len = num.length() - k;
        for (char c : num.toCharArray()) {
            while (k > 0 && !stack.isEmpty() && stack.peek() > c) {
                stack.pop();
                k--;
            }
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        String res = sb.reverse().substring(0, len);
        int left = 0;
        while (left < res.length() && res.charAt(left) == '0') {
            left++;
        }
        res = res.substring(left);
        return res == "" ? "0" : res;
    }


}
