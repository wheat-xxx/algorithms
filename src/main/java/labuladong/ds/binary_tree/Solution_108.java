package labuladong.ds.binary_tree;

import data_structure.TreeNode;

/**
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵平衡二叉搜索树
 * @author wheat
 * @date 2024/10/03  14:29
 */
public class Solution_108 {

    /**
     * 递归解法
     * 分解问题思路 - 动态规划
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return dp(nums, 0, nums.length - 1);
    }

    /**
     * 递归
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public TreeNode dp(int[] nums, int left, int right) {
        // 边界
        if (left > right) {
            return null;
        }

        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        // 左子树
        root.left = dp(nums, left, mid - 1);
        // 右子树
        root.right = dp(nums, mid + 1, right);

        return root;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 迭代 写不了
     * @param nums
     * @return
     */
    public TreeNode sortedArrayToBST_2(int[] nums) {
        return null;
    }

}
