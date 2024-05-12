package labuladong.others;

import java.util.Stack;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * 有效字符串需满足：
 *   左括号必须用相同类型的右括号闭合。
 *   左括号必须以正确的顺序闭合。
 *   每个右括号都有一个对应的相同类型的左括号。
 *
 * @author wheat
 * @date 2024/05/10  11:32
 */
public class Solution_20 {

    /**
     * 栈
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char temp = stack.pop();
                if (!((ch == ')' && temp == '(') || (ch == '}' && temp == '{') || (ch == ']' && temp == '['))) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

}
