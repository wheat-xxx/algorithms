package algorithms_10;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 * 差值是一个正数，其数值等于两值之差的绝对值。
 *
 * @author wheat
 * @date 2024/06/12  14:23
 */
public class Solution_530 {

    /**
     * 一般树的解决方案
     * @param root
     * @return
     */
    public int getMinimumDifference(TreeNode root) {
        traverse(root);
        Collections.sort(nums);
        int[] diff = new int[nums.size() - 1];
        for (int i = 1; i < nums.size(); i++) {
            diff[i - 1] = nums.get(i) - nums.get(i - 1);
        }

        int res = Integer.MAX_VALUE;
        for (int i = 0; i < diff.length; i++) {
            if (res > diff[i]) res = diff[i];
        }

        return res;
    }

    private List<Integer> nums = new ArrayList<>();

    private void traverse(TreeNode root) {
        if (root == null) return;

        nums.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    private TreeNode pre = null;
    private int res = Integer.MAX_VALUE;

    /**
     * 二叉搜索树的解决方案 - 中序遍历 有序列表
     * @param root
     * @return
     */
    public int getMinimumDifference_2(TreeNode root) {
        getDiff(root);
        return res;
    }

    private void getDiff(TreeNode root) {
        if (root == null) {
            return;
        }

        getDiff(root.left);
        // 中序遍历位置
        if (pre != null) {
            res = Math.min(res, root.val - pre.val);
        }
        pre = root;
        getDiff(root.right);
    }

}
