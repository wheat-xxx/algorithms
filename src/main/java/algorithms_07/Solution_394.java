package algorithms_07;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * @author wheat
 * @date 2024/05/23  20:19
 */
public class Solution_394 {

    private int index = 0;

    /**
     * 递归求解
     * @param s
     * @return
     */
    public String decodeString(String s) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (index < s.length()) {
            if (Character.isLowerCase(s.charAt(index))) {
                sb.append(s.charAt(index));
                index++;
            } else if (Character.isDigit(s.charAt(index))) {
                count = count * 10 + s.charAt(index) - '0';
                index++;
                if (s.charAt(index) == '[') {
                    index++;
                    String subProblem = decodeString(s);
                    for (int i = 0; i < count; i++) {
                        sb.append(subProblem);
                    }
                    count = 0;
                }
            } else if (s.charAt(index) == ']') {
                index++;
                return sb.toString();
            } else {
                throw new RuntimeException("传入参数非法！");
            }
        }

        return sb.toString();
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 用栈求解
     * @param s
     * @return
     */
    public String decodeString_2(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> counts = new Stack<>();
        int index = 0;
        int count = 0;
        while (index < s.length()) {
            if (s.charAt(index) >= 'a' && s.charAt(index) <= 'z' || s.charAt(index) == '[') {
                stack.push(s.charAt(index));
                index++;
            } else if (s.charAt(index) >= '0' && s.charAt(index) <= '9') {
                count = count * 10 + s.charAt(index) - '0';
                index++;
                if (s.charAt(index) == '[') {
                    counts.push(count);
                    count = 0;
                }
            } else if (s.charAt(index) == ']') {
                StringBuilder sb = new StringBuilder();
                while (stack.peek() != '[') {
                    sb.append(stack.pop());
                }
                stack.pop();
                String s_temp = sb.reverse().toString();
                int count_temp = counts.pop();
                for (int i = 0; i < count_temp - 1; i++) {
                    sb.append(s_temp);
                }
                for (int i = 0; i < sb.length(); i++) {
                    stack.push(sb.charAt(i));
                }
                index++;
            } else {
                throw new RuntimeException("请求参数非法！");
            }
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

}
