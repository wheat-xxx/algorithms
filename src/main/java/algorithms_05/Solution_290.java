package algorithms_05;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种规律 pattern 和一个字符串 s ，判断 s 是否遵循相同的规律。
 * 这里的 遵循 指完全匹配，例如， pattern 里的每个字母和字符串 s 中的每个非空单词之间存在着双向连接的对应规律。
 *
 * 注意：一一对应
 *
 * @author wheat
 * @date 2024/06/09  16:37
 */
public class Solution_290 {

    /**
     * 一一映射
     * @param pattern
     * @param s
     * @return
     */
    public boolean wordPattern(String pattern, String s) {

        int n = pattern.length();
        // char -> str
        Map<Character, String> c2s = new HashMap<>();
        // str -> char
        Map<String, Character> s2c = new HashMap<>();
        String[] splits = s.split("\\s+");
        if (n != splits.length) {
            return false;
        }

        for (int i = 0; i < n; i++) {
            if (c2s.containsKey(pattern.charAt(i))) {
                if (!c2s.get(pattern.charAt(i)).equals(splits[i])) {
                    return false;
                }
            }
            if (s2c.containsKey(splits[i])) {
                if (!s2c.get(splits[i]).equals(pattern.charAt(i))) {
                    return false;
                }
            }
            c2s.put(pattern.charAt(i), splits[i]);
            s2c.put(splits[i], pattern.charAt(i));
        }

        return true;
    }



}
