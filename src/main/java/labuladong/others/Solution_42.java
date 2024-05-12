package labuladong.others;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 *
 * @author wheat
 * @date 2024/05/10  10:39
 */
public class Solution_42 {

    /**
     * 暴力解法
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int l_max = 0, r_max = 0;
            // 找左边最高的柱子
            for (int j = 0; j <= i; j++) {
                l_max = Math.max(l_max, height[j]);
            }
            // 找右边最高的柱子
            for (int j = i; j < height.length; j++) {
                r_max = Math.max(r_max, height[j]);
            }
            res += Math.min(l_max, r_max) - height[i];
        }
        return res;
    }

    /**
     * 备忘录
     * @param height
     * @return
     */
    public int trap_2(int[] height) {
        int[] l_max = new int[height.length];
        int[] r_max = new int[height.length];
        // 初始化
        l_max[0] = height[0];
        r_max[height.length - 1] = height[height.length - 1];
        // 从左向右计算 l_max
        for (int i = 1; i < height.length; i++) {
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }

        int res = 0;
        for (int i = 1; i < height.length - 1; i++) {
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }
        return res;
    }

    /**
     * 双指针法
     * @param height
     * @return
     */
    public int trap_3(int[] height) {
        int left = 0, right = height.length - 1;
        int l_max = 0, r_max = 0;
        int res = 0;
        while (left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            if (l_max < r_max) {
                res += l_max - height[left];
                left++;
            } else {
                res += r_max - height[right];
                right--;
            }
        }
        return res;
    }

}
