package labuladong.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 排列（元素可重不可复选）
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * 集合/组合 不需要用到前面的元素
 * 排列还需要用到前面的元素
 * @author wheat
 * @date 2024/03/23  22:20
 */
public class Solution_47 {

    private List<List<Integer>> res = new ArrayList<>();
    // 路径
    private List<Integer> track = new ArrayList<>();
    // 标记元素是否被使用过
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);  // 用于决策树同一层 避免对相同元素进行重复决策
        this.used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        // 结束条件 前序遍历位置
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        // 回溯算法框架
        int temp = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;

//            // 剪枝 避免对同一层相同元素的遍历
//            if (nums[i] == others) {
//                continue;
//            } else {
//                others = nums[i];
//            }

            // 新添加的剪枝逻辑，固定相同的元素在排列中的相对位置
            // 同一层中相同元素一定未被使用
            if (i > 0 && nums[i] == nums[i - 1] && !used[i-1]) {
                continue;
            }

            // 做选择
            track.add(nums[i]);
            used[i] = true;

            backtrack(nums);

            // 撤销选择
            track.remove(track.size() - 1);
            used[i] = false;
        }
    }



    public static void main(String[] args) {
        int[] nums = {1,1,2};
        new Solution_47().permuteUnique(nums);
    }

}
