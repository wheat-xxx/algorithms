package algorithms_00;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *      四数之和转为三数之和的问题
 *
 * @author wheat
 * @date 2023/02/23  15:52
 */
public class Solution_18 {

    @Test
    public void test(){
        int[] nums = {1,0,-1,0,-2,2};
        fourSum(nums, 0);
    }


    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> resList = new ArrayList<>();

        // 边界条件
        if(nums == null || nums.length < 4){
            return resList;
        }

        Arrays.sort(nums);

        for(int i = 0; i < nums.length - 3; i++){

            // 去除重复解
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }

            for(int j = i + 1; j < nums.length - 2; j++){

                // 去除重复解
                if(j > i+1 && nums[j] == nums[j-1]){
                    continue;
                }

                // 利用双指针进行寻找满足要求的解
                int k = j + 1, l = nums.length - 1;
                while(k < l){
                    long sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    // 分三种情况
                    if(sum == target){

                        // 保存结果
                        List<Integer> elem = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        resList.add(elem);

                        // 更新指针
                        k++; l--;
                        while(k < l && nums[k] == nums[k-1]) k++;
                        while(k < l && nums[l] == nums[l+1]) l--;
                    }else if(sum < target){
                        k++;
                    }else{
                        l--;
                    }
                }

            }
        }

        return resList;

    }

}
