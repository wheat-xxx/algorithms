package labuladong.ds.binary_tree.BST;

import data_structure.TreeNode;

/**
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 * @author wheat
 * @date 2024/04/16  8:34
 */
public class Solution_700 {

    /**
     * 正常思路 针对一般树
     * @param root
     * @param val
     * @return
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) return null;

        if (root.val == val) return root;
        // 当前节点没找到就递归地去左右子树寻找
        TreeNode left = searchBST(root.left, val);
        TreeNode right = searchBST(root.right, val);

        return left != null ? left : right;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 利用二叉搜索树的定义
     * @param root
     * @param target
     * @return
     */
    public TreeNode searchBST_2(TreeNode root, int target) {
        if (root == null) {
            return null;
        }
        // 去左子树搜索
        if (root.val > target) {
            return searchBST(root.left, target);
        }
        // 去右子树搜索
        if (root.val < target) {
            return searchBST(root.right, target);
        }
        return root;
    }

}
