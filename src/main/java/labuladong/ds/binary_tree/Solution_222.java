package labuladong.ds.binary_tree;

import data_structure.TreeNode;

/**
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树 的定义如下：在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置
 *
 * 这个题的解法牛逼
 * @author wheat
 * @date 2024/04/16  11:24
 */
public class Solution_222 {

    /**
     * 完全二叉树节点的个数 完全二叉树最后一层只有右边没有节点 寻找最后一个节点的位置
     *
     * root的两个子树一定有一个是完全二叉树
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        int leftLevel = treeLevel(root.left);
        int rightLevel = treeLevel(root.right);

        if(leftLevel == rightLevel) {
            return countNodes(root.right) + (1 << leftLevel);
        } else {
            return countNodes(root.left) + (1 << rightLevel);
        }

    }

    private int treeLevel(TreeNode root) {
        int level = 0;
        while(root != null) {
            level++;
            root = root.left;
        }
        return level;
    }

    public static void main(String[] args) {
        System.out.println(1 << 1);
    }

}
