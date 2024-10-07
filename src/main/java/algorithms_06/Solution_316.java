package algorithms_06;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.*;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @author wheat
 * @date 2024/07/11  11:30
 */
public class Solution_316 {

    /**
     * 问题的难点不在算法（动态规划这种），而是对问题的理解和剖析
     * @param s
     * @return
     */
    public String removeDuplicateLetters(String s) {
        Map<Character, Integer> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        // 逻辑巧妙
        for (int i = 0; i < s.length(); i++) {
            if (!stack.contains(s.charAt(i))) {
                while (!stack.isEmpty() && s.charAt(i) < stack.peek() && map.get(stack.peek()) > 0) {
                    stack.pop();
                }
                stack.push(s.charAt(i));
            }
            map.put(s.charAt(i), map.get(s.charAt(i)) - 1);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }

}
