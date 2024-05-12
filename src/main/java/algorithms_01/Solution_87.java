package algorithms_01;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/20  15:01
 */
public class Solution_87 {

//    /**
//     * 递归求解  正确但是超出时间
//     * @param s1
//     * @param s2
//     * @return
//     */
//    public boolean isScramble(String s1, String s2) {
//        return dfs(s1, s2);
//    }
//
//    public boolean dfs(String s1, String s2){
//        // 边界条件
//        if(s1.length() == 1){
//            if(s1.equals(s2)) return true;
//            else return false;
//        }
//
//        // 逐个位置进行切割
//        for(int i = 0; i < s1.length() - 1; i++){
//            // 交换
//            boolean swap = dfs(s1.substring(0, i + 1), s2.substring(s2.length() - i - 1,s2.length()))
//                    && dfs(s1.substring(i + 1, s1.length()), s2.substring(0, s2.length() - i - 1));
//            // 不交换
//            boolean noSwap = dfs(s1.substring(0, i + 1), s2.substring(0, i + 1))
//                    && dfs(s1.substring(i + 1, s1.length()), s2.substring(i + 1, s2.length()));
//            if(swap || noSwap) return true;
//        }
//        return false;
//    }


    /**
     * 通过词频减少运行时间
     */
//    public boolean isScramble(String s1, String s2) {
//        if(s1.equals(s2)) return true;
//        if(!check(s1, s2)) return false;
//
//        // 逐个位置进行切割
//        for(int i = 0; i < s1.length() - 1; i++){
//            // 交换
//            boolean swap = isScramble(s1.substring(0, i + 1), s2.substring(s2.length() - i - 1,s2.length()))
//                    && isScramble(s1.substring(i + 1, s1.length()), s2.substring(0, s2.length() - i - 1));
//            // 不交换
//            boolean noSwap = isScramble(s1.substring(0, i + 1), s2.substring(0, i + 1))
//                    && isScramble(s1.substring(i + 1, s1.length()), s2.substring(i + 1, s2.length()));
//            if(swap || noSwap) return true;
//        }
//        return false;
//
//    }
//
//    public boolean check(String s1, String s2){
//        if(s1.length() != s2.length()) return false;
//        int[] map1 = new int[26];
//        int[] map2 = new int[26];
//
//        for(int i = 0; i < s1.length(); i++){
//            map1[s1.charAt(i) - 'a']++;
//            map2[s2.charAt(i) - 'a']++;
//        }
//
//        for(int i = 0; i < 26; i++){
//            if(map1[i] != map2[i]) return false;
//        }
//
//        return true;
//    }


    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        int n = s1.length();
        char[] cs1 = s1.toCharArray(), cs2 = s2.toCharArray();
        boolean[][][] f = new boolean[n][n][n + 1];

        // 先处理长度为 1 的情况
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                f[i][j][1] = cs1[i] == cs2[j];
            }
        }

        // 再处理其余长度情况
        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                for (int j = 0; j <= n - len; j++) {
                    for (int k = 1; k < len; k++) {
                        boolean a = f[i][j][k] && f[i + k][j + k][len - k];
                        boolean b = f[i][j + len - k][k] && f[i + k][j][len - k];
                        if (a || b) {
                            f[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return f[0][0][n];
    }


}
