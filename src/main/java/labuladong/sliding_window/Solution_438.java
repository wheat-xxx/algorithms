package labuladong.sliding_window;

import java.util.*;

/**
 * 给定两个字符串 s 和 p，找到 s 中所有 p 的 异位词 的子串，返回这些子串的起始索引。不考虑答案输出的顺序。
 * 异位词 指由相同字母重排列形成的字符串（包括相同的字符串）。
 * @author wheat
 * @date 2024/03/26  8:23
 */
public class Solution_438 {

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }

        if (Arrays.equals(sCount, pCount)) {
            res.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;

            if (Arrays.equals(sCount, pCount)) {
                res.add(i + 1);
            }
        }
        return res;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    public List<Integer> findAnagrams_2(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s.length() < p.length()) return res;

        int[] sCount = new int[26];
        int[] pCount = new int[26];
        for (int i = 0; i < p.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            pCount[p.charAt(i) - 'a']++;
        }
        int valid = 0;
        for (int i = 0; i < 26; i++) {
            if (sCount[i] >= pCount[i]) {
                valid++;
            }
        }

        if (valid == 26) {
            res.add(0);
        }

        for (int i = 0; i < s.length() - p.length(); i++) {
            if (sCount[s.charAt(i) - 'a'] == pCount[s.charAt(i) - 'a']) {
                valid--;
            }
            sCount[s.charAt(i) - 'a']--;
            sCount[s.charAt(i + p.length()) - 'a']++;
            if (sCount[s.charAt(i + p.length()) - 'a'] == pCount[s.charAt(i + p.length()) - 'a']) {
                valid++;
            }

            if (valid == 26) {
                res.add(i + 1);
            }
        }
        return res;
    }

}
