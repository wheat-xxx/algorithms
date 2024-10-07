package labuladong.sliding_window;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串的长度
 * @author wheat
 * @date 2024/03/26  9:13
 */
public class Solution_3 {

    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int[] window = new int[128];
        int invalid = 0;

        int left = 0, right = 0;    // [)
        while (right < s.length()) {
            if (window[s.charAt(right)] == 1) {
                invalid++;
            }
            window[s.charAt(right)]++;
            right++;

            while (left < right && invalid > 0) {
                if (window[s.charAt(left)] == 2) {
                    invalid--;
                }
                window[s.charAt(left)]--;
                left++;
            }
            // 更新返回结果
            if (right - left> res) {
                res = right - left;
            }
        }
        System.out.println(s.substring(left, right));
        return res;
    }

    /**
     * map：由于窗口内的元素最多有一个，set可以替代map
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring_2(String s) {
        if (s == null || s.length() == 0) return 0;

        Set<Character> window = new HashSet<>();
        int left = 0;
        int res = 0;
        for (int right = 0; right < s.length(); right++) {
            char ch = s.charAt(right);
            if (!window.contains(ch)) {
                window.add(ch);
                continue;
            }

            res = Math.max(res, right - left);
            while (left < right && window.contains(ch)) {
                window.remove(s.charAt(left++));
            }
            window.add(ch);
        }
        res = Math.max(res, s.length() - left);
        return res;
    }

}
