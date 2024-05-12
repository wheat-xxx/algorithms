package labuladong.others;

/**
 * 使括号有效的最少添加
 * @author wheat
 * @date 2024/05/10  15:15
 */
public class Solution_921 {

    /**
     * 返回 为使结果字符串 s 有效而必须添加的最少括号数
     * @param s
     * @return
     */
    public int minAddToMakeValid(String s) {
        int res = 0;
        // 记录右括号数量
        int rightCount = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char ch = s.charAt(i);
            if (ch == '(') {
                if (rightCount > 0) rightCount--;
                else res++;
            }
            if (ch == ')') {
                rightCount++;
            }
        }

        return res + rightCount;
    }

}
