package algorithms_00;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/24  10:41
 */
public class Solution_22 {

//    /**
//     * 首先找出n对括号的所有排列方式，然后利用栈判别这些括号是否匹配，这种方式不好写 直接pass
//     * @param n
//     * @return
//     */
//    public List<String> generateParenthesis(int n) {
//
//        // n对括号的所有排列方式
//
//
//    }

//    /**
//     * 暴力破解
//     *      首先生成所有的2n长度的括号序列
//     *      在正确的括号序列中，0到任何位置的子序列中，左括号数一定大于右括号数，并且整个序列号中的左括号数和右括号数相等
//     * @param n
//     * @return
//     */
//    public List<String> generateParenthesis(int n) {
//
//        // 上述过程需要借助递归来实现
//        List<String> resList = new ArrayList<>();
//        generateAll(new char[n*2], 0, resList);
//        return resList;
//
//    }

//    /**
//     * 递归三要素：函数体 边界（结束条件） 递推公式
//     * 局部变量和全局变量 返回值 全部变量由参数传递
//     *
//     * 该题相当于利用树的后序遍历
//     */
//    public void generateAll(char[] current, int pos, List<String> resList){
//
//        // 结束条件
//        if(pos == current.length){
//            if(isVaild(current)) resList.add(new String(current));
//            return;
//        }
//
//        // 函数主体
//        current[pos] = '(';
//        generateAll(current, pos + 1, resList);
//        current[pos] = ')';
//        generateAll(current, pos + 1, resList);
//
//    }
//
//    private boolean isVaild(char[] current){
//
//        int balance = 0;
//        for(int i = 0; i <current.length; i++){
//            if(current[i] == '(') balance++;
//            else if (current[i] == ')') balance--;
//
//            // 左括号数一定大于等于右括号数
//            if(balance < 0) return false;
//        }
//
//        return balance == 0 ? true : false;
//
//    }

    // 借助树的后序遍历实现
    public List<String> generateParenthesis(int n) {

        List<String> resList = new ArrayList<>();

        dfs("", 0, 0, n, resList);

        return resList;

    }

    public void dfs(String current, int left, int right, int n, List<String> resList){
        // 结束条件
        if(left == n && right == n){
            resList.add(current);
        }

        // 剪枝
        if(right > left){
            return;
        }

        if(left < n){
            dfs(current + "(", left + 1, right, n, resList);
        }
        if(right < n){
            dfs(current + ")", left, right + 1, n, resList);
        }

    }

}
