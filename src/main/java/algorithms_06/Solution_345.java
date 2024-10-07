package algorithms_06;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 给你一个字符串 s ，仅反转字符串中的所有元音字母，并返回结果字符串。
 * 元音字母包括 'a'、'e'、'i'、'o'、'u'，且可能以大小写两种形式出现不止一次。
 *
 * @author wheat
 * @date 2024/07/11  11:01
 */
public class Solution_345 {

    public String reverseVowels(String s) {
        // 边界情况
        if (s == null || s.length() < 2) return s;

        char[] chs = s.toCharArray();

        Set<Character> set = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !set.contains(s.charAt(left))) {
                left++;
            }
            while (left < right && !set.contains(s.charAt(right))) {
                right--;
            }

            char temp = chs[left];
            chs[left] = chs[right];
            chs[right] = temp;
            left++;
            right--;
        }

        return String.valueOf(chs);
    }

}
