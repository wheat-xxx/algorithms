package labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 组合不是排列
 * @author wheat
 * @date 2024/03/23  21:24
 */
public class Solution_77 {

    // 返回结果集
    private List<List<Integer>> res = new ArrayList<>();
    // 路径
    private List<Integer> track = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    /**
     * 回溯算法框架
     * @param start
     * @param n
     * @param k
     */
    public void backtrack(int start, int n, int k) {
        // 结束条件
        // 前序遍历位置
        if (track.size() == k) {
            // 遍历到了第 k 层，收集当前节点的值
            res.add(new ArrayList<>(track));
            return;
        }

        // 回溯算法标准框架
        for (int i = start; i <= n; i++) {
            // 做选择
            track.add(i);
            backtrack(i + 1, n, k);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

}
