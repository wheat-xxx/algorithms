package labuladong.ds.binary_tree.BST;

import data_structure.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 二叉搜索树中插入一个节点
 * @author wheat
 * @date 2024/04/16  8:49
 */
public class BST_insert {

    /**
     * 先找后插 迭代实现
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }

        TreeNode parent = null;
        TreeNode work = root;
        while (work != null) {
            // 存在val，则不再插入
            if (work.val == val) {
                return root;
            }

            // 向下查找插入位置
            parent = work;
            if (work.val < val) {
                work = work.right;
            } else {
                work = work.left;
            }
        }

        // val的父节点是parent
        if (val < parent.val) {
            parent.left = new TreeNode(val);
        } else {
            parent.right = new TreeNode(val);
        }

        return root;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 递归实现
     * 递归函数定义：如果是空树，创建节点并返回；否则向其子树插入，并返回根节点
     * @param root
     * @param val
     * @return
     */
    public TreeNode insertIntoBST_2(TreeNode root, int val) {
        // base case
        if (root == null) {
            return new TreeNode(val);
        }

        // if (root.val == val)
        // BST 中一般不会插入已存在元素

        if (val < root.val) {
            root.left = insertIntoBST_2(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST_2(root.right, val);
        }

        return root;
    }

}
