package algorithms_04;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wheat
 * @date 2023/12/19  15:51
 */
public class Solution_205 {

    public boolean isIsomorphic(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character, Character> map = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))) {
                if(map.getOrDefault(s.charAt(i), '*') != t.charAt(i)) return false;
                else continue;
            } else {
                if(map.containsValue(t.charAt(i))) {
                    return false;
                } else {
                    map.put(s.charAt(i), t.charAt(i));
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        new Solution_205().isIsomorphic("egg", "add");
    }

}
