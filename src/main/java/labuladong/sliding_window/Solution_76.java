package labuladong.sliding_window;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @author wheat
 * @date 2024/03/25  8:24
 */
public class Solution_76 {

    /**
     * left = right = 0 [) 这样初始化窗口初始没有元素
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        String res = "";
        int minLength = Integer.MAX_VALUE;

        // 保存t中所有出现的字符
        Map<Character, Integer> tMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        // 保存窗口内出现的有效字符
        Map<Character, Integer> window = new HashMap<>();

        // 滑动窗口算法
        int left = 0, right = 0;
        while (right < s.length()) {
            if (tMap.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
            }
            right++;

            while (left < right && isValid(window, tMap)) {
                if ((right - left) < minLength) {
                    minLength = right - left;
                    res = s.substring(left, right);
                }
                if (window.getOrDefault(s.charAt(left), 0) > 0) {
                    window.put(s.charAt(left), window.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }
        }
        return res;
    }

    private boolean isValid(Map<Character, Integer> window, Map<Character, Integer> tMap) {
        Set<Map.Entry<Character, Integer>> entries = tMap.entrySet();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if (window.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    public String minWindow_2(String s, String t) {
        // 记录最小覆盖子串的起始索引及长度
        int start = -1;
        int minLength = Integer.MAX_VALUE;
        int valid = 0;

        // 统计t中字符出现情况
        Map<Character, Integer> tMap = new HashMap<>();
        for(char ch : t.toCharArray()) tMap.put(ch, tMap.getOrDefault(ch, 0) + 1);
        // 窗口
        Map<Character, Integer> window = new HashMap<>();

        int left = 0, right = 0;    // [)
        while(right < s.length()) {
            // ch 是将移入窗口的字符
            char ch = s.charAt(right);
            // 进行窗口内数据的一系列更新
            if (tMap.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(tMap.get(ch))) {
                    valid++;
                }
            }
            // 扩大窗口
            right++;

            // TODO: debug 运行成功之后可以注释掉
            System.out.println(s.substring(left, right));

            // 判断左侧窗口是否要收缩
            while(left < right && valid == tMap.size()) {
                // 在这里更新最小覆盖子串
                if ((right - left) < minLength) {
                    start = left;
                    minLength = right - left;
                }

                // ch2 是将移出窗口的字符
                char ch2 = s.charAt(left);
                // 进行窗口内数据的一系列更新
                if (tMap.containsKey(ch2)) {
                    if (window.get(ch2).equals(tMap.get(ch2))) {
                        valid--;
                    }
                    window.put(ch2, window.get(ch2) - 1);
                }
                left++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        new Solution_76().minWindow_2(s, t);
    }

}
