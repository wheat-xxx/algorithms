package algorithms_01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description: 利用决策树处理该问题
 *
 * @author wheat
 * @date 2023/03/27  14:48
 */
public class Solution_90 {

    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res.add(path);

        // 边界条件
        if(nums == null || nums.length == 0) return res;

        // 对数组中的元素进行排序
        Arrays.sort(nums);

        for(int i = 1; i <= nums.length; i++){
            dfs(nums, i, 0);
        }

        return res;
    }

    private void dfs(int[] nums, int len, int start){
        if(path.size() == len){
            res.add(new ArrayList(path));
            return;
        }

        for(int i = start; i < nums.length; i++){
            if(i >= 1 && nums[i - 1] == nums[i]) continue;
            path.add(nums[i]);
            dfs(nums, len, i + 1);
            path.remove(path.size() - 1);
            while(i + 1 < nums.length && nums[i] == nums[i + 1]) i++;
        }
    }

}
