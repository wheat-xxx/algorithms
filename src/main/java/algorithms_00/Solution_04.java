package algorithms_00;

/**
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 *
 * @author wheat
 * @date 2024/10/07  15:41
 */
public class Solution_04 {

    /**
     * 双指针解法
     * @param nums1
     * @param nums2
     * @return
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len1 = nums1.length, len2 = nums2.length;
        int len = len1 + len2;

        // 统计已遍历数字的个数
        int count = 0;
        int index1 = 0, index2 = 0;
        int[] res = new int[2];
        while (index1 < len1 && index2 < len2) {
            if (nums1[index1] <= nums2[index2]) {
                if (count == len / 2 - 1) {
                    res[0] = nums1[index1];
                }
                if (count == len / 2) {
                    res[1] = nums1[index1];
                }
                index1++;
            } else {
                if (count == len / 2 - 1) {
                    res[0] = nums2[index2];
                }
                if (count == len / 2) {
                    res[1] = nums2[index2];
                }
                index2++;
            }
            count++;
        }

        if (index1 == len1) {
            while (index2 < len2) {
                if (count == len / 2 - 1) {
                    res[0] = nums2[index2];
                }
                if (count == len / 2) {
                    res[1] = nums2[index2];
                }
                index2++;
                count++;
            }
        }

        if (index2 == len2) {
            while (index1 < len1) {
                if (count == len / 2 - 1) {
                    res[0] = nums1[index1];
                }
                if (count == len / 2) {
                    res[1] = nums1[index1];
                }
                index1++;
                count++;
            }
        }

        return len % 2 == 0 ? (0.0 + res[0] + res[1]) / 2 : res[1];
    }

}
