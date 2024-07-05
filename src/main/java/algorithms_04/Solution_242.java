package algorithms_04;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的字母异位词。
 * 注意：若 s 和 t 中每个字符出现的次数都相同，则称 s 和 t 互为字母异位词。
 *
 * @author wheat
 * @date 2024/06/09  16:38
 */
public class Solution_242 {

//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//        int n = s.length();
//
//        Map<Character, Integer> map = new HashMap<>();
//        for (int i = 0; i < n; i++) {
//            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        for (int i = 0; i < n; i++) {
//            if (!map.containsKey(t.charAt(i))) {
//                return false;
//            } else {
//                map.put(t.charAt(i), map.get(t.charAt(i)) - 1);
//            }
//        }
//
//        for (Integer value : map.values()) {
//            if (value != 0) {
//                return false;
//            }
//        }
//
//        return true;
//    }

    /**
     * good
     * @param s
     * @param t
     * @return
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int n = s.length();

        int[] counts = new int[26];

        for (int i = 0; i < n; i++) {
            counts[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < n; i++) {
            int index = t.charAt(i) - 'a';
            if (--counts[index] < 0) {
                return false;
            }
        }

        return true;
    }

}
