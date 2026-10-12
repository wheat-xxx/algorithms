package algorithms_04;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * 给你一个字符串表达式 s ，请你实现一个基本计算器来计算并返回它的值。
 *
 * @Author: wheat
 * @Date: 2026/10/12 16:01
 * @Version: v1.0.0
 **/
public class Solution_224 {

    /**
     * s是一个合法的运算表达式
     * s包括 + - * / ( ) \\s+
     * @param s
     * @return
     */
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();

        for (char c : s.toCharArray()) {
            if (c != ' ') {
                queue.offer(c);
            }
        }

        return helper(queue);
    }

    private int helper(Queue<Character> queue) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        char sign = '+';
        while (!queue.isEmpty()) {
            char ch = queue.poll();
            // 数字
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }

            // '(' 递归计算括号内的值
            if (ch == '(') {
                num = helper(queue);
            }

            if (!Character.isDigit(ch) || queue.isEmpty()) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    case '*':
                        stack.push(stack.pop() * num);
                        break;
                    case '/':
                        stack.push(stack.pop() / num);
                        break;
                    default:
                        break;
                }
                sign = ch;
                num = 0;
            }

            // ')' 当前递归结束
            if (ch == ')') {
                int res = 0;
                for (Integer val : stack) {
                    res += val;
                }
                return res;
            }
        }

        int res = 0;
        for (Integer val : stack) {
            res += val;
        }
        return res;
    }

}
