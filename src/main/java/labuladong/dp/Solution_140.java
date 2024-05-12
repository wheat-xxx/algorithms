package labuladong.dp;

import java.lang.management.MemoryNotificationInfo;
import java.util.*;

/**
 * 给定一个字符串 s 和一个字符串字典 wordDict ，在字符串 s 中增加空格来构建一个句子，使得句子中所有的单词都在词典中。以任意顺序 返回所有这些可能的句子。
 * 注意：词典中的同一个单词可能在分段中被重复使用多次。
 * @author wheat
 * @date 2024/04/20  8:29
 */
@SuppressWarnings("DuplicateExpressions")
public class Solution_140 {

    /**
     * 回溯算法
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        backtrack(s, 0);

        List<String> retVal = new ArrayList<>();
        for (List<String> words : res) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                sb.append(word).append(" ");
            }
            retVal.add(sb.toString().trim());
        }
        return retVal;
    }

    private List<String> wordDict;
    /**
     * 记录结果
     */
    private List<List<String>> res = new ArrayList<>();
    /**
     * 记录回溯算法的路径
     */
    private List<String> track = new ArrayList<>();

    /**
     * 回溯框架
     * @param s
     * @param index
     */
    private void backtrack(String s, int index) {
        // base case
        // 找到一个合法组合
        if (index == s.length()) {
            res.add(new ArrayList<>(track));
            return;
        }

        // 回溯框架
        for (int i = 0; i < wordDict.size(); i++) {
            int len =  wordDict.get(i).length();
            // 看看哪个单词能够匹配 s[i..] 的前缀
            if (index + len <= s.length() && s.substring(index, index + len).equals(wordDict.get(i))) {
                // 找到一个单词匹配 s[i..i+len)
                // 做选择
                track.add(wordDict.get(i));
                // 进入回溯树的下一层，继续匹配 s[i+len..]
                backtrack(s, index + len);
                // 撤销选择
                track.remove(track.size() - 1);
            }
        }

    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 动态规划思路 自顶向下
     * 明确dp函数定义
     * @param s
     * @param wordDict
     * @return
     */
    public List<String> wordBreak_2(String s, List<String> wordDict) {
        this.wordDictSet = new HashSet<>(wordDict);
        this.memo = new List[s.length()];

        return dp(s, 0);
    }

    private Set<String> wordDictSet;
    private List<String>[] memo;

    /**
     * dp函数定义：返回用 wordDict 构成 s[i..] 的所有可能
     * @param s
     * @param index
     * @return
     */
    private List<String> dp(String s, int index) {
        List<String> res = new ArrayList<>();

        if (index == s.length()) {
            res.add("");
            return res;
        }

        // 防止冗余计算
        if (memo[index] != null) return memo[index];

        // 遍历 s[i..] 的所有前缀
        for (int len = 0; index + len <= s.length(); len++) {
            // 看看哪些前缀存在 wordDict 中
            if (wordDictSet.contains(s.substring(index, index + len))) {
                // 找到一个单词匹配 s[i..i+len)
                List<String> subProblem = dp(s, index + len);
                // 构成 s[i+len..] 的所有组合加上 prefix
                // 就是构成构成 s[i] 的所有组合
                for (String string : subProblem) {
                    res.add((s.substring(index, index + len) + " " + string).trim());
                }
            }
        }

        // 存入备忘录
        memo[index] = res;
        return res;
    }


}
