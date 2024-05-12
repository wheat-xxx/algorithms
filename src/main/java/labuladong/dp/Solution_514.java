package labuladong.dp;

import java.util.*;

/**
 * 自由之路
 * @author wheat
 * @date 2024/05/05  17:00
 */
public class Solution_514 {

    // 字符 -> 索引列表
    private Map<Character, List<Integer>> charToIndex = new HashMap<>();
    // 备忘录
    private int[][] memo;

    public int findRotateSteps(String ring, String key) {
        int m = ring.length();
        int n = key.length();
        // 记录圆环上字符到索引的映射
        for (int i = 0; i < m; i++) {
            char c = ring.charAt(i);
            if (!charToIndex.containsKey(c)) {
                charToIndex.put(c, new ArrayList<>());
            }
            charToIndex.get(c).add(i);
        }

        this.memo = new int[m][n];

        return dp(ring, 0, key, 0);
    }

    /**
     * dp函数定义：计算圆盘指针在 ring[i]，输入 key[j..] 的最少操作数
     * @param ring
     * @param i
     * @param key
     * @param j
     * @return
     */
    private int dp(String ring, int i, String key, int j) {

        // base case
        if (j == key.length()) return 0;
        // 查找备忘录，避免重叠子问题
        if (memo[i][j] != 0) return memo[i][j];

        // 做选择
        int res = Integer.MAX_VALUE;
        // ring 上可能有多个字符 key[j]
        for (Integer index : charToIndex.get(key.charAt(j))) {
            // 拨动指针的次数
            int delta = Math.abs(i - index);
            // 选择顺时针还是逆时针
            delta = Math.min(delta, ring.length() - delta);
            // 将指针拨到 ring[k]，继续输入 key[j+1..]
            int subProblem = dp(ring, index, key, j + 1);
            // 选择「整体」操作次数最少的
            // 加一是因为按动按钮也是一次操作
            res = Math.min(res, subProblem + delta + 1);
        }

        // 将结果存入备忘录
        memo[i][j] = res;

        return res;
    }

}
