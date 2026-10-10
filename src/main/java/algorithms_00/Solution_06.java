package algorithms_00;

/**
 *
 * 6. Z 字形变换
 *
 * @Author: wheat
 * @Date: 2026/10/9 17:33
 * @Version: v1.0.0
 **/
public class Solution_06 {

    public String convert(String s, int numRows) {
        // 只有一行，或行数大于等于字符串长度时，直接返回原字符串
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        // 每一行用一个 StringBuilder 保存字符
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows[curRow].append(c);

            // 到达第一行或最后一行时，改变方向
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }

            curRow += goingDown ? 1 : -1;
        }

        // 按行拼接结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }

}
