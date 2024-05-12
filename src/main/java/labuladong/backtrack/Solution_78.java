package labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * @author wheat
 * @date 2024/03/23  21:01
 */
public class Solution_78 {

    // 保存返回结果
    private List<List<Integer>> res;
    // 记录回溯算法的递归路径
    private List<Integer> track;
    private int[] nums;

    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<List<Integer>>();
        track = new ArrayList<Integer>();
        this.nums = nums;
        backtrack(0);
        return res;
    }

    /**
     * 子集（元素无重不可复选）
     * 每个节点都对应一个答案
     * @param start 用于剪枝
     */
    public void backtrack(int start) {
        // 结束条件
        // 无

        // 前序遍历位置，每个节点的值都是一个子集
        res.add(new ArrayList<>(track));

        for (int i = start; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);
            // 通过 start 参数控制树枝的遍历，避免产生重复的子集
            backtrack(i + 1);
            // 撤销选择
            track.remove(track.size() - 1);
        }
    }

}
