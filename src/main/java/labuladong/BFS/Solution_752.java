package labuladong.BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 *
 * 你有一个带有四个圆形拨轮的转盘锁。每个拨轮都有10个数字： '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' 。
 * 每个拨轮可以自由旋转：例如把 '9' 变为 '0'，'0' 变为 '9' 。每次旋转都只能旋转一个拨轮的一位数字。
 * 锁的初始数字为 '0000' ，一个代表四个拨轮的数字的字符串。
 * 列表 deadends 包含了一组死亡数字，一旦拨轮的数字和列表里的任何一个元素相同，这个锁将会被永久锁定，无法再被旋转。
 * 字符串 target 代表可以解锁的数字，你需要给出解锁需要的最小旋转次数，如果无论如何不能解锁，返回 -1
 *
 * @author wheat
 * @date 2024/03/24  21:08
 */
public class Solution_752 {

    /**
     * BFS 最短路径
     * @param deadends
     * @param target
     * @return
     */
    public int openLock(String[] deadends, String target) {

        Queue<String> queue = new LinkedList<>();   // BFS核心数据结构
        Set<String> deads = new HashSet<>();    // 存储死亡数字
        for(String s : deadends) deads.add(s);
        Set<String> visited = new HashSet<>();  // 记录已经穷举过的密码，防止走回头路

        // 从起点开始启动广度优先搜索
        queue.offer("0000");
        visited.add("0000");
        int step = 0;
        while(!queue.isEmpty()) {
            int sz = queue.size();
            /* 将当前队列中的所有节点向四周扩散 */
            for (int i = 0; i < sz; i++) {
                String curNode = queue.poll();
                if (deads.contains(curNode)) {
                    continue;
                }
                // 判断是否到达终点
                if (curNode.equals(target)) {
                    return step;
                }

                /* 将一个节点未遍历的相邻节点加入队列 */
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(curNode, j);
                    String down = minusOne(curNode, j);
                    if (!visited.contains(up)) {
                        queue.add(up);
                        visited.add(up);
                    }
                    if (!visited.contains(down)) {
                        queue.add(down);
                        visited.add(down);
                    }
                }
            }
            /* 在这里增加步数 */
            step++;
        }
        return -1;
    }

    private String plusOne(String s, int j) {
        char[] chs = s.toCharArray();
        if (chs[j] == '9') {
            chs[j] = '0';
        } else {
            chs[j] += 1;
        }
        return new String(chs);
    }

    private String minusOne(String s, int j) {
        char[] chs = s.toCharArray();
        if (chs[j] == '0') {
            chs[j] = '9';
        } else {
            chs[j] -= 1;
        }
        return new String(chs);
    }

}
