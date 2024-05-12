package algorithms_00;

import java.util.Stack;

/**
 * Description:
 *
 *      括号匹配的问题
 *      需要借助栈来实现
 *
 * @author wheat
 * @date 2023/02/23  16:57
 */
public class Solution_20 {

    public boolean isValid(String s) {
        // 边界情况
        if(s == null || s.length() == 0) return true;

        // 奇数个字符不可能匹配
        if(s.length() % 2 == 1) return false;

        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            switch(s.charAt(i)){
                case '(':
                    stack.add('(');
                    break;
                case ')':
                    if (!stack.isEmpty() && stack.peek() == '('){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '[':
                    stack.add('[');
                    break;
                case ']':
                    if (!stack.isEmpty() && stack.peek() == '['){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                case '{':
                    stack.add('{');
                    break;
                case '}':
                    if (!stack.isEmpty() && stack.peek() == '{'){
                        stack.pop();
                    }else{
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }

        if(stack.isEmpty()){
            return true;
        }else{
            return false;
        }

    }

}
