package algorithms_02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wheat
 * @date 2023/10/15  10:32
 */
public class Solution_137 {

    public int singleNumber(int[] nums) {
        if(nums == null) throw new RuntimeException("参数为空！");
        int result = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer value = map.get((Integer) nums[i]);
            if(value == null) {
                map.put((Integer)nums[i], 1);
            } else{
                map.put((Integer)nums[i], map.get((Integer)nums[i]) + 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int key = entry.getKey(), value = entry.getValue();
            if (value == 1) {
                result = key;
                break;
            }
        }

        return result;
    }

}
