package algorithms_15;

import javax.lang.model.element.VariableElement;
import java.util.*;

/**
 * 给你一个字符串 s 。我们要把这个字符串划分为尽可能多的片段，同一字母最多出现在一个片段中。
 * 注意，划分结果需要满足：将所有划分结果按顺序连接，得到的字符串仍然是 s 。
 * 返回一个表示每个字符串片段的长度的列表。
 *
 * @author wheat
 * @date 2024/05/24  15:32
 */
public class Solution_763 {

    /**
     * Map + Set
     * @param s
     * @return
     */
    public List<Integer> partitionLabels(String s) {
        List<Integer> res = new ArrayList<>();
        // 剩余字符及其个数
        HashMap<Character, Integer> map = new HashMap<>();
        for (char ch : s.toCharArray()) {
            if (!map.containsKey(ch)) {
                map.put(ch, 0);
            }
            map.put(ch, map.get(ch) + 1);
        }

        int index = 0;
        int pre = 0;
        // 当前窗口内包含的字符
        HashSet<Character> set = new HashSet<>();
        while (index < s.length()) {
            set.add(s.charAt(index));
            map.put(s.charAt(index), map.get(s.charAt(index)) - 1);
            boolean flag = true;
            for (Character ch : set) {
                if (map.get(ch) != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(index + 1 - pre);
                pre = index + 1;
                set = new HashSet<Character>();
            }
            index++;
        }

        return res;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    public List<Integer> partitionLabels_2(String s) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        // 存储字母出现的最大索引
        int[] maxIndexs = new int[26];
        for (int i = 0; i < n; i++) {
            maxIndexs[s.charAt(i) - 'a'] = i;
        }

        int start = 0, index = 0;
        while (index < n) {
            // 每一次找分割点的最远索引是maxIdx
            int maxIndex = maxIndexs[s.charAt(index) - 'a'];
            while (index < n && index <= maxIndex) {
                maxIndex = Math.max(maxIndex, maxIndexs[s.charAt(index) - 'a']);
                index++;
            }
            res.add(index - start);
            start = index;
        }
        return res;
    }

}
