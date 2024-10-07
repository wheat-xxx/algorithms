package algorithms_02;

import java.util.*;

/**
 * 最长连续数列
 * @author wheat
 * @date 2023/09/02  16:37
 */
public class Solution_128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }

        int longestConsecutive = 0;
        for(int num : set) {
            // 不是序列最小值跳过
            if (set.contains(num - 1)) continue;

            int currentConsecutive = 0;
            while(set.contains(num++)) currentConsecutive++;

            longestConsecutive = Math.max(longestConsecutive, currentConsecutive);
        }

        return longestConsecutive;
    }

}
