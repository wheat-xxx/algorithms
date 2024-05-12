package labuladong.ds.binary_tree;

import data_structure.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 *   展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 *   展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * @author wheat
 * @date 2024/04/14  11:04
 */
public class Solution_114 {

    // 虚拟头节点，dummy.right 就是结果
    TreeNode dummy = new TreeNode(-1);
    // 用来构建链表的指针
    TreeNode p = dummy;

    /**
     * 遍历思路：对整棵树进行前序遍历，一边遍历一边构造出一条「链表」就行了
     * @param root
     */
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        p.right = new TreeNode(root.val);
        p = p.right;

        traverse(root.left);
        traverse(root.right);
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 分解问题思路
     * 递归函数定义：将以root为根的树拉平为链表
     * @param root
     */
    public void flatten(TreeNode root) {
        // base case
        if (root == null) return;

        // 利用递归函数定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode work = root;
        while(work.right != null) {
            work = work.right;
        }
        work.right = right;
    }

}
