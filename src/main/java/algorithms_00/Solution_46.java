package algorithms_00;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *      给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 * @author wheat
 * @date 2023/03/05  14:24
 */
public class Solution_46 {

//    public List<List<Integer>> permute(int[] nums){
//        List<List<Integer>> res = new ArrayList<>();
//        List<Integer> path = new ArrayList<>();
//
//        if(nums == null || nums.length == 0) return res;
//
//        int len = nums.length;
//
//        boolean[] used = new boolean[len];
//
//        dfs(nums, len, 0, path, used, res);
//
//        return res;
//    }
//
//    public void dfs(int[] nums, int len, int depth, List<Integer> path, boolean[] used, List<List<Integer>> res){
//        if(depth == len){
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        for (int i = 0; i < len; i++) {
//            if(!used[i]){
//                path.add(nums[i]);
//                used[i] = true;
//                dfs(nums, len, depth + 1, path, used, res);
//                used[i] = false;
//                path.remove(i);
//            }
//        }
//    }

    // 完美的递归+回溯
    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums){
        if(nums == null || nums.length == 0) return res;

        dfs(nums, 0);

        return res;
    }

    private void dfs(int[] nums, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = depth; i < nums.length; i++){
            swap(nums, depth, i);
            path.add(nums[depth]);
            dfs(nums, depth + 1);
            path.remove(path.size() - 1);
            swap(nums, depth, i);
        }
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

}
