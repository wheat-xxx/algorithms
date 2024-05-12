package labuladong.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 子集/组合（元素可重不可复选）
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。解集 不能 包含重复的子集。
 * @author wheat
 * @date 2024/03/23  21:36
 */
public class Solution_90 {

    private List<List<Integer>> res = new ArrayList<>();
    // 路径
    private List<Integer> track = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private void backtrack(int[] nums, int start) {
        // 结束条件
        // 无

        // 前序遍历位置
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 避免出现重复的子集 剪枝逻辑，值相同的相邻树枝，只遍历第一条
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            backtrack(nums, i + 1);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

}
