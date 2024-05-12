package labuladong.others;

/**
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * 1 <= num1.length, num2.length <= 200
 * @author wheat
 * @date 2024/05/08  15:07
 */
public class Solution_43 {

    /**
     * 小学学的乘法公式
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        // 结果最多为 m + n 位数
        int[] res = new int[m + n];
        // 从个位数开始逐位相乘
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 乘积在 res 对应的索引位置
                int p = i + j + 1;
                // 叠加到res上
                int sum = mul + res[p];
                res[p] = sum % 10;
                res[p - 1] += sum / 10;
            }
        }

        // 结果前缀可能存的 0（未使用的位）
        int i = 0;
        for (i = 0; i < res.length && res[i] == 0; i++);
        // 将计算结果转化成字符串
        StringBuilder sb = new StringBuilder();
        for (; i < m + n; i++) {
            sb.append(res[i]);
        }

        return sb.toString().length() == 0 ? "0" : sb.toString();
    }

}
