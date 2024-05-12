package labuladong.ds.binary_tree.BST;

import data_structure.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
 * @author wheat
 * @date 2024/04/15  15:44
 */
public class Solution_230 {

    /**
     * 遍历思路 借助外部变量
     * @param root
     * @param k
     * @return
     */
    public int kthSmallest(TreeNode root, int k) {
        // 利用 BST 的中序遍历特性
        traverse(root, k);
        return res;
    }

    // 记录结果
    private int res = 0;
    // 记录当前元素的排名
    private int rank = 0;
    private void traverse(TreeNode root, int k) {
        if (root == null) {
            return;
        }
        traverse(root.left, k);
        /* 中序遍历代码位置 */
        rank++;
        if (k == rank) {
            // 找到第 k 小的元素
            res = root.val;
            return;
        }
        /*****************/
        traverse(root.right, k);
    }

}
