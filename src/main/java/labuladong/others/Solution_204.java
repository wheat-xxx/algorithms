package labuladong.others;

import java.util.Arrays;

/**
 * 给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。
 *
 * 素数定义：如果一个数如果只能被 1 和它本身整除，那么这个数就是素数
 * 素数序列：2，3，7，11.......
 *
 * 因数：i * i < n
 * @author wheat
 * @date 2024/04/25  16:39
 */
public class Solution_204 {

    public int countPrimes(int n) {
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    private boolean isPrime(int n) {
        for (int i = 2; i < n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    /**
     * 质数的倍数不是质数
     * @param n
     * @return
     */
    public int countPrimes_2(int n) {
        boolean[] isPrime = new boolean[n];
        // 将数组都初始化为 true
        Arrays.fill(isPrime, true);

        for (int i = 2; i < n; i++) {
            if (isPrime[i]) {
                // i 的倍数不可能是素数了
                for (int j = 2; j * i < n; j++) {
                    isPrime[j * i] = false;
                }
            }
        }

        int res = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime[i]) res++;
        }
        return res;
    }

}
