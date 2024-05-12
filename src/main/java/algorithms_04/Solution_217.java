package algorithms_04;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wheat
 * @date 2024/01/08  15:50
 */
public class Solution_217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if(set.contains(nums[i])) {
                return true;
            } else {
                set.add(nums[i]);
            }
        }
        return false;
    }

}
