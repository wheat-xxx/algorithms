package algorithms_00;

import org.junit.Test;

import java.util.*;

/**
 * Description:
 * <p>
 * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
 * <p>
 * 字母异位词 是由重新排列源单词的字母得到的一个新单词，所有源单词中的字母通常恰好只用一次。
 *
 * @author wheat
 * @date 2023/03/06  19:20
 */
public class Solution_49 {

    /**
     * 这是一种很纯的写法
     */
    private List<List<String>> res = new ArrayList<List<String>>();
    private boolean[] used;

    /**
     * 双层for循环
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        if (strs == null || strs.length == 0) return res;

        used = new boolean[strs.length];

        // 针对空串进行特殊处理
        List<String> temp_null = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            if ("".equals(strs[i])) {
                temp_null.add(strs[i]);
                used[i] = true;
            }
        }
        if (!temp_null.isEmpty()) res.add(temp_null);

        for (int i = 0; i < strs.length; i++) {
            // 剪枝
            if (used[i]) {
                continue;
            }

            // 保存中间结果
            List<String> others = new ArrayList<String>();
            Map<Character, Integer> map = new HashMap<Character, Integer>();

            // 统计当前字符串中每个字符的个数 map char -> count
            for (int j = 0; j < strs[i].length(); j++) {
                char key = strs[i].charAt(j);
                map.put(key, map.getOrDefault(key, 0) + 1);
            }
            others.add(strs[i]);
            used[i] = true;

            // 判断是否有字母异位词
            for (int j = i + 1; j < strs.length; j++) {
                // 剪枝
                if (used[j]) {
                    continue;
                }

                // 针对没有处理过的元素进行处理
                // 只有字符长度相等 才有可能属于同一字母异位词
                if (strs[j].length() == strs[i].length()) {
                    Map<Character, Integer> map_temp = new HashMap<Character, Integer>();
                    for (int index = 0; index < strs[j].length(); index++) {
                        char keyTemp = strs[j].charAt(index);
                        map_temp.put(keyTemp, map_temp.getOrDefault(keyTemp, 0) + 1);
                    }
                    if (map.equals(map_temp)) {
                        others.add(strs[j]);
                        used[j] = true;
                    }
                }

            }
            if (!others.isEmpty()) {
                res.add(others);
            }
        }

        return res;

    }

    /**
     * 字母异位词排序后是相等的，可以作为key
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams_2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String key = new String(chs);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }

    public List<List<String>> groupAnagrams_3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
            int[] counts = new int[26];
            for (int i = 0; i < s.length(); i++) {
                counts[s.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < counts.length; i++) {
                if (counts[i] != 0) {
                    sb.append((char) (i + 'a'));
                    sb.append(counts[i]);
                }
            }

            String key = sb.toString();
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(s);
        }

        return new ArrayList<List<String>>(map.values());
    }

    @Test
    public void test() {

    }

}
