package capriccio.array;

/**
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 * @author wheat
 * @date 2024/03/18  21:28
 */
public class Solution_27 {

    /**
     * 快慢指针法
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        // fastIndex 用来遍历
        int slowIndex = -1, fastIndex = 0;   // slowIndex 指向什么位置
        while(fastIndex < nums.length) {
            if (nums[fastIndex] != val) {
                nums[++slowIndex] = nums[fastIndex];
            }
            fastIndex++;
        }
        return slowIndex + 1;
    }

}
