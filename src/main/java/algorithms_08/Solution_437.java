package algorithms_08;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。
 * 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。
 *
 * 递归函数一定要弄明白递归函数的作用和返回值是什么
 *
 * @author wheat
 * @date 2024/05/13  22:43
 */
public class Solution_437 {

    /**
     * 暴力解法
     * 访问每一个节点 node，检测以 node 为起始节点且向下延深的路径有多少种
     * 递归函数定义：返回以root为根的二叉树里之和等于 targetSum 的 路径 的数目
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int res = 0;
        res += rootSum(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    /**
     * 检测以 root 为起始节点且向下延深的路径有多少种
     * @param root
     * @param targetSum
     * @return
     */
    private int rootSum(TreeNode root, long targetSum) {
        if (root == null) return 0;

        int res = 0;
        if (targetSum == root.val) res += 1;
        res += rootSum(root.left, targetSum - root.val);
        res += rootSum(root.right, targetSum - root.val);
        return res;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */


    /**
     * 前缀和思路
     * @param root
     * @param targetSum
     * @return
     */
    public int pathSum_2(TreeNode root, int targetSum) {
        // 初始化
        prefix.put(0L, 1);
        return dfs(root, targetSum);
    }

    /**
     * preSum -> count
     */
    private Map<Long, Integer> prefix = new HashMap<>();
    /**
     * 路径
     */
    private long track = 0;

    /**
     * 深度优先
     * @param root
     * @param targetSum
     */
    private int dfs(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int res = 0;
        // 前序位置
        track += root.val;
        res += prefix.getOrDefault(track - targetSum, 0);
        prefix.put(track, prefix.getOrDefault(track, 0) + 1);
        // 进入下一层递归
        res += dfs(root.left, targetSum);
        res += dfs(root.right, targetSum);
        // 后续位置
        prefix.put(track, prefix.get(track) - 1);
        track -= root.val;

        return res;
    }



}
