package capriccio.array;

/**
 * 给你一个 非严格递增排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * @author wheat
 * @date 2024/03/18  22:27
 */
public class Solution_26 {

    /**
     * 快慢指针
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        int slowIndex = -1;
        for(int fastIndex = 0; fastIndex < nums.length; fastIndex++) {
            // 选择拷贝重复元素序列中的最后一个元素
            if(fastIndex + 1 < nums.length && nums[fastIndex] == nums[fastIndex + 1]) {
                continue;
            }
            nums[++slowIndex] = nums[fastIndex];
        }
        return slowIndex + 1;
    }

}
