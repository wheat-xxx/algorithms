package labuladong.dp;

import java.util.*;

/**
 * 给你一个字符串 s 和一个字符串列表 wordDict 作为字典。如果可以利用字典中出现的一个或多个单词拼接出 s 则返回 true。
 * 注意：不要求字典中出现的单词全部都使用，并且字典中的单词可以重复使用。
 *
 * 思路：可以从字符串出发找单词，也可以从字典出发拼凑字符串
 *
 * 回溯算法一定要画决策树
 * @author wheat
 * @date 2024/04/19  20:16
 */
public class Solution_139 {

    /**
     * test
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(20, 10, 15, 1, 8, 30, 22, 6);
        // 返回正数说明a > b, 排列：b, a
        Collections.sort(nums, (Integer a, Integer b) -> (a.intValue() - b.intValue()));
        System.out.println(nums);
    }


    /**
     * 解法：回溯算法 从字典中拼凑字符串
     * 超出时间限制
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        backtrack(s, wordDict);
        return flag;
    }

    private boolean flag = false;

    /**
     *
     * @param s
     * @param wordDict
     */
    private void backtrack(String s, List<String> wordDict) {
        // 避免不必要的递归
        if (flag) return;

        // 回溯算法框架
        for (int i = 0; i < wordDict.size(); i++) {
            if (s.length() >= wordDict.get(i).length() && s.substring(0, wordDict.get(i).length()).equals(wordDict.get(i))) {
                if (s.length() == wordDict.get(i).length()) {
                    flag = true;
                    return;
                }

                backtrack(s.substring(wordDict.get(i).length()), wordDict);
            }
        }

    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    public boolean wordBreak_2(String s, List<String> wordDict) {
        this.wordDict = wordDict;
        // 执行回溯算法穷举所有可能的组合
        backtrack(s, 0);
        return found;
    }

    private List<String> wordDict;
    // 记录是否找到一个合法的答案
    private boolean found = false;
    // 记录回溯算法的路径
    private List<String> track = new ArrayList<>();

    /**
     * 回溯算法框架
     * @param s
     * @param index
     */
    private void backtrack(String s, int index) {
        // base case
        if (found) return;
        // 整个 s 都被匹配完成，找到一个合法答案
        if (index == s.length()) {
            found = true;
            return;
        }

        // 回溯算法框架
        for (String word : wordDict) {
            // 看看哪个单词能够匹配 s[i..] 的前缀
            int len = word.length();
            if (index + len <= s.length() && s.substring(index, index + len).equals(word)) {
                // 找到一个单词匹配 s[i..i+len)
                // 做选择
                track.add(word);
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
     * 动态规划思路   自顶向下
     * base case 是 dp(s, s.length())
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_3(String s, List<String> wordDict) {
        // 转化为哈希集合，快速判断元素是否存在
        this.wordDictSet = new HashSet<>(wordDict);
        // 备忘录初始化为 -1
        this.memo = new int[s.length()];
        Arrays.fill(memo, -1);
        return dp(s, 0);
    }

    /*
    用哈希集合方便快速判断是否存在
     */
    private HashSet<String> wordDictSet;
    /**
     * 备忘录，-1 代表未计算，0 代表无法凑出，1 代表可以凑出
     */
    private int[] memo;

    /**
     * 递归函数定义：s[i..] 是否能够被拼出
     * @param s
     * @param i
     * @return
     */
    boolean dp(String s, int i) {
        // base case
        if (i == s.length()) {
            return true;
        }
        // 防止冗余计算
        if (memo[i] != -1) {
            return memo[i] == 0 ? false : true;
        }

        // 遍历 s[i..] 的所有前缀
        for (int len = 1; i + len <= s.length(); len++) {
            // 看看哪些前缀存在 wordDict 中
            String prefix = s.substring(i, i + len);
            if (wordDictSet.contains(prefix)) {
                // 找到一个单词匹配 s[i..i+len)
                // 只要 s[i+len..] 可以被拼出，s[i..] 就能被拼出
                boolean subProblem = dp(s, i + len);
                if (subProblem == true) {
                    memo[i] = 1;
                    return true;
                }
            }
        }
        // s[i..] 无法被拼出
        memo[i] = 0;
        return false;
    }

}
