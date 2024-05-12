package algorithms_00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * Description:
 *      给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，
 *      找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * @author wheat
 * @date 2023/03/01  15:35
 */
public class Solution_39 {

    private List<List<Integer>> res = new ArrayList<>();
    private Stack<Integer> stack = new Stack<>();


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 边界检验
        if(candidates == null || candidates.length == 0) return res;

        Arrays.sort(candidates);

        dfs(candidates, target, 0);

        return res;
    }

    public void dfs(int[] candidates, int target, int index){

        // 边界检查
        if(target == 0){
            res.add(new ArrayList<Integer>(stack));
            return;
        }

        for(int i = index; i < candidates.length; i++){
            // 剪枝
            if(candidates[i] > target) break;

            stack.push(candidates[i]);

            dfs(candidates, target - candidates[i], i);

            stack.pop();
        }


    }

}
