package algorithms_04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wheat
 * @date 2024/01/08  15:55
 */
public class Solution_219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // key - data value - index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

}
