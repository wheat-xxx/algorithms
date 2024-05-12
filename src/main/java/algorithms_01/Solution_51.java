package algorithms_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *      按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 *      n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击
 * @author wheat
 * @date 2023/03/06  21:31
 */
public class Solution_51 {

    /**
     * 分析：
     *      这个可以利用决策树进行求解
     */

    private List<List<String>> res = new ArrayList<>();
    private List<String> path = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        dfs(n, 1);
        return res;
    }

    public void dfs(int size, int row){
        // 递归结束条件
        if(row == size + 1){
            res.add(new ArrayList<String>(path));
        }

        // 每行中的每个格子都进行尝试
        label:
        for(int index = 1; index <= size; index++){

            // 判断是否符合条件 这里只需判断 列 和 斜对角线 是否满足条件
            //列
            for(int i = 1; i < row; i++){
                if(path.get(i - 1).charAt(index - 1) == 'Q') continue label;
            }
            // 正斜线
            int i = row - 1, j = index - 1;
            while(i >= 1 && j >= 1){
                if(path.get(i - 1).charAt(j - 1) == 'Q') continue label;
                i--;j--;
            }
            // 反斜线
            i = row - 1; j = index + 1;
            while(i >= 1 && j <= size){
                if(path.get(i - 1).charAt(j - 1) == 'Q') continue label;
                i--; j++;
            }


            // 如果符合条件 填入棋子
            StringBuilder sb = new StringBuilder();
            for(int k = 0; k < size; k++){
                if(k == index - 1){
                    sb.append('Q');
                }else{
                    sb.append('.');
                }
            }
            path.add(sb.toString());

            // 进入递归
            dfs(size, row + 1);

            path.remove(path.size() - 1);
        }
    }

    @Test
    public void test(){
        solveNQueens(4);
    }


}
