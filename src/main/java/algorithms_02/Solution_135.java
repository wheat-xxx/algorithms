package algorithms_02;

import java.util.Arrays;

/**
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 *   每个孩子至少分配到 1 个糖果。
 *   相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的最少糖果数目。
 *
 * @author wheat
 * @date 2024/05/29  8:35
 */
public class Solution_135 {

    /**
     * 无脑遍历
     * @param ratings
     * @return
     */
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] res = new int[n];
        Arrays.fill(res, 1);
        boolean flag = true;
        while (flag) {
            flag = false;
            for (int i = 0; i < n; i++) {
                if (i - 1 >= 0 && ratings[i - 1] > ratings[i] && res[i - 1] <= res[i]) {
                    res[i - 1] = res[i] + 1;
                    flag = true;
                }
                if (i + 1 < n && ratings[i + 1] > ratings[i] && res[i + 1] <= res[i]) {
                    res[i + 1] = res[i] + 1;
                    flag = true;
                }
            }
        }

        int sum = 0;
        for (int count : res) {
            sum += count;
        }

        return sum;
    }

}
