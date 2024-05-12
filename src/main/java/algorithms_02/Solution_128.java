package algorithms_02;

import java.util.HashSet;
import java.util.Set;

/**
 * 最长连续数列
 * @author wheat
 * @date 2023/09/02  16:37
 */
public class Solution_128 {

    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for(int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;
        for(int num : numSet) {
            if(!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while(numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }

}
