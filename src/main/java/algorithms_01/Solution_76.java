package algorithms_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Description:
 *
 *      给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
 *
 * @author wheat
 * @date 2023/03/13  15:51
 */
public class Solution_76 {

    Map<Character, Integer> sMap = new HashMap<Character, Integer>();
    Map<Character, Integer> tMap = new HashMap<>();

    public String minWindow(String s, String t){
        // 特殊情况
        if(s.length() < t.length()) return "";

        for(int i = 0; i < t.length();i++){
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        int left = 0, right = 0;
        int minLen = Integer.MAX_VALUE;
        int resL = -1, resR = -1;
        while(right < s.length()){
            // 更新 right 指针
            if(tMap.containsKey(s.charAt(right))){
                sMap.put(s.charAt(right), sMap.getOrDefault(s.charAt(right), 0) + 1);
            }

            // 如果此时窗口满足条件 则查看是否可以更新最小值
            while(check() && left <= right){
                if(right - left + 1 < minLen){
                    minLen = right - left + 1;
                    resL = left;
                    resR = right;
                }
                if(tMap.containsKey(s.charAt(left))){
                    sMap.put(s.charAt(left), sMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                left++;
            }

            right++;
        }

        return resL == -1 ? "" : s.substring(resL, resR + 1);
    }

    private boolean check(){
        Iterator<Map.Entry<Character, Integer>> iter = tMap.entrySet().iterator();
        while(iter.hasNext()){
            Map.Entry<Character, Integer> entry = iter.next();
            Character key = entry.getKey();
            Integer value = entry.getValue();
            if(sMap.getOrDefault(key, 0) < value) return false;
        }
        return true;
    }

}
