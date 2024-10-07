package algorithms_10;

/**
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *      如果剩余字符少于 k 个，则将剩余字符全部反转。
 *      如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 *
 * @author wheat
 * @date 2024/07/26  20:08
 */
public class Solution_541 {

    public String reverseStr(String s, int k) {
        char[] chs = s.toCharArray();
        int i = 0, j = 2 * k - 1;
        while (j < chs.length) {
            reverseStr(chs, i, i + k - 1);
            i = j + 1;
            j += 2 * k;
        }

        if (i + k - 1 >= chs.length) {
            reverseStr(chs, i, chs.length - 1);
        } else {
            reverseStr(chs, i, i + k - 1);
        }

        return new String(chs);
    }

    private void reverseStr(char[] chs, int i, int j) {
        while (i < j) {
            char temp = chs[i];
            chs[i++] = chs[j];
            chs[j--] = temp;
        }
    }

    public static void main(String[] args) {
        new Solution_541().reverseStr("abcdefg", 2);
    }

}
