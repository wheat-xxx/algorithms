package labuladong.others;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 给你一个由数字和运算符组成的字符串 expression ，按不同优先级组合数字和运算符，计算并返回所有可能组合的结果。你可以 按任意顺序 返回答案。
 * expression 由数字和算符 '+'、'-' 和 '*' 组成
 * 输入表达式中的所有整数值在范围 [0, 99]
 *
 * 回溯算法就是一个暴力穷举算法
 * 动态规划肯定是求最值的，动态规划问题具有最优子结构，可以通过状态转移方程从小规模的子问题最优解推导出大规模问题的最优解
 * 分治算法：将原问题分解成小规模的子问题，原问题的结果可以通过合并子问题结果来计算
 *
 * 计算机思维的精髓：将大规模问题分解成小规模问题递归求解
 *
 * @author wheat
 * @date 2024/05/06  8:19
 */
public class Solution_241 {

    /**
     * 分治算法
     * 可以以每个运算符作为划分
     * 函数定义：计算算式 input 所有可能的运算结果
     * @param expression
     * @return
     */
    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> res = new ArrayList<>();

        // 分治算法核心部分
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '+' || expression.charAt(i) == '-' || expression.charAt(i) == '*') {
                // 分
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1, expression.length()));
                // 合
                for (Integer leftVal : left) {
                    for (Integer rightVal : right) {
                        if (expression.charAt(i) == '+') {
                            res.add(leftVal + rightVal);
                        }
                        if (expression.charAt(i) == '-') {
                            res.add(leftVal - rightVal);
                        }
                        if (expression.charAt(i) == '*') {
                            res.add(leftVal * rightVal);
                        }
                    }
                }
            }
        }

        // base case
        // 如果 res 为空，说明算式是一个数字，没有运算符
        if (res.size() == 0) {
            res.add(Integer.parseInt(expression));
        }

        return res;
    }

}
