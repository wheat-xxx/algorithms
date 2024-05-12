package algorithms_basic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author wheat
 * @date 2023/12/04  21:07
 */
public class MySort {

    public static void main(String[] args) {
//        int[] nums = {170, 45, 75, 90, 802, 24, 2, 66};
//        System.out.println("Original Array: " + arrayToString(nums));
//        radixSort_2(nums);
//        System.out.println("Sorted Array: " + arrayToString(nums));

//        int[] array = {5, 2, 9, 3, 7, 4, 8, 1, 6};
//        quickSort(array);
//        System.out.println(Arrays.toString(array));

        int[] array = {5, 2, 9, 3, 7, 4, 8, 1, 6};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    private static String arrayToString(int[] array) {
        StringBuilder result = new StringBuilder("[");
        for (int num : array) {
            result.append(num).append(", ");
        }
        result.setLength(result.length() - 2);
        result.append("]");
        return result.toString();
    }

    /**
     * 基数排序 只适用于整数
     *
     * @param nums
     */
    public static void radixSort(int[] nums) {
        if (nums == null || nums.length < 2) return;

        // 获取数组中最大值的位数
        int max = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max = nums[i] > max ? nums[i] : max;
        }

        int exp = 1;    // 初始为个位

        // 进行排序
        while (max / exp > 0) {
            List<List<Integer>> buckets = new ArrayList<>(10);

            for (int i = 0; i < 10; i++) {
                buckets.add(new ArrayList<Integer>());
            }

            // 将数字分配到桶中
            for (int num : nums) {
                int index = (num / exp) % 10;  // 取当前位
                buckets.get(index).add(num);
            }

            // 从桶中收集数字
            int index = 0;
            for (List<Integer> bucket : buckets) {
                for (int num : bucket) {
                    nums[index++] = num;
                }
            }

            exp *= 10;
        }
    }

    /**
     * 基数排序
     *
     * @param nums
     */
    public static void radixSort_2(int[] nums) {
        // 边界情况
        if (nums == null || nums.length < 2) return;

        int length = nums.length;
        int max = Arrays.stream(nums).max().getAsInt();     // 获取数组最大值
        int[] buffer = new int[length];     // 缓存

        int exp = 1;
        while (max / exp > 0) {
            // 获取当前位每个基数的个数
            int[] counts = new int[10];
            for (int num : nums) {
                int digit = (num / exp) % 10;
                counts[digit]++;
            }
            // 缓存数组中 每个基数列表所占区间的位置
            for (int i = 1; i < 10; i++) {
                counts[i] += counts[i - 1];
            }
            // 将数组分配到桶中
            for (int i = length - 1; i >= 0; i--) {
                int digit = (nums[i] / exp) % 10;
                buffer[--counts[digit]] = nums[i];
            }

            System.arraycopy(buffer, 0, nums, 0, length);

            // 从低位往高位
            exp *= 10;
        }
    }

    /**
     * 快速排序
     *
     * @param nums
     */
    public static void quickSort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort(int[] nums, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(nums, low, high);
            quickSort(nums, low, partitionIndex - 1);
            quickSort(nums, partitionIndex + 1, high);
        }
    }

    private static int partition(int[] nums, int low, int high) {
        int pivot = nums[low];
        while (low < high) {
            while (low < high && nums[high] >= pivot) {
                high--;
            }
            if (low < high && nums[high] < pivot) {
                swap(nums, low, high);
                low++;
            }
            while (low < high && nums[low] <= pivot) {
                low++;
            }
            if (low < high && nums[low] > pivot) {
                swap(nums, low, high);
                high--;
            }
        }
        nums[low] = pivot;
        return low;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    /**
     * 归并排序
     *
     * @param nums
     */
    public static void mergeSort(int[] nums) {
        int[] temp = new int[nums.length];
        mergeSort(nums, 0, nums.length - 1, temp);
    }

    /**
     * 归并排序
     *
     * @param nums
     * @param low
     * @param high
     * @param temp 缓存，用于两个有序子序列进行合并
     */
    private static void mergeSort(int[] nums, int low, int high, int[] temp) {
        if (low < high) {
            int middle = (low + high) / 2;
            // 将nums分成两半 分别进行归并排序
            mergeSort(nums, low, middle, temp);
            mergeSort(nums, middle + 1, high, temp);
            // 将两个有序子序列 进行合并
            merge(nums, low, middle, high, temp);
        }
    }

    private static void merge(int[] nums, int low, int middle, int high, int[] temp) {
        int i = low, j = middle + 1;
        int k = 0;
        while (i <= middle && j <= high) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= middle) {
            temp[k++] = nums[i++];
        }
        while (j <= high) {
            temp[k++] = nums[j++];
        }

        k = 0;
        for (i = low; i <= high; i++) {
            nums[i] = temp[k++];
        }
    }
}
