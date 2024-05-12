package algorithms_02;

import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/20  18:08
 */
public class Solution_120 {

//    private List<List<Integer>> triangle;
//    private int min;
//
//    public int minimumTotal(List<List<Integer>> triangle) {
//        this.triangle = triangle;
//        this.min = Integer.MAX_VALUE;
//
//        recursive(0, 0, 0);
//
//        return this.min;
//    }
//
//    public void recursive(int rowIndex, int index, int sum){
//        // 递归结束条件
//        if(rowIndex == this.triangle.size()){
//            this.min = this.min < sum ? this.min : sum;
//            return;
//        }
//
//        // 索引超过三角形范围
//        if(index >= this.triangle.get(rowIndex).size()) return;
//
//        sum += this.triangle.get(rowIndex).get(index);
//
//        recursive(rowIndex + 1, index, sum);
//        recursive(rowIndex + 1, index + 1, sum);
//    }

    public int minimumTotal(List<List<Integer>> triangle){
        int n = triangle.size();
        int[] dp = new int[n];

        dp[0] = triangle.get(0).get(0);

        // 逐行处理
        for(int i = 1; i < n; i++){
            // 逐个元素进行处理 从当前行的最后一个元素开始处理
            for(int j = i; j >= 0; j--){
                if(j == i) dp[j] = dp[j - 1] + triangle.get(i).get(j);
                else if(j == 0) dp[0] += triangle.get(i).get(0);
                else{
                    dp[j] = triangle.get(i).get(j) + (dp[j] < dp[j - 1] ? dp[j] : dp[j - 1]);
                }
            }
        }

        int ret = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++) ret = ret < dp[i] ? ret : dp[i];
        return ret;
    }

}
