package algorithms_03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wheat
 * @date 2023/12/04  20:20
 */
public class Solution_164 {

    public int maximumGap(int[] nums) {
        int ans = 0;
        // 边界情况
        if(nums == null || nums.length < 2) return ans;

        radixSort(nums);

        ans = nums[1] - nums[0];
        for(int i = 2; i < nums.length; i++) {
            ans = (nums[i] - nums[i - 1]) > ans ? (nums[i] - nums[i - 1]) : ans;
        }

        return ans;
    }

    public static void radixSort(int[] nums) {
        if(nums == null || nums.length < 2) return;

        // 获取数组中最大值的位数
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = nums[i] > max ? nums[i] : max;
        }

        int exp = 1;    // 初始为个位

        // 进行排序
        while(max / exp > 0) {
            List<List<Integer>> buckets = new ArrayList<>(10);

            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<Integer>());
            }

            // 将数字分配到桶中
            for(int num : nums) {
                int index = (num / exp) % 10;  // 取当前位
                buckets.get(index).add(num);
            }

            // 从桶中收集数字
            int index = 0;
            for(List<Integer> bucket : buckets) {
                for(int num : bucket) {
                    nums[index++] = num;
                }
            }

            exp *= 10;
        }
    }

}
