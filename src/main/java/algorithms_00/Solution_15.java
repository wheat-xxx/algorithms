package algorithms_00;

import com.sun.org.apache.xpath.internal.WhitespaceStrippingElementMatcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wheat
 * @date 2024/07/26  16:13
 */
public class Solution_15 {

    /**
     * 回溯 - 超出时间限制 - 暴力解法
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    private List<List<Integer>> res = new ArrayList<>();
    private List<Integer> trace = new ArrayList<>();

    private void backtrack(int[] nums, int start) {

        // base case
        if (trace.size() == 3 && trace.get(0) + trace.get(1) + trace.get(2) == 0) {
            res.add(new ArrayList<Integer>(trace));
            return;
        }

        for (int i = start; i < nums.length; i++) {
            // 避免重复
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 剪枝
            int sum = trace.stream().mapToInt(Integer::intValue).sum() + nums[i];
            if (sum > 0) return;

            // 做选择
            trace.add(nums[i]);
            backtrack(nums, i + 1);
            // 撤销选择
            trace.remove(trace.size() - 1);
        }

    }

    /**
     * 将三个数的问题转为两个数的问题
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum_2(int[] nums) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();

        // 特殊情况处理
        if(nums == null || nums.length < 3){
            return res;
        }

        Arrays.sort(nums);

        // 固定最小的数字
        for(int i = 0; i < nums.length; i++){

            if(nums[i] > 0) break;

            // 去除重复数字
            if(i > 0 && nums[i] == nums[i-1]) continue;

            int left = i + 1, right = nums.length - 1;
            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum == 0){
                    List<Integer> elem = Arrays.asList(nums[i], nums[left], nums[right]);
                    res.add(elem);

                    // 进行去重处理
                    right--; left++;
                    while(left < right && nums[left-1] == nums[left]){
                        left++;
                    }
                    while(left < right && nums[right] == nums[right+1]){
                        right--;
                    }
                }else if(sum < 0){
                    left++;
                }else{
                    right--;
                }

            }

        }

        return res;

    }

}
