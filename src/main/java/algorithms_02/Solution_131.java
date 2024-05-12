package algorithms_02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案
 *      回文串 是正着读和反着读都一样的字符串
 * @author wheat
 * @date 2023/11/28  15:00
 */
public class Solution_131 {

    private List<List<String>> result = new ArrayList<>();
    private List<String> ans = new ArrayList<>();
    // 动态规划
    private boolean[][] dp;
    private int s_length;

    public List<List<String>> partition(String s){
        // 边界情况
        if(s == null || s.length() == 0) return result;

        // 动态规划
        this.s_length = s.length();
        dp = new boolean[this.s_length][this.s_length];
        for (int i = 0; i < this.s_length; i++) {
            Arrays.fill(dp[i], true);
        }
        /*
        * f(i,j) = true ,i>=j
        * f(i,j) = f(i+1, j-1) and s[i] == s[j] ,otherwise
        * */
        for (int i = this.s_length - 1; i >= 0; i--) {
            for (int j = i + 1; j < this.s_length; j++) {
                dp[i][j] = dp[i+1][j-1] && (s.charAt(i) == s.charAt(j));
            }
        }

        dfs(s, 0);
        return result;
    }

    public void dfs(String s, int i) {
        if(i == this.s_length) {
            result.add(new ArrayList<>(ans));
            return;
        }

        for (int j = i; j < this.s_length; j++) {
            if(dp[i][j]) {
                ans.add(s.substring(i, j+1));
                dfs(s, j + 1);
                ans.remove(ans.size() - 1);
            }
        }
    }

}
