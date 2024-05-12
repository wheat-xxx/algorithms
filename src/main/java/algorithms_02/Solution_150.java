package algorithms_02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

/**
 * @author wheat
 * @date 2023/10/09  9:58
 */
public class Solution_150 {

    public int evalRPN(String[] tokens) {
        if(tokens == null || tokens.length == 0) return 0;

        Deque<Integer> stack = new LinkedList<Integer>();

        for(String elem : tokens) {
            if (isNumeric(elem)) {
                stack.push(Integer.parseInt(elem));
            } else {
                int operator2 = stack.pop();
                int operator1 = stack.pop();
                int result;
                switch (elem) {
                    case "+":
                        result = operator1 + operator2;
                        break;
                    case "-":
                        result = operator1 - operator2;
                        break;
                    case "*":
                        result = operator1 * operator2;
                        break;
                    case "/":
                        result = operator1 / operator2;
                        break;
                    default:
                        throw new RuntimeException("运算符不是+-*/中的某一个~");
                }
                stack.push(result);
            }
        }

        return stack.peek();
    }

    public static boolean isInteger(String data){
        try {
            Integer.parseInt(data);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?"); // 匹配整数或浮点数
    }

}
