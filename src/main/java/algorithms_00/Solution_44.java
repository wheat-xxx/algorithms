package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *      给定一个字符串 (s) 和一个字符模式 (p) ，实现一个支持 '?' 和 '*' 的通配符匹配。
 *      '?' 可以匹配任何单个字符。
 *      '*' 可以匹配任意字符串（包括空字符串）。
 * @author wheat
 * @date 2023/03/04  21:50
 */
public class Solution_44 {

    /**
     * 分析
     *      * 是最难处理的
     *      可以利用长度信息对 * 进行处理
     * @param s
     * @param p
     * @return
     */

    public boolean isMatch(String s, String p) {

        // 边界条件
        if(s == null || p == null) return true;

        // 列表示模式串 行表示匹配串
        /**
         *   a b d e f a c g y c
         *  a
         *  *
         *  ?
         *  c
         */
        // 利用二维数组表示是否有路径从左上角到右下角
        boolean[][] dp = new boolean[p.length() + 1][s.length() + 1];

        dp[0][0] =true;
        // 如果是以 * 开头 则需要对第一列进行初始化
        for(int i = 1; i < dp.length; i++){
            if(p.charAt(i - 1) == '*'){
                dp[i][0] = true;
            }else{
                break;
            }
        }

        // 对二维数组整体进行处理
        for(int i = 1; i < dp.length; i++){
            for(int j = 1; j < dp[i].length; j++){
                // 如果模式串中当前字符是 * 需要进行单独处理
                if (p.charAt(i-1) == '*') {
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                } else if (p.charAt(i - 1) == '?' || p.charAt(i - 1) == s.charAt(j - 1)){
                    dp[i][j] = dp[i-1][j-1];
                }
            }
        }
        return dp[p.length()][s.length()];
    }


    @Test
    public void test(){
        String s = "";
        String p = "******";
        isMatch(s, p);
    }

}
