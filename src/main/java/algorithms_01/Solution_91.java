package algorithms_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/28  15:23
 */
public class Solution_91 {

//    private int count = 0;
////    private StringBuilder path = new StringBuilder();
////    private List<String> res = new ArrayList<String>();
//
//    public int numDecodings(String s){
//
//        // 边界条件
//        if(s == null || s.length() == 0 || s.charAt(0) == '0') return count;
//
//        dfs(s, 0);
//
//        return count;
//    }
//
//    private void dfs(String s, int index){
//        // 递归结束条件
//        if(index == s.length()){
//            count++;
////            res.add(path.toString());
//            return;
//        }
//
//        // 无法正确映射的字符串
//        if(s.charAt(index) == '0') return;
//
//        // 当前调用需要做的事情
////        path.append(s.charAt(index)); path.append(" ");
//        dfs(s, index + 1);
////        path.delete(path.length() - 2, path.length());
//
//        if(index + 1 < s.length() && ((s.charAt(index) == '2' && s.charAt(index + 1) <= '6') || s.charAt(index) == '1')){
////            path.append(s, index, index + 2); path.append(" ");
//            dfs(s, index + 2);
////            path.delete(path.length() - 3, path.length());
//        }
//    }

    // 动态规划思路
//    public int numDecodings(String s) {
//
//        int[] dp = new int[s.length() + 1];
//        dp[0] = 1;
//        for(int i = 0; i < s.length(); i++){
//            if(s.charAt(i) >= '1' && s.charAt(i) <= '9') dp[i + 1] = dp[i];
//            if(i > 0 && s.charAt(i - 1) != '0' && (s.charAt(i - 1) - '0') * 10 + s.charAt(i) - '0' <= 26) dp[i + 1] += dp[i - 1];
//        }
//        return dp[s.length()];
//    }


}
