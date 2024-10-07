package algorithms_06;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 *
 * @author wheat
 * @date 2024/07/11  14:25
 */
public class Solution_349 {

    /**
     * 求交集
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                res.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }

            // 去除重复元素
            while (i > 0 && i < nums1.length && nums1[i] == nums1[i - 1]) i++;
            while (j > 0 && j < nums2.length && nums2[j] == nums2[j - 1]) j++;
        }

        int n = res.size();
        int[] retVal = new int[n];
        for (int k = 0; k < n; k++) {
            retVal[k] = res.get(k);
        }

        return retVal;
    }

}
