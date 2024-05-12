package algorithms_00;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 *
 *      给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *      candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * @author wheat
 * @date 2023/03/01  22:32
 */
public class Solution_40 {

    private List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        // 边界检查
        if(candidates == null || candidates.length == 0){
            return res;
        }

        Arrays.sort(candidates);

        dfs(candidates, target, 0);

        return res;
    }

    public void dfs(int[] candidates, int target, int start){

        if(target == 0){
            res.add(new ArrayList<Integer>(stack));
            return;
        }

        for(int i = start; i < candidates.length; i++){
            if(candidates[i] - target > 0) break;

            // 同一层如果数值相同 后边的结果集肯定前面的子集
            if(i > start && candidates[i-1] == candidates[i]) continue;

            stack.push(candidates[i]);
            dfs(candidates, target - candidates[i], i + 1);
            stack.pop();
        }
    }

    @Test
    public void test(){
        int[] nums = {10,1,2,7,6,1,5};
        combinationSum2(nums, 8);
    }

}
