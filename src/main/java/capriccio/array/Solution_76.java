package capriccio.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 * @author wheat
 * @date 2024/03/20  8:45
 */
public class Solution_76 {
    private Map<Character, Integer> tMap = new HashMap<>();
    private Map<Character, Integer> workMap = new HashMap<>();

    /**
     * 滑动窗口
     * @param s
     * @param t
     * @return
     */
    public String minWindow(String s, String t) {

        int tLength = t.length();
        for (int i = 0; i < tLength; i++) {
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0;
        String res = null;
        int sLength = s.length();
        for (int right = 0; right < sLength; right++) {
            if (tMap.containsKey(s.charAt(right))) {
                workMap.put(s.charAt(right), workMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while(check()) {
                if(res == null || res.length() > (right - left + 1)) {
                    res = s.substring(left, right + 1);
                }
                if(tMap.containsKey(s.charAt(left))) {
                    workMap.put(s.charAt(left), workMap.get(s.charAt(left)) - 1);
                }
                left++;
            }
        }
        return res == null ? "" : res;
    }

    private boolean check() {
//        Iterator<Map.Entry<Character, Integer>> iterator = tMap.entrySet().iterator();
//        while(iterator.hasNext()) {
//            Map.Entry<Character, Integer> entry = iterator.next();
//            if(workMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
//                return false;
//            }
//        }
//        return true;

        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if(workMap.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

}
