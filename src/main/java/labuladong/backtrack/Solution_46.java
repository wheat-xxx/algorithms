package labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author wheat
 * @date 2024/03/21  16:41
 */
public class Solution_46 {

    private int[] nums;
    private List<List<Integer>> res;
    private boolean[] used;

    /**
     * 回溯算法 - 站在盒的视角
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        this.used = new boolean[nums.length];
        backtrack(new ArrayList<Integer>());

        return res;
    }

    /**
     * 路径：记录在 work 中
     * 选择列表：nums 中不存在于 work 的那些元素（used[i] 为 false）
     * 结束条件：nums 中的元素全都在 track 中出现
     * @param work
     */
    private void backtrack(List<Integer> work) {
        // 结束条件
        if(work.size() == nums.length) {
            res.add(new ArrayList<>(work));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if(used[i]) continue;

            // 做选择
            work.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(work);
            // 撤销选择
            work.remove(work.size() - 1);
            used[i] = false;
        }
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 通过交换元素实现
     * @param nums
     * @return
     */
    public List<List<Integer>> permute_2(int[] nums) {
        backtrack(nums, 0);
        return result;
    }

    private List<List<Integer>> result = new ArrayList();

    /**
     * 回溯算法核心框架
     * @param nums
     * @param start
     */
    private void backtrack(int[] nums, int start) {

        if (start == nums.length) {
            // 找到一个全排列，Java 需要转化成 List 类型
            List<Integer> list = new ArrayList<>();
            for (int num : nums) {
                list.add(num);
            }
            result.add(list);
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 做选择
            swap(nums, start, i);
            // 递归调用 相当于确定第i个小球的位置
            backtrack(nums, start + 1);
            // 撤销选择
            swap(nums, start, i);
        }

    }

    /**
     * 交换两个元素的位置
     * @param nums
     * @param i
     * @param j
     */
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        new Solution_46().permute(nums);
    }

}
