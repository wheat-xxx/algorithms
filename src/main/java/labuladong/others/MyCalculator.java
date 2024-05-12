package labuladong.others;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 输入一个字符串，可以包含 + - * /、数字、括号以及空格。
 * 运算法则：括号的优先级最高，先乘除后加减。
 * 除号是整数除法，无论正负都向 0 取整（5/2=2，-5/2=-2）。
 * 可以假定输入的算式一定合法，且计算过程不会出现整型溢出，不会出现除数为 0 的意外情况。
 * @author wheat
 * @date 2024/05/09  20:50
 */
public class MyCalculator {

    public void test() {
        String s = "45678";
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            n = n * 10 + (s.charAt(i) - '0'); // (s.charAt(i) - '0') 的这个括号不能省略，否则可能造成整型溢出。
        }
    }

    /**
     * s是只包含+-数字的一个字符串
     * @param s
     */
    public int test_2(String s) {
        Stack<Integer> stack = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch >= '0' && ch <= '9') {
                num = num * 10 + (ch - '0');
            }
            // 如果不是数字，就是遇到了下一个符号，
            // 之前的数字和符号就要存进栈中
            if (!Character.isDigit(ch) || i == s.length() - 1) {
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    default:
                        throw new RuntimeException("输入表达式不合法！");
                }
                // 更新符号为当前符号，数字清零
                sign = ch;
                num = 0;
            }
        }

        // 将栈中所有结果求和就是答案
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    /**
     * s是只包含 + - * / 数字的一个字符串
     *
     * 乘除法优先于加减法体现在，乘除法可以和栈顶的数结合，而加减法只能把自己放入栈
     * @param s
     */
    public int test_3(String s) {
        Stack<Integer> stack = new Stack<>();
        // 记录算式中的数字
        int num = 0;
        // 记录 num 前的符号，初始化为 +
        char sign = '+';
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if (!Character.isDigit(ch) || i == s.length()) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    // 只要拿出前一个数字做对应运算即可
                    case '*':       // 不会出现 *-
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                    default:
                        throw new RuntimeException("输入表达式不合法！");
                }
                // 更新符号为当前符号，数字清零
                sign = ch;
                num = 0;
            }
        }

        // 将栈中所有结果求和就是答案
        int res = 0;
        while(!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }

    /**
     * 处理空格
     * @param s
     */
    public void test_4(String s) {
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if ((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1) {

            }
            // 或者多添加一条if语句
            if (ch == ' ') continue;
        }
    }

    /**
     * s是一个合法的运算表达式
     * s包括 + - * / ( ) \\s+
     * @param s
     * @return
     */
    public int calculate(String s) {
        Queue<Character> queue = new LinkedList<>();
        for (char c : s.toCharArray()) {
            queue.offer(c);
        }

        return helper(queue);
    }

    private int helper(Queue<Character> s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char sign = '+';

        while (!s.isEmpty()) {
            char ch = s.poll();
            if (ch == '(') {
                num = helper(s);
            }

            if (Character.isDigit(ch)) {
                num = num * 10 + (ch - '0');
            }
            if ((!Character.isDigit(ch) && ch != ' ') || s.isEmpty()) {
                int pre;
                switch (sign) {
                    case '+':
                        stack.push(num);
                        break;
                    case '-':
                        stack.push(-num);
                        break;
                    // 只要拿出前一个数字做对应运算即可
                    case '*':       // 不会出现 *-
                        pre = stack.pop();
                        stack.push(pre * num);
                        break;
                    case '/':
                        pre = stack.pop();
                        stack.push(pre / num);
                        break;
                    case '(':
                    case ')':
                        break;
                    default:
                        throw new RuntimeException("输入表达式不合法！");
                }
                // 更新符号为当前符号，数字清零
                sign = ch;
                num = 0;
            }

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
