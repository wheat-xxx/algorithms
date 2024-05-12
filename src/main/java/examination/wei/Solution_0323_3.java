package examination.wei;

import java.util.*;

/**
 *
 * @author wheat
 * @date 2024/03/23  9:58
 */
public class Solution_0323_3 {

    private int countSwap(int[] nums, String s) {
        List<Integer> newNums = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if(s.charAt(i) == 'W') {
                temp.add(nums[i]);
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            if(i + 1 < nums.length && temp.get(i + 1) < temp.get(i)) return -1;
        }
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'R') {
                newNums.add(nums[i]);
            }
        }
        int[] newNumsArray = new int[newNums.size()];
        for (int i = 0; i < newNumsArray.length; i++) {
            newNumsArray[i] = newNums.get(i);
        }
        return minSwaps(nums);
    }

    private int minSwaps(int[] nums) {
        int n = nums.length;
        int[] sorted = Arrays.copyOf(nums, n);
        Arrays.sort(sorted);

        // 使用哈希表存储每个元素在有序数组中的位置
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(sorted[i], i);
        }

        int swaps = 0;
        for (int i = 0; i < n; i++) {
            int correctIndex = indexMap.get(nums[i]);
            if (correctIndex != i) {
                // 进行交换
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


    }

}
