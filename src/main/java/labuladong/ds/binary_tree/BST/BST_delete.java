package labuladong.ds.binary_tree.BST;

import data_structure.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * 在 BST 中删除一个数
 * @author wheat
 * @date 2024/04/16  9:37
 */
public class BST_delete {

    /**
     * 迭代实现
     * 有多种情况
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) return null;

        // 查找key和key的父节点
        TreeNode parent = null;
        TreeNode work = root;
        while (work != null && work.val != key) {
            parent = work;
            if (key < work.val) {
                work = work.left;
            } else {
                work = work.right;
            }
        }

        // 树中没有key
        if (work == null) return root;

        // 树中存在key节点
        if (work.left == null) {    // key只有右孩子
            if (parent == null) {   // key是根节点，让根节点指向key的右孩子
                return work.right;
            } else if (work == parent.left) {
                parent.left = work.right;
            } else {
                parent.right = work.right;
            }
        } else if (work.right == null) {    // key只有左孩子
            if (parent == null) {
                return work.left;
            } else if (work == parent.left) {
                parent.left = work.left;
            } else {
                parent.right = work.left;
            }
        } else {    // key的左右孩子都不为空 选择key的右子树的最小值代替key
            TreeNode minRightParent = work;
            TreeNode minRight = work.right;
            while(minRight.left != null) {
                minRightParent = minRight;
                minRight = minRight.left;
            }
            // 交换节点的值
            work.val = minRight.val;
            // 处理被删除节点处
            if (minRightParent.left == minRight) {
                minRightParent.left = minRight.right;
            } else {
                minRightParent.right = minRight.right;
            }
        }

        return root;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 分解问题思路 -- 递归实现
     * 递归函数定义：删除key节点，并返回删除之后的根节点
     * @param root
     * @param key
     * @return
     */
    public TreeNode deleteNode_2(TreeNode root, int key) {
        if (root == null) return null;
        // 前序遍历位置
        if (root.val == key) {
            //  key没有子节点或者只有一个非空子节点，那么它要让这个孩子接替自己的位置
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // key有两个子节点，key必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己，选择第二种
            // 获得右子树最小的节点
            TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点 最小的节点一定没有左子树 转为第一种情况
            root.right = deleteNode_2(root, minNode.val);
            // 用右子树最小的节点替换 root 节点
            root.val = minNode.val;
        } else if (key < root.val) {
            root.left = deleteNode_2(root.left, key);
        } else {
            root.right = deleteNode_2(root.right, key);
        }

        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) root = root.left;
        return root;
    }
}
