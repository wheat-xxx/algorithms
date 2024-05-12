package labuladong.ds.array_list;

/**
 * 差分数组工具类
 *
 * 差分数组的主要适用场景是频繁对原始数组的某个区间的元素进行增减。
 * @author wheat
 * @date 2024/04/11  21:57
 */
public class DifferenceArray {

    /**
     * 差分数组
     */
    private int[] diff;

    /**
     * 输入一个初始数组，区间操作将在这个数组上进行
     * 递推公式：nums[i] = nums[i - 1] + diff[i]
     * @param nums
     */
    public DifferenceArray(int[] nums) {
        assert nums.length > 0;
        int len = nums.length;
        diff = new int[len];
        // 根据初始数组构造差分数组
        diff[0] = nums[0];
        for (int i = 1; i < len; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
    }

    /**
     * 给闭区间 [i, j] 增加 val（可以是负数）
     * @param i
     * @param j
     * @param val
     */
    public void increment(int i, int j, int val) {
        diff[i] += val;
        if (j + 1 < diff.length) {
            diff[j + 1] -= val;
        }
    }

    public int[] result() {
        int len = diff.length;
        int[] res = new int[len];
        // 根据差分数组构造结果数组
        res[0] = diff[0];
        for (int i = 1; i < len; i++) {
            res[i] = res[i - 1] + diff[i];
        }
        return res;
    }

}
