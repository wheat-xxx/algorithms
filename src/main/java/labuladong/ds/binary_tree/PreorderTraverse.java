package labuladong.ds.binary_tree;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wheat
 * @date 2024/03/21  10:16
 */
public class PreorderTraverse {

    private List<Integer> res = new ArrayList<>();

    /**
     * 二叉树思路：遍历思路
     * @param root
     * @return
     */
    public List<Integer> preorderTraverse(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if(root == null) return;

        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 二叉树思路：分解问题思路
     * 一棵二叉树的前序遍历结果 = 根节点 + 左子树的前序遍历结果 + 右子树的前序遍历结果。
     * @param root
     * @return
     */
    public List<Integer> preorderTraverse_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        // 前序遍历的结果，root.val 在第一个
        res.add(root.val);
        // 利用函数定义，后面接着左子树的前序遍历结果
        res.addAll(preorderTraverse_2(root.left));
        // 利用函数定义，最后接着右子树的前序遍历结果
        res.addAll(preorderTraverse_2(root.right));

        return res;
    }


}
