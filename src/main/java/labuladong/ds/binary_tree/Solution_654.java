package labuladong.ds.binary_tree;

import data_structure.TreeNode;

/**
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 *  创建一个根节点，其值为 nums 中的最大值。
 *  递归地在最大值 左边 的 子数组前缀上 构建左子树。
 *  递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 * @author wheat
 * @date 2024/04/14  15:50
 */
public class Solution_654 {

    /**
     * 分解问题思路
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length - 1);
    }

    /**
     * 分解问题思路
     * 递归函数定义：
     * @param nums
     * @param left
     * @param right
     * @return
     */
    private TreeNode constructMaximumBinaryTree(int[] nums, int left, int right) {
        // 结束条件 base case
        if (left > right) {
            return null;
        }

        // 找出最大值
        int indexOfMax = left;
        for (int i = left; i <= right; i++) {
            if (nums[i] > nums[indexOfMax]) indexOfMax = i;
        }

        // 利用递归函数定义，构造左右子树
        TreeNode leftChild = constructMaximumBinaryTree(nums, left, indexOfMax - 1);
        TreeNode rightChild = constructMaximumBinaryTree(nums, indexOfMax + 1, right);

        // 后序位置
        TreeNode root = new TreeNode(nums[indexOfMax]);
        root.left = leftChild;
        root.right = rightChild;
        return root;
    }

}
