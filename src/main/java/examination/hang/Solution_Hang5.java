package examination.hang;

import java.util.Arrays;

/**
 * @author wheat
 * @date 2024/03/16  19:17
 */
public class Solution_Hang5 {

    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n = scanner.nextInt();
//        int[] permutation = new int[n];
//        for (int i = 0; i < n; i++) {
//            permutation[i] = scanner.nextInt();
//        }

        int n = 3;
        int[] permutation = new int[] {1, 2, 3};

        for (int i = 0; i < permutation.length; i++) {
            int[] permutationNew = new int[permutation.length];
            System.arraycopy(permutation, 0, permutationNew, 0, permutation.length);
            permutationNew[i] = ~permutationNew[i];

            // 计算数组逆序对的个数
            int count = countInversePairs(permutationNew);
            System.out.println(count);
        }

    }


    public static int countInversePairs(int[] nums) {
        if (nums == null || nums.length <= 1)
            return 0;

        int[] temp = new int[nums.length];
        return mergeSortAndCount(nums, temp, 0, nums.length - 1);
    }

    private static int mergeSortAndCount(int[] nums, int[] temp, int left, int right) {
        if (left >= right)
            return 0;

        int mid = left + (right - left) / 2;
        int count = 0;
        count += mergeSortAndCount(nums, temp, left, mid); // 左半部分逆序对的个数
        count += mergeSortAndCount(nums, temp, mid + 1, right); // 右半部分逆序对的个数
        count += merge(nums, temp, left, mid, right); // 合并两部分，并计算逆序对个数
        return count;
    }

    private static int merge(int[] nums, int[] temp, int left, int mid, int right) {
        int i = left; // 左半部分数组的起始索引
        int j = mid + 1; // 右半部分数组的起始索引
        int k = left; // 临时数组的索引
        int count = 0;

        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                // 当前元素nums[i]大于nums[j]，则构成逆序对，因为左半部分是有序的，所以i后面的元素都大于nums[j]
                count += mid - i + 1;
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = nums[i++];
        }

        while (j <= right) {
            temp[k++] = nums[j++];
        }

        // 将临时数组的元素复制回原数组
        for (int m = left; m <= right; m++) {
            nums[m] = temp[m];
        }

        return count;
    }



}
