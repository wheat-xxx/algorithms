package algorithms_00;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *      给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * @author wheat
 * @date 2023/03/05  16:43
 */
public class Solution_47 {

//    private List<List<Integer>> res = new ArrayList<List<Integer>>();
//    private List<Integer> path = new ArrayList<Integer>();
//
//    public List<List<Integer>> permuteUnique(int[] nums) {
//
//        if(nums == null || nums.length == 0){
//            return res;
//        }
//
//        Arrays.sort(nums);
//
//        dfs(nums, 0);
//
//        return res;
//    }
//
//    private void dfs(int[] nums, int depth){
//        if(depth == nums.length){
//            res.add(new ArrayList<Integer>(path));
//            return;
//        }
//        for(int i = depth; i < nums.length; i++){
//            if(i > depth && nums[i] == nums[i-1]){
//                continue;
//            }else{
//                swap(nums, depth, i);
//                path.add(nums[depth]);
//                dfs(nums, depth + 1);
//                path.remove(path.size() - 1);
//                swap(nums, depth, i);
//            }
//        }
//    }
//
//    private void swap(int[] nums, int i, int j){
//        int others = nums[i];
//        nums[i] = nums[j];
//        nums[j] = others;
//    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> path = new ArrayList<>();
    private boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums){

        if(nums == null || nums.length == 0) return res;

        Arrays.sort(nums);

        used = new boolean[nums.length];

        dfs(nums, 0);

        return res;

    }

    public void dfs(int[] nums, int depth){
        if(depth == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(!used[i]) {
                // 去重
                if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                    continue;
                }
                path.add(nums[i]);
                used[i] = true;
                dfs(nums, depth + 1);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }

    }
}
