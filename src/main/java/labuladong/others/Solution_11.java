package labuladong.others;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * 返回容器可以储存的最大水量。
 *
 * @author wheat
 * @date 2024/05/10  10:26
 */
public class Solution_11 {

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int res = 0;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                int cur = (j - i) * Math.min(height[i], height[j]);
                if (res < cur) {
                    res = cur;
                }
            }
        }
        return res;
    }

    /**
     * 双指针解法
     * 此问题有两个变量分别是长和宽 可以控制一个变量 长最好控制
     * @param height
     * @return
     */
    public int maxArea_2(int[] height) {
        int i = 0, j = height.length - 1;
        int res = 0;
        while (i < j) {
            int curArea = (j - i) * Math.min(height[i], height[j]);
            res = Math.max(res, curArea);
            // 更新i, j
            if (height[i] < height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

}
