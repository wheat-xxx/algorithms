package labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * nums 数组中的元素无重复且可复选的情况下，会有哪些排列？
 * 比如输入 nums = [1,2,3]，那么这种条件下的全排列共有 3^3 = 27 种：
 * [
 *   [1,1,1],[1,1,2],[1,1,3],[1,2,1],[1,2,2],[1,2,3],[1,3,1],[1,3,2],[1,3,3],
 *   [2,1,1],[2,1,2],[2,1,3],[2,2,1],[2,2,2],[2,2,3],[2,3,1],[2,3,2],[2,3,3],
 *   [3,1,1],[3,1,2],[3,1,3],[3,2,1],[3,2,2],[3,2,3],[3,3,1],[3,3,2],[3,3,3]
 * ]
 * @author wheat
 * @date 2024/03/24  15:01
 */
public class Solution_permuteRepeat {

    private List<List<Integer>> res = new ArrayList<>();
    // 路径
    private List<Integer> track = new ArrayList<>();

    public List<List<Integer>> permuteRepeat(int[] nums) {
        backtrack(nums);
        return res;
    }

    private void backtrack(int[] nums) {
        // 结束条件
        if (track.size() == nums.length) {
            res.add(new ArrayList<>(track));
            return;
        }

        // 回溯算法核心框架
        for (int i = 0; i < nums.length; i++) {
            // 做选择
            track.add(nums[i]);

            backtrack(nums);

            // 取消选择
            track.remove(track.size() - 1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        new Solution_permuteRepeat().permuteRepeat(nums);
    }

}
