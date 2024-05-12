package capriccio.array;

/**
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1
 * @author wheat
 * @date 2024/03/18  20:39
 */
public class Solution_704 {

    public int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {  // 这里选择[]，还有[)
            int middle = (left + right) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    public int search_2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while(left < right) { // [)
            int middle = (left + right) / 2;
            if(nums[middle] == target) {
                return middle;
            } else if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }

}
