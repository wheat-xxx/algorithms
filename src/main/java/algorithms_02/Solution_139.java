package algorithms_02;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author wheat
 * @date 2023/10/31  14:54
 */
public class Solution_139 {

    /**
     * 没有考虑到同一位置可能有多个匹配单词
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        int index = 0;
        out:while(index < s.length()) {
            for(int i = 0; i < wordDict.size(); i++) {
                String word = wordDict.get(i);
                if(word.length() + index <= s.length() && word.equals(s.substring(index, index + word.length()))){
                    index = index + word.length();
                    continue out;
                }
            }
            return false;
        }
        return true;
    }


    //-------------------------------------------------------------------------------------------------------------------

    private String s;
    private List<String> wordDict;

    /**
     * 使用dfs实现 超出时间限制
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_2(String s, List<String> wordDict) {
        this.s = s;
        this.wordDict = wordDict;
        return dfs(0);
    }

    private boolean dfs(int index) {
        if(index >= this.s.length()) {
            return true;
        }

        for (int i = 0; i < wordDict.size(); i++) {
            String word = wordDict.get(i);
            if (word.length() + index <= s.length() && word.equals(s.substring(index, index + word.length()))) {
                boolean flag = dfs(index + word.length());
                if(flag == true) {
                    return true;
                }else {
                    continue;
                }
            }
        }
        return false;
    }

    //-------------------------------------------------------------------------------------------------------------------

    /**
     * 动态规划 dp[i] = dp[j] && check(s[j, i-1])
     * @param s
     * @param wordDict
     * @return
     */
    public boolean wordBreak_3(String s, List<String> wordDict) {
        Set<String> wordDictSet = new HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for(int i = 1; i <= s.length(); i++) {
            for(int j = 0; j < i; j++) {
                if(dp[j] && wordDictSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

}
