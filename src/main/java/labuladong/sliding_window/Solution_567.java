package labuladong.sliding_window;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。
 * @author wheat
 * @date 2024/03/25  21:27
 */
public class Solution_567 {

    public boolean checkInclusion(String s1, String s2) {
        // 边界情况
        if (s2.length() < s1.length()) return false;

        // 统计s1包含字符情况
        Map<Character, Integer> s1Map = new HashMap<>();
        for(char ch : s1.toCharArray()) s1Map.put(ch, s1Map.getOrDefault(ch, 0) + 1);

        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = left + s1.length() - 1;   // []
        int valid = 0;
        for (int i = left; i <= right; i++) {
            if (s1Map.containsKey(s2.charAt(i))) {
                window.put(s2.charAt(i), window.getOrDefault(s2.charAt(i), 0) + 1);
                if (window.get(s2.charAt(i)).equals(s1Map.get(s2.charAt(i)))) {
                    valid++;
                }
            }
        }

        while (right < s2.length()) {
            System.out.println(s2.substring(left, right + 1));
            if (valid == s1Map.size()) return true;

            if (s1Map.containsKey(s2.charAt(left))) {
                if (window.get(s2.charAt(left)).equals(s1Map.get(s2.charAt(left)))) {
                    valid--;
                }
                window.put(s2.charAt(left), window.get(s2.charAt(left)) - 1);
            }
            left++;
            right++;
            if (right < s2.length() && s1Map.containsKey(s2.charAt(right))) {
                window.put(s2.charAt(right), window.getOrDefault(s2.charAt(right), 0) + 1);
                if (window.get(s2.charAt(right)).equals(s1Map.get(s2.charAt(right)))) {
                    valid++;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        new Solution_567().checkInclusion("hello", "ooolleoooleh");
    }

}
