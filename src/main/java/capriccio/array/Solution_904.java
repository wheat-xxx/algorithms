package capriccio.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 水果成篮
 * @author wheat
 * @date 2024/03/19  10:43
 */
public class Solution_904 {

    /**
     * 思路：滑动窗口
     * @param fruits
     * @return
     */
    public int totalFruit(int[] fruits) {
        int left = 0;
        int count = 0;  // 记录篮中的水果种类
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < fruits.length; i++) {
            map.put(fruits[i], 0);
        }
        for (int right = 0; right < fruits.length; right++) {
            // 判断篮中是否有此水果种类
            if(map.get(fruits[right]) == 0) {
                count++;
            }
            // 采摘此水果
            map.put(fruits[right], map.get(fruits[right]) + 1);
            // 判断水果种类是否大于2
            while(count > 2) {
                if(map.get(fruits[left]) == 1) {
                    count--;
                }
                map.put(fruits[left], map.get(fruits[left]) - 1);
                left++;
            }
            max = max > (right - left + 1) ? max : (right - left + 1);
        }
        return max;
    }

    public int totalFruit_2(int[] fruits) {
        int left = 0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < fruits.length; right++) {
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2) {
                map.put(fruits[left], map.get(fruits[left]) - 1);
                if(map.get(fruits[left]) == 0) {
                    map.remove(fruits[left]);
                }
                left++;
            }
            ans = ans > (right - left + 1) ? ans : (right - left + 1);
        }
        return ans;
    }

}
