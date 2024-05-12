package algorithms_03;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wheat
 * @date 2023/12/01  16:47
 */
public class Solution_151 {

    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

    public String reverseWords_2(String s) {
        StringBuilder sb = trimSpaces(s);

        // 翻转字符串
        reverse(sb, 0, sb.length() - 1);

        // 翻转每个单词
        reverseEachWord(sb);

        return sb.toString();
    }

    private StringBuilder trimSpaces(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while(left <= right && s.charAt(left) == ' ') left++;
        // 去掉字符串末尾的空白字符
        while(left <= right && s.charAt(right) == ' ') right--;
        // 将字符串间多余的空白字符去除
        StringBuilder sb = new StringBuilder();
        while(left <= right) {
            char ch = s.charAt(left);

            if(ch != ' ') {
                sb.append(ch);
            } else if (s.charAt(s.length() - 1) != ' ') {
                sb.append(' ');
            }

            left++;
        }
        return sb;
    }

    private void reverseEachWord(StringBuilder sb) {
        int n = sb.length();
        int start = 0, end = 0;

        while(end < n) {
            // 循环至单词的末尾
            while(end < n && sb.charAt(end) != ' ') end++;

            // 翻转单词
            reverse(sb, start, end-1);

            // 更新start，去找下一个单词
            start = end + 1;
            ++end;
        }
    }

    private void reverse(StringBuilder sb, int left, int right) {
        while(left < right) {
            char temp = sb.charAt(left);
            sb.setCharAt(left, sb.charAt(right));
            sb.setCharAt(right, sb.charAt(left));
            left++; right--;
        }
    }

}
