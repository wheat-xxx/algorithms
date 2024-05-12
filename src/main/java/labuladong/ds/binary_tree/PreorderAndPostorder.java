package labuladong.ds.binary_tree;

import data_structure.TreeNode;

/**
 * 前序位置的代码只能从函数参数中获取父节点传递来的数据，而后序位置的代码不仅可以获取参数数据，还可以获取到子树通过函数返回值传递回来的数据
 * 如果把根节点看做第 1 层，如何打印出每一个节点所在的层数？
 * 如何打印出每个节点的左右子树各有多少节点？
 *
 * 一个节点在第几层，你从根节点遍历过来的过程就能顺带记录，用递归函数的参数就能传递下去；
 * 而以一个节点为根的整棵子树有多少个节点，你需要遍历完子树之后才能数清楚，然后通过递归函数的返回值拿到答案。
 *
 * 那么换句话说，一旦你发现题目和子树有关，那大概率要给函数设置合理的定义和返回值，在后序位置写代码了
 * @author wheat
 * @date 2024/04/11  11:14
 */
public class PreorderAndPostorder {

    /**
     * 如果把根节点看做第 1 层，如何打印出每一个节点所在的层数
     * @param root
     */
    public void printNodeLevel(TreeNode root) {
        traverse(root, 1);
    }

    private void traverse(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        // 前序位置
        System.out.printf("节点 %s 在第 %d 层", root, level);
        traverse(root.left, level + 1);
        traverse(root.right, level + 1);
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 如何打印出每个节点的左右子树各有多少节点？
     * @param root
     * @return
     */
    public int countChildTreeNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // 递归
        int countLeft = countChildTreeNodes(root.left);
        int countRight = countChildTreeNodes(root.right);

        // 后序位置
        System.out.printf("节点 %s 的左子树有 %d 个节点，右子树有 %d 个节点", root, countLeft, countRight);

        return countLeft + countRight;
    }

}
