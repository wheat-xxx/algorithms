package labuladong.binary_tree;

import data_structure.TreeNode;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。
 * 两节点之间路径的 长度 由它们之间边数表示。
 * 解决这题的关键在于，每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
 * @author wheat
 * @date 2024/03/21  11:00
 */
public class Solution_543 {

    // 记录最大直径的长度
    private int maxDiameter = 0;

    /**
     * 遍历的思路
     * @param root
     * @return
     */
    public int diameterOfBinaryTree(TreeNode root) {
        // 对每个节点计算直径，求最大直径
        traverse(root);
        return maxDiameter;
    }

    /**
     * 每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
     * @param root
     */
    private void traverse(TreeNode root) {
        if(root == null) return;

        // 对每个节点计算直径
        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);
        int currentNodeDiameter = depthL + depthR;
        maxDiameter = maxDiameter > currentNodeDiameter ? maxDiameter : currentNodeDiameter;

        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 计算二叉树的最大深度
     */
    private int maxDepth(TreeNode root) {
        if(root == null) return 0;

        int depthL = maxDepth(root.left);
        int depthR = maxDepth(root.right);
        return 1 + Math.max(depthL, depthR);
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 前序位置无法获取子树信息，所以只能让每个节点调用 maxDepth 函数去算子树的深度。
     * @param root
     * @return
     */
    public int diameterOfBinaryTree_2(TreeNode root) {
        maxDepth_2(root);
        return maxDiameter;
    }

    private int maxDepth_2(TreeNode root) {
        if (root == null) return 0;

        int depthL = maxDepth_2(root.left);
        int depthR = maxDepth_2(root.right);
        // 后序位置，顺便记录最大直径
        int currentNodeDiameter = depthL + depthR;
        maxDiameter = maxDiameter > currentNodeDiameter ? maxDiameter : currentNodeDiameter;

        return 1 + Math.max(depthL, depthR);
    }

}
