package labuladong.ds.array_list;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 * @author wheat
 * @date 2024/03/21  7:55
 */
public class Solution_5 {

    /**
     * 解决该问题的核心是从中心向两端扩散的双指针技巧。
     * 如果回文串的长度为奇数，则它有一个中心字符；如果回文串的长度为偶数，则可以认为它有两个中心字符
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        String res = "";
        int length = s.length();
        for (int i = 0; i < length; i++) {
            // 以 s[i] 为中心的最长回文子串
            String temp = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String temp2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            temp = temp.length() > temp2.length() ? temp : temp2;
            res = res.length() > temp.length() ? res : temp;
        }
        return res;
    }

    /**
     * 以某个字符为中心向两边扩散 寻找回文串
     * 这样，如果输入相同的 l 和 r，就相当于寻找长度为奇数的回文串，如果输入相邻的 l 和 r，则相当于寻找长度为偶数的回文串
     * @param s
     * @param left
     * @param right
     * @return
     */
    private String palindrome(String s, int left, int right) {
        int length = s.length();
        while(left >= 0 && right < length) {
            if(s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);    // 如果没有一次相等，奇数返回中心字符，偶数返回空串
    }

    public static void main(String[] args) {
        String s = "hello";
        String t = s.substring(0, 0);  // t = ""
    }

}
