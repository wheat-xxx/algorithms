package labuladong.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
 * <p>
 * 括号的合法性判断 栈
 * 合法括号的生成 回溯
 * <p>
 * 合法括号的判断：
 * 一个「合法」括号组合的左括号数量一定等于右括号数量
 * 对于一个「合法」的括号字符串组合 p，必然对于任何 0 <= i < len(p) 都有：子串 p[0..i] 中左括号的数量都大于或等于右括号的数量
 *
 * @author wheat
 * @date 2024/04/25  9:06
 */
public class Solution_22 {

    /**
     * 思路：回溯算法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        backtrack(n * 2, 0, 0, 0);
        return res;
    }

    /**
     * 返回结果
     */
    private List<String> res = new ArrayList<>();
    /**
     * 路径
     */
    private StringBuilder track = new StringBuilder();

    /**
     * 回溯算法
     *
     * @param n
     * @param index
     * @param left_count
     * @param right_count
     */
    private void backtrack(int n, int index, int left_count, int right_count) {

        // base case
        // 不合法，左括号少于右括号
        if (left_count < right_count) return;
        if (index == n) {
            // 当所有括号都恰好用完时，得到一个合法的括号组合
            if (left_count == right_count) {
                res.add(track.toString());
            }
            return;
        }

        // 回溯算法核心框架
        // 添加左括号
        track.append('(');  // 做选择
        backtrack(n, index + 1, left_count + 1, right_count);
        track.deleteCharAt(track.length() - 1);     // 撤销选择

        // 添加右括号
        track.append(')');      // 做选择
        backtrack(n, index + 1, left_count, right_count + 1);
        track.deleteCharAt(track.length() - 1); // 撤销选择
    }

}
