package algorithms_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 *      分析利用决策树
 *
 * @author wheat
 * @date 2023/03/13  17:33
 */
public class Solution_77 {

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {

        int[] nums = new int[n];
        for(int i = 1; i <= n; i++){
            nums[i - 1] = i;
        }

        dfs(nums, 0, k);

        return res;
    }

    private void dfs(int[] nums, int start, int k){
        // 递归结束条件
        if(path.size() == k){
            res.add(new ArrayList<Integer>(path));
            return;
        }

        // 递归体
        for(int i = start; i < nums.length - k + 1; i++){
            path.add(nums[i]);
            dfs(nums, i + 1, k);
            path.remove(path.size() - 1);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }


    @Test
    public void test(){
        combine(4, 2);
    }

}
