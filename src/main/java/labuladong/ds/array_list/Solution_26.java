package labuladong.ds.array_list;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 *
 * 问题核心：
 *      1. slow指向的唯一序列的最后一个元素，还是最后一个元素的下一个位置
 *      2. 重复元素中选择第一个还是最后一个
 * @author wheat
 * @date 2024/03/20  21:08
 */
public class Solution_26 {

    public int removeDuplicates(int[] nums) {
        int slow = 0, fast = 0;    // slow已经指向第一个不重复的元素
        int length = nums.length;
        while(fast < length) {
            if(nums[fast] != nums[slow]) {
                nums[++slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }

}
