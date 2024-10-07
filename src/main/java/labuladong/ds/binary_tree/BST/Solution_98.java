package labuladong.ds.binary_tree.BST;

import data_structure.TreeNode;

/**
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 * @author wheat
 * @date 2024/04/15  21:32
 */
public class Solution_98 {

    /**
     * 分解问题的思路
     * 递归函数的定义：
     *
     * 思路错误：不能判断左子树中的所有值是否小于根节点
     * @param root
     * @return
     */
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        boolean right = isValidBST(root.right);

        // 后序遍历位置
        boolean res = true;
        if (root.left != null) {
            res = res && root.left.val < root.val;
        }
        if (root.right != null) {
            res = res && root.val < root.right.val;
        }
        return res && left && right;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 中序遍历的前一个元素
     */
    private long pre = Integer.MIN_VALUE - 1L;

    /**
     * 分解问题思路
     * 递归函数的定义：
     * @param root
     * @return
     */
    public boolean isValidBST_2(TreeNode root) {
        // base case
        if (root == null) return true;

        boolean left = isValidBST(root.left);
        // 中序遍历位置
        if (root.val <= pre) return false;
        // 更新中序遍历的前一个元素
        pre = root.val;
        boolean right = isValidBST(root.right);

        // 后序遍历位置
        return true && left && right;
    }

}
