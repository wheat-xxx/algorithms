package labuladong.ds.graph;

import java.util.LinkedList;

/**
 * 给你 n 个人的社交关系（你知道任意两个人之间是否认识），然后请你找出这些人中的「名人」。
 * 所谓「名人」有两个条件：
 * 1、所有其他人都认识「名人」。
 * 2、「名人」不认识任何其他人。
 *
 * 如果存在，算法返回这个名人的编号，如果不存在，算法返回 -1
 * @author wheat
 * @date 2024/04/18  9:59
 */
public class Solution_277 {

    // 可以直接调用，能够返回 i 是否认识 j
    private boolean knows(int i, int j){return false;}

    /**
     * 常规思路：纵向遍历二维数组，从而可以判断一个人是不是名人
     * @param graph
     * @return
     */
    public int findCelebrity(int[][] graph) {
        return -1;
    }

    public int findCelebrity(int n) {
        if (n == 1) return 0;
        // 将所有候选人装进队列
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.addLast(i);
        }
        // 一直排除，直到只剩下一个候选人停止循环
        while (q.size() >= 2) {
            // 每次取出两个候选人，排除一个
            int cand = q.removeFirst();
            int other = q.removeFirst();
            if (knows(cand, other) || !knows(other, cand)) {
                // cand 不可能是名人，排除，让 other 归队
                q.addFirst(other);
            } else {
                // other 不可能是名人，排除，让 cand 归队
                q.addFirst(cand);
            }
        }

        // 现在排除得只剩一个候选人，判断他是否真的是名人
        int cand = q.removeFirst();
        for (int other = 0; other < n; other++) {
            if (other == cand) {
                continue;
            }
            // 保证其他人都认识 cand，且 cand 不认识任何其他人
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }
        // cand 是名人
        return cand;
    }

    public int findCelebrity_2(int n) {
        // 先假设 cand 是名人
        int cand = 0;
        for (int other = 1; other < n; other++) {
            if (!knows(other, cand) || knows(cand, other)) {
                // cand 不可能是名人，排除
                // 假设 other 是名人
                cand = other;
            } else {
                // other 不可能是名人，排除
                // 什么都不用做，继续假设 cand 是名人
            }
        }

        // 现在的 cand 是排除的最后结果，但不能保证一定是名人
        for (int other = 0; other < n; other++) {
            if (cand == other) continue;
            // 需要保证其他人都认识 cand，且 cand 不认识任何其他人
            if (!knows(other, cand) || knows(cand, other)) {
                return -1;
            }
        }

        return cand;
    }

}
