package labuladong.others;

/**
 * 丑数 就是只包含质因数 2、3 和 5 的正整数。
 * 给你一个整数 n ，请你判断 n 是否为 丑数 。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 正整数分解定理：任意一个大于 1 的自然数，要么它本身就是质数，要么它可以分解为若干质数的乘积。
 *
 * @author wheat
 * @date 2024/04/25  16:25
 */
public class Solution_263 {

    public boolean isUgly(int n) {
        if (n <= 0) return false;

        // 如果n是丑数，分解因子应该只有2，3，5
        while (n % 2 == 0) n /= 2;
        while (n % 3 == 0) n /= 3;
        while (n % 5 == 0) n /= 5;

        return n == 1;
    }

}
