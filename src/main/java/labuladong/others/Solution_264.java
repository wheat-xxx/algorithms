package labuladong.others;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数 n ，请你找出并返回第 n 个 丑数 。
 * 丑数 就是质因子只包含 2、3 和 5 的正整数。
 * @author wheat
 * @date 2024/04/25  16:36
 */
public class Solution_264 {

    /**
     * 真的秒
     * @param n
     * @return
     */
    public int nthUglyNumber(int n) {
        // 可以理解为三个指向有序链表头结点的指针
        int p2 = 1, p3 = 1, p5 = 1;
        // 可以理解为三个有序链表的头节点的值
        int product2 = 1, product3 = 1, product5 = 1;
        // 可以理解为最终合并的有序链表（结果链表）
        int[] ugly = new int[n + 1];
        // 可以理解为结果链表上的指针
        int p = 1;

        // 开始合并三个有序链表，找到第 n 个丑数时结束
        while (p <= n) {
            // 取三个链表的最小结点
            int min = Math.min(Math.min(product2, product3), product5);
            ugly[p++] = min;
            // 前进对应有序链表上的指针
            if (min == product2) {
                product2 = 2 * ugly[p2++];
            }
            if (min == product3) {
                product3 = 3 * ugly[p3++];
            }
            if (min == product5) {
                product5 = 5 * ugly[p5++];
            }
        }

        return ugly[n];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 回溯算法求解 - 不行 回溯算法是深度优先搜索算法 这里应该对回溯算法生成的决策树进行BFS遍历
     * @param n
     * @return
     */
    public int nthUglyNumber_2(int n) {
        return 0;
    }


}
