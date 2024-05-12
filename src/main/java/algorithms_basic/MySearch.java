package algorithms_basic;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wheat
 * @date 2023/12/02  15:59
 */
public class MySearch {

    public static void main(String[] args) {
        Integer[] sortedArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer target = 10;

        int result = binarySearch(sortedArray, target);
        System.out.println("result = " + result);
    }

    /**
     * 二分查找，
     * @param array
     * @param target
     * @param <T>
     * @return 返回target下标
     */
    public static <T extends Comparable<T>> int binarySearch(T[] array, T target) {
        if(array == null || array.length == 0) return -1;

        int left = 0, right = array.length - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            int comparison = array[mid].compareTo(target);
            if(comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }


}
