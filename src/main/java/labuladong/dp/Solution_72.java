package labuladong.dp;

import java.util.Arrays;

/**
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * 你可以对一个单词进行如下三种操作：
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 * <p>
 * 解决两个字符串的动态规划问题，一般都是用两个指针 i, j 分别指向两个字符串的最后，然后一步步往前移动，缩小问题的规模
 *
 * @author wheat
 * @date 2024/04/22  8:35
 */
public class Solution_72 {

    /**
     * 动态规划 - 暴力解法
     * 超出时间限制 -> memo
     * 重叠子问题
     *
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        this.memo = new int[word1.length()][word2.length()];
        for (int i = 0; i < this.memo.length; i++) {
            Arrays.fill(this.memo[i], -1);
        }
        return dp(word1, word1.length() - 1, word2, word2.length() - 1);
    }

    private int[][] memo;

    /**
     * dp函数定义：定义：返回 s1[0..i] 和 s2[0..j] 的最小编辑距离
     * dp递归函数：最开始输入的原问题规模 然后借用递归不断缩减问题规模
     * <p>
     * 先确定dp函数定义 然后再确定base case
     *
     * @param s1
     * @param i
     * @param s2
     * @param j
     * @return
     */
    private int dp(String s1, int i, String s2, int j) {

        // base case
        if (i == -1 || j == -1) {
            return Math.abs(i - j);
        }

        // 查备忘录，避免重叠子问题
        if (this.memo[i][j] != -1) {
            return this.memo[i][j];
        }

        // 状态转移 结果存入备忘录
        int res = -1;
        if (s1.charAt(i) == s2.charAt(j)) {
            res = dp(s1, i - 1, s2, j - 1);
        } else {
            // 问题规模 n -> n - 1
            // s1[i] != s2[j]
            res = min(
                    dp(s1, i, s2, j - 1) + 1, // 插入
                    dp(s1, i - 1, s2, j) + 1,    // 删除
                    dp(s1, i - 1, s2, j - 1) + 1     // 替换
            );
        }

        this.memo[i][j] = res;
        return res;

    }

    private int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * dp-迭代解法-自低向上
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance_2(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        // 定义：s1[0..i] 和 s2[0..j] 的最小编辑距离是 dp[i+1][j+1]
        int[][] dp = new int[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }
        // 自底向上求解
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(
                            dp[i - 1][j], // 删除
                            dp[i][j - 1], // 插入
                            dp[i - 1][j - 1]   // 替换
                    ) + 1;
                }
            }
        }
        // 储存着整个 s1 和 s2 的最小编辑距离
        return dp[m][n];
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 记录每一步最小编辑距离的路径
     * @param s1
     * @param s2
     * @return
     */
    public int minDistance_3(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        Node[][] dp = new Node[m + 1][n + 1];
        // base case
        for (int i = 0; i <= m; i++) {
            // s1 转化成 s2 只需要删除一个字符
            dp[i][0] = new Node(i, 2);
        }
        for (int j = 1; j <= n; j++) {
            // s1 转化成 s2 只需要插入一个字符
            dp[0][j] = new Node(j, 1);
        }
        // 状态转移方程
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    // 如果两个字符相同，则什么都不需要做
                    Node node = dp[i - 1][j - 1];
                    dp[i][j] = new Node(node.val, 0);
                } else {
                    // 否则，记录代价最小的操作
                    dp[i][j] = minNode(
                            dp[i - 1][j],
                            dp[i][j - 1],
                            dp[i-1][j-1]
                    );
                    // 并且将编辑距离加一
                    dp[i][j].val++;
                }
            }
        }
        // 根据 dp table 反推具体操作过程并打印
        printResult(dp, s1, s2);
        return dp[m][n].val;
    }

    // 计算 delete, insert, replace 中代价最小的操作
    private Node minNode(Node a, Node b, Node c) {
        Node res = new Node(a.val, 2);

        if (res.val > b.val) {
            res.val = b.val;
            res.choice = 1;
        }
        if (res.val > c.val) {
            res.val = c.val;
            res.choice = 3;
        }
        return res;
    }

    private void printResult(Node[][] dp, String s1, String s2) {
        int rows = dp.length;
        int cols = dp[0].length;
        int i = rows - 1, j = cols - 1;
        System.out.println("Change s1=" + s1 + " to s2=" + s2 + ":\n");
        while (i != 0 && j != 0) {
            char c1 = s1.charAt(i - 1);
            char c2 = s2.charAt(j - 1);
            int choice = dp[i][j].choice;
            System.out.print("s1[" + (i - 1) + "]:");
            switch (choice) {
                case 0:
                    // 跳过，则两个指针同时前进
                    System.out.println("skip '" + c1 + "'");
                    i--; j--;
                    break;
                case 1:
                    // 将 s2[j] 插入 s1[i]，则 s2 指针前进
                    System.out.println("insert '" + c2 + "'");
                    j--;
                    break;
                case 2:
                    // 将 s1[i] 删除，则 s1 指针前进
                    System.out.println("delete '" + c1 + "'");
                    i--;
                    break;
                case 3:
                    // 将 s1[i] 替换成 s2[j]，则两个指针同时前进
                    System.out.println(
                            "replace '" + c1 + "'" + " with '" + c2 + "'");
                    i--; j--;
                    break;
            }
        }
        // 如果 s1 还没有走完，则剩下的都是需要删除的
        while (i > 0) {
            System.out.print("s1[" + (i - 1) + "]:");
            System.out.println("delete '" + s1.charAt(i - 1) + "'");
            i--;
        }
        // 如果 s2 还没有走完，则剩下的都是需要插入 s1 的
        while (j > 0) {
            System.out.print("s1[0]:");
            System.out.println("insert '" + s2.charAt(j - 1) + "'");
            j--;
        }
    }

    private class Node {
        int val;
        int choice;
        Node(int val, int choice) {
            this.val = val;
            this.choice = choice;
        }
        // 0 代表啥都不做
        // 1 代表插入
        // 2 代表删除
        // 3 代表替换
    }

}
