package labuladong.ds.array_list;

/**
 * 假设你有一个长度为 n 的数组，初始情况下所有的数字均为 0，你将会被给出 k 个更新的操作。
 * 其中，每个操作会被表示为一个三元组：[startIndex, endIndex, inc]，
 * 你需要将子数组 A[startIndex ... endIndex]（包括 startIndex 和 endIndex）增加 inc。
 * 请你返回 k 次操作后的数组。
 * @author wheat
 * @date 2024/04/11  22:24
 */
public class Solution_370 {

    public int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分数组
        DifferenceArray differenceArray = new DifferenceArray(nums);

        for (int[] update : updates) {
            differenceArray.increment(update[0], update[1], update[2]);
        }

        return differenceArray.result();
    }

}
