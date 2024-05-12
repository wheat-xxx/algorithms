package algorithms_00;

/**
 * Description:
 *      实现 pow(x, n) ，即计算 x 的整数 n 次幂函数（即，xn ）。
 * @author wheat
 * @date 2023/03/06  20:54
 */
public class Solution_50 {

    /**
     * 超出时间限制
     * @param x
     * @param n
     * @return
     */
//    public double myPow(double x, int n) {
//
//        if(x == 0) return 0;
//
//        double res = 1;
//        for(int i = 0; i < Math.abs(n); i++){
//            res *= x;
//        }
//
//        return n < 0 ? 1/res : res;
//    }

    // 使用递归进行计算
    public double myPow(double x, int n){
        long N = n;
        return N < 0 ? 1/dfs(x, -N) : dfs(x, N);
    }

    public double dfs(double x, long N){
        // 递归结束条件
        if(N == 0) return 1;

        double halfValue = dfs(x, N/2);

        return halfValue * halfValue * ((N % 2) == 1 ? x : 1);
    }

}
