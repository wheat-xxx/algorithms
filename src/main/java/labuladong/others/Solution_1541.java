package labuladong.others;

/**
 * 给你一个括号字符串 s ，它只包含字符 '(' 和 ')' 。一个括号字符串被称为平衡的当它满足：
 * 任何左括号 '(' 必须对应两个连续的右括号 '))' 。
 * 左括号 '(' 必须在对应的连续两个右括号 '))' 之前。
 *
 * 你可以在任意位置插入字符 '(' 和 ')' 使字符串平衡。
 * 请你返回让 s 平衡的最少插入次数。
 *
 * @author wheat
 * @date 2024/05/10  15:24
 */
public class Solution_1541 {

    /**
     * 将两个')'看作一个整体
     * @param s
     * @return
     */
    public int minInsertions(String s) {
        int res = 0;
        int leftCount = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(') {
                leftCount++;
            }

            if (ch == ')') {
                if (i == s.length() - 1) {
                    res++;
                    if (leftCount > 0) leftCount--;
                    else res++;
                } else if (s.charAt(i + 1) == ')') {
                    if (leftCount > 0) leftCount--;
                    else res++;
                    i++;
                } else if (s.charAt(i + 1) == '(') {
                    res++;
                    if (leftCount > 0) leftCount--;
                    else res++;
                }
            }
        }

        return res + leftCount * 2;
    }

    /**
     * 代码优化
     * @param s
     * @return
     */
    public int minInsertions_2(String s) {
        int res = 0, need = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                need += 2;
                if (need % 2 != 0) {
                    res++;
                    need--;
                }
            }

            if (ch == ')') {
                if (need > 0) {
                    need--;
                } else {
                    res++;
                    need++;
                }
            }
        }

        return res + need;
    }

}
