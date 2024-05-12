package labuladong.sliding_window;

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

}
