package algorithms_04;

import data_structure.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 所有 Node.val 互不相同 。
 *
 * 这个题好难
 *
 * @author wheat
 * @date 2024/05/21  21:39
 */
public class Solution_236 {

    /**
     * 递归函数定义：返回值是什么
     * 给该函数输入三个参数 root，p，q，它会返回一个节点：
     *   情况 1，如果 p 和 q 都在以 root 为根的树中，函数返回的即使 p 和 q 的最近公共祖先节点。
     *   情况 2，那如果 p 和 q 都不在以 root 为根的树中怎么办呢？函数理所当然地返回 null 呗。
     *   情况 3，那如果 p 和 q 只有一个存在于 root 为根的树中呢？函数就会返回那个节点（p或q）。
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // base case
        if (root == null) return null;
        if (root == p || root == q) return root;

        // 进入下一层递归
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 后续位置
        if (left == null && right == null) {
            return null;
        }
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;

    }

}
