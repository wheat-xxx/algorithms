package algorithms_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/13  20:17
 */
public class Solution_78 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for(int i = 0; i <= nums.length; i++){
            dfs(nums, 0, i);
        }
        return res;
    }

    private void dfs(int[] nums, int start, int len){
        if(path.size() == len){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = start; i < nums.length; i++){
            path.add(nums[i]);
            dfs(nums, i + 1, len);
            path.remove(path.size() - 1);
        }
    }

}
