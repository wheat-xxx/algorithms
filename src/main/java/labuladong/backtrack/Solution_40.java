package labuladong.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * @author wheat
 * @date 2024/03/23  22:07
 */
public class Solution_40 {

    private List<List<Integer>> res = new ArrayList<>();
    // 路径
    private List<Integer> track = new ArrayList<>();
    private int[] candidates;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        backtrack(target, 0, 0);
        return res;
    }

    private void backtrack(int target, int start, int trackSum) {
        // 结束条件 前序遍历位置
        // base case，达到目标和，找到符合条件的组合
        if(trackSum == target) {
            res.add(new ArrayList<>(track));
            return;
        }
        // base case，超过目标和，直接结束
        if (trackSum > target) {
            return;
        }

        // 回溯算法标准框架
        for (int i = start; i < candidates.length; i++) {
            // 避免出现重复的子集 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            // 做选择
            trackSum += candidates[i];
            track.add(candidates[i]);

            // 递归遍历下一层回溯树
            backtrack(target, i + 1, trackSum);

            // 撤销选择
            trackSum -= candidates[i];
            track.remove(track.size() - 1);
        }
    }

}
