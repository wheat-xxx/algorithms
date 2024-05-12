package labuladong.others;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 超级丑数 是一个正整数，并满足其所有质因数都出现在质数数组 primes 中。
 * 给你一个整数 n 和一个整数数组 primes ，返回第 n 个 超级丑数 。
 * 题目数据保证第 n 个 超级丑数 在 32-bit 带符号整数范围内。
 *
 * @author wheat
 * @date 2024/04/26  9:56
 */
public class Solution_313 {

    public int nthSuperUglyNumber(int n, int[] primes) {
        long[] ugly = new long[n + 1];
        // 可以理解为指向有序链表头结点的指针
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers, 1);
        // 可以理解为有序链表的头节点的值
        long[] products = new long[primes.length];      // 可以优化掉
        Arrays.fill(products, 1);
        int p = 1;
        while (p <= n) {
            long min = products[0];
            for (int i = 0; i < primes.length; i++) {
                min = min < products[i] ? min : products[i];
            }
            ugly[p++] = min;
            // 前进对应有序链表上的指针
            for (int i = 0; i < primes.length; i++) {
                if (min == products[i]) {
                    products[i] = primes[i] * ugly[pointers[i]];
                    pointers[i]++;
                }
            }
        }

        return (int)ugly[n];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    public int nthSuperUglyNumber_2(int n, int[] primes) {
        // 优先队列中装三元组 int[] {product, prime, pi}
        // 其中 product 代表链表节点的值，prime 是计算下一个节点所需的质数因子，pi 代表链表上的指针
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            // 优先级队列按照节点的值排序
            return a[0] - b[0];
        });

        // 把多条链表的头结点加入优先级队列
        for (int i = 0; i < primes.length; i++) {
            pq.offer(new int[]{ 1, primes[i], 1 });
        }

        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        while (p <= n) {
            // 取primes.length个链表的最小结点
            int[] pair = pq.poll();
            int product = pair[0];
            int prime = pair[1];
            int index = pair[2];

            // 避免结果链表出现重复元素
            if (product != ugly[p - 1]) {
                // 接到结果链表上
                ugly[p] = product;
                p++;
            }

            // 生成下一个节点加入优先级队列
            int[] nextPair = new int[]{ugly[index] * prime, prime, index + 1};
            pq.offer(nextPair);
        }
        return ugly[n];
    }


}
