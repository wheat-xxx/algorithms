package labuladong.binary_tree;

import data_structure.TreeNode;
import sun.reflect.generics.tree.Tree;

/**
 * @author wheat
 * @date 2024/03/21  9:56
 */
public class Solution_104 {

    /**
     * 二叉树解题思路：分解问题思路
     * 为什么主要的代码逻辑集中在后序位置？
     * 可以通过子树的最大深度推导出原树的深度，所以当然要首先利用递归函数的定义算出左右子树的最大深度，然后推出原树的最大深度，主要逻辑自然放在后序位置。
     * @param root
     * @return
     */
    public int maxDepth(TreeNode root) {
        return getTreeDepth(root);
    }

    private int getTreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthL = getTreeDepth(root.left);
        int depthR = getTreeDepth(root.right);
        return (depthL > depthR ? depthL : depthR) + 1;

    }

    /**
     * 二叉树解题思路：遍历思路
     * 二叉树遍历框架
     * 前序位置是进入一个节点的时候，后序位置是离开一个节点的时候，depth 记录当前递归到的节点深度，你把 traverse 理解成在二叉树上游走的一个指针，所以当然要这样维护。
     * @param root
     * @return
     */
    public int maxDepth_2(TreeNode root) {
        traverse(root);
        return res;
    }

    // 记录最大深度
    private int res = 0;
    // 记录遍历到的节点的深度
    private int depth = 0;

    private void traverse(TreeNode root) {
        if(root != null) {
            // 前序遍历位置
            depth++;
            // 到达叶子节点，更新最大深度
            if(root.left == null && root.right == null) {
                res = Math.max(res, depth);
            }
            traverse(root.left);
            // 中序遍历位置
            traverse(root.right);
            // 后序遍历位置
            depth--;
        }
    }

}
