package labuladong.ds.binary_tree;

import data_structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 *
 * preorder 和 inorder 均 无重复 元素
 * @author wheat
 * @date 2024/04/14  21:21
 */
public class Solution_105 {

    /**
     * 分解问题思路
     * 递归函数定义
     *
     * 可以用hashMap存储inorder中value和index的映射关系，减少遍历次数
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTree(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 分解问题思路
     * 递归函数定义
     * @param preorder
     * @param preorderLeft
     * @param preorderRight
     * @param inorder
     * @param inorderLeft
     * @param inorderRight
     * @return
     */
    private TreeNode buildTree(int[] preorder, int preorderLeft, int preorderRight,
                               int[] inorder, int inorderLeft, int inorderRight) {
        // base case
        if (preorderLeft > preorderRight) return null;

        // 根节点是preorder的第一个元素，找到inorder中根节点的位置，将inorder分为左右子树
        int rootVal = preorder[preorderLeft];
        int rootIndexInInorder = -1;
        for (int i = inorderLeft; i <= inorderRight; i++) {
            if (inorder[i] == rootVal) {
                rootIndexInInorder = i;
                break;
            }
        }

        // 根节点
        TreeNode root = new TreeNode(rootVal);

        // 利用递归函数定义分别构造左右子树
        root.left = buildTree(preorder, preorderLeft + 1, preorderLeft + (rootIndexInInorder - inorderLeft),
                inorder, inorderLeft, rootIndexInInorder - 1);
        root.right = buildTree(preorder, preorderLeft + (rootIndexInInorder - inorderLeft) + 1, preorderRight,
                inorder, rootIndexInInorder + 1, inorderRight);

        return root;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------
     */

    /**
     * 存储 inorder 中值到索引的映射 - 值唯一
     */
    private HashMap<Integer, Integer> valToIndex = new HashMap<>();

    /**
     * labuladong
     * @param preorder
     * @param inorder
     * @return
     */
    public TreeNode buildTree_2(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1,
                inorder, 0, inorder.length - 1);
    }

    /**
     * 遍历思路
     * 递归函数定义：
     * @param preorder
     * @param preStart
     * @param preEnd
     * @param inorder
     * @param inStart
     * @param inEnd
     * @return
     */
    TreeNode build(int[] preorder, int preStart, int preEnd,
                   int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 利用递归函数定义构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, index + 1, inEnd);

        return root;
    }

}
