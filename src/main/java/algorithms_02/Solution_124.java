package algorithms_02;

import data_structure.TreeNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/27  11:45
 */
public class Solution_124 {

//    public int maxPathSum(TreeNode root){
//        traverse(root);
//        return res;
//    }
//
//    private int res = Integer.MIN_VALUE;
//
//    /**
//     * 二叉树的遍历
//     * @param root
//     */
//    private void traverse(TreeNode root) {
//        if (root == null) return;
//        // 前序位置
//        int left = maxSinglePathSum(root.left);
//        int right = maxSinglePathSum(root.right);
//
////        res = Math.max(res, root.val + left + right);
//        res = Math.max(res, Math.max(root.val, root.val + Math.max(left + right, Math.max(left, right))));
//
//        traverse(root.left);
//        traverse(root.right);
//    }
//
//    /**
//     * 返回以root和树中某个结点为端点的最大路径和
//     * @param root
//     * @return
//     */
//    private int maxSinglePathSum(TreeNode root) {
//        if (root == null) return 0;
//        // 子问题
//        int left = maxSinglePathSum(root.left);
//        int right = maxSinglePathSum(root.right);
//        // 后续位置
//        return Math.max(root.val, root.val + Math.max(left, right));
//    }

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return res;
    }

    private int res = Integer.MIN_VALUE;

    /**
     * 返回以root和树中某个结点为端点的最大路径和
     * @param root
     * @return
     */
    private int traverse(TreeNode root) {
        if (root == null) return 0;

        // 子问题
        int left = traverse(root.left);
        int right = traverse(root.right);

        //递归函数返回值为：以下三者的最大值：
        // （1）我自己就是一条路径
        // （2）只跟左子节点合并成一条路径
        // （3）只跟右子节点合并成一条路径
        int retVal = Math.max(root.val, root.val + Math.max(left, right));

        // 更新全局变量
        // （4）以自己为桥梁，跟左、右子节点合并成一条路径.
        res = Math.max(res, Math.max(retVal, root.val + left + right));

        return retVal;
    }

}
