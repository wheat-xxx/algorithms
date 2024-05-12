package labuladong.ds.binary_tree;

import data_structure.TreeNode;

/**
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @author wheat
 * @date 2024/04/14  9:37
 */
public class Solution_226 {

    // 主函数
    public TreeNode invertTree(TreeNode root) {
        // 遍历二叉树，交换每个节点的子节点
        traverse(root);
        return root;
    }

    // 二叉树遍历函数
    private void traverse(TreeNode root) {
        if (root == null) {
            return;
        }

        /**** 前序位置 ****/
        // 每一个节点需要做的事就是交换它的左右子节点
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;

        // 遍历框架，去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 分解问题的思路
     * 递归函数定义：将以 root 为根的这棵二叉树翻转，返回翻转后的二叉树的根节点
     * @param root
     * @return
     */
    public TreeNode invertTree_2(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 利用递归函数定义，先翻转左右子树
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        // 然后交换左右子节点
        root.left = right;
        root.right = left;

        // 和递归函数定义逻辑自恰：以 root 为根的这棵二叉树已经被翻转，返回 root
        return root;
    }

}
