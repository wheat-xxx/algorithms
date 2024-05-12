package labuladong.others;

import java.util.PriorityQueue;

/**
 * 丑数是可以被 a 或 b 或 c 整除的 正整数 。
 * 给你四个整数：n 、a 、b 、c ，请你设计一个算法来找出第 n 个丑数。
 *
 * 最大公因数：两个或多个整数中能够同时整除它们的最大整数
 * 辗转相除法：两个整数的最大公因数等于其中较小的数与两数相除的余数的最大公因数。
 *
 * @author wheat
 * @date 2024/04/26  11:10
 */
public class Solution_1201 {

    public int nthUglyNumber(int n, int a, int b, int c) {
        // 可以理解为三个有序链表的头结点的值
        // 由于数据规模较大，用 long 类型
        long productA = a, productB = b, productC = c;
        // 可以理解为合并之后的有序链表上的指针
        int p = 1;

        long min = -666;

        // 开始合并三个有序链表，获取第 n 个节点的值
        while (p <= n) {
            // 取三个链表的最小结点
            min = Math.min(Math.min(productA, productB), productC);
            p++;
            // 前进最小结点对应链表的指针
            if (min == productA) {
                productA += a;
            }
            if (min == productB) {
                productB += b;
            }
            if (min == productC) {
                productC += c;
            }
        }
        return (int) min;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 二分查找算法
     * 本题结果在 [1, 2 * 10e9] 的范围内
     * @param n
     * @param a
     * @param b
     * @param c
     * @return
     */
    public int nthUglyNumber_2(int n, int a, int b, int c) {
        // 题目说本题结果在 [1, 2 * 10^9] 范围内，
        // 所以就按照这个范围初始化两端都闭的搜索区间
        int left = 0, right = (int)2e9;
        // 搜索左侧边界的二分搜索
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if (f(mid, a, b, c) < n) {
                // [1..mid] 中符合条件的元素个数不足 n，所以目标在右半边
                left = mid + 1;
            } else {
                // [1..mid] 中符合条件的元素个数大于 n，所以目标在左半边
                right = mid - 1;
            }
        }
        return left;
    }

    /**
     * 计算最大公因数（辗转相除/欧几里得算法）
     * @param a
     * @param b
     * @return
     */
    private long gcd(long a, long b) {
        // 保证 a > b
        if (b > a) {
            return gcd(b, a);
        }
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    /**
     * 最小公倍数
     * @param a
     * @param b
     * @return
     */
    private long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    /**
     * 计算 [1..num] 之间有多少个能够被 a 或 b 或 c 整除的数字
     * @param num
     * @param a
     * @param b
     * @param c
     * @return
     */
    private long f(int num, int a, int b, int c) {
        long setA = num / a, setB = num / b, setC = num / c;
        long setAB = num / lcm(a, b);
        long setAC = num / lcm(a, c);
        long setBC = num / lcm(b, c);
        long setABC = num / lcm(lcm(a, b), c);
        // 集合论定理：A + B + C - A ∩ B - A ∩ C - B ∩ C + A ∩ B ∩ C
        return setA + setB + setC - setAB - setAC - setBC + setABC;
    }

}
