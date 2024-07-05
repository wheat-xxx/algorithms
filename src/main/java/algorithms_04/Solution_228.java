package algorithms_04;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个 无重复元素 的 有序 整数数组 nums 。
 * 返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表 。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
 * 列表中的每个区间范围 [a,b] 应该按如下格式输出：
 * "a->b" ，如果 a != b
 * "a" ，如果 a == b
 *
 * @author wheat
 * @date 2024/06/12  8:49
 */
public class Solution_228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        StringBuilder sb = new StringBuilder();
        sb.append(nums[0]).append("->");
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                res.add(sb.toString().substring(0, sb.length() - 2));
                sb = new StringBuilder();
            }
            sb.append(nums[i]).append("->");
        }
        res.add(sb.toString().substring(0, sb.length() - 2));
        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    public List<String> summaryRanges_2(int[] nums) {
        List<String> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[j] - nums[j - 1] != 1) {
                if (j - i == 1) {
                    res.add(String.valueOf(nums[i]));
                } else {
                    res.add(nums[i] + "->" + nums[j - 1]);
                }
                i = j;
            }
            j++;
        }

        // 处理最后一个子区间
        if (j - i == 1) {
            res.add(String.valueOf(nums[i]));
        } else {
            res.add(nums[i] + "->" + nums[j - 1]);
        }

        return res;
    }

}
