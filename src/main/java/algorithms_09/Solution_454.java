package algorithms_09;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *      0 <= i, j, k, l < n
 *      nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 *
 * @author wheat
 * @date 2024/07/26  9:26
 */
public class Solution_454 {

    /**
     * 暴力解法 - 超出时间限制 n^4
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    for (int l = 0; l < n; l++) {
                        if (nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }

    /**
     * 借助hashMap 时间复杂度 O(n^2)
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount_2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int n = nums1.length;
        // value -> count
        Map<Integer, Integer> mapAB = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums1[i] + nums2[j];
                mapAB.put(sum, mapAB.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = nums3[i] + nums4[j];
                count += mapAB.getOrDefault(-sum, 0);
            }
        }

        return count;
    }


}
