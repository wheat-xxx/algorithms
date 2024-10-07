package algorithms_09;

import java.awt.*;
import java.security.AlgorithmConstraints;

/**
 * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
 * 1 <= s.length <= 104
 * s 由小写英文字母组成
 * @author wheat
 * @date 2024/05/07  20:42
 */
public class Solution_459 {

    public boolean repeatedSubstringPattern(String s) {
        if (s.length() == 1) return false;

        char[] chs = s.toCharArray();
        int n = chs.length;

        for (int i = 2; i <= n / 2; i++) {  // i 是字串的个数
            // 不能平均划分为i个字串
            if (n % i != 0) {
                continue;
            }

            // 比较i个字串是否相等
            int j = 0;
            for (j = 0; j < n / i; j++) {   // j 是第一个字串的索引
                char ch = chs[j];
                int k = 0;
                for (k = 0; k < i; k++) {   // k 表示是哪个字串
                    if (ch != chs[k * n / i + j]) {
                        break;
                    }
                }
                // 字串不相等
                if (k != i) {
                    break;
                }
            }
            if (j == n / i) return true;
        }

        // 特殊情况 s由相同字符组成
        char ch = chs[0];
        int i = 0;
        for (i = 0; i < chs.length; i++) {
            if (ch != chs[i]) break;
        }
        if (i == chs.length) return true;

        return false;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 第二次写
     * note: 从内层循环如何直接跳出外层循环
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern_2(String s) {
        char[] chs = s.toCharArray();

        for (int subLen = 1; subLen <= chs.length / 2; subLen++) {
            if (chs.length % subLen != 0) {
                continue;
            }

            int i = 1;
            for (i = 1; i < chs.length / subLen; i++) {
                int j = 0;
                for (j = 0; j < subLen; j++) {
                    if (chs[j] != chs[i * subLen + j]) {
                        break;
                    }
                }
                if (j != subLen) break;
            }
            if (i == chs.length / subLen) return true;
        }

        return false;
    }

}
