package labuladong.ds.binary_tree;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 动归/DFS/回溯算法都可以看做二叉树问题的扩展，只是它们的关注点不同：
 * 动态规划算法属于分解问题的思路，它的关注点在整棵「子树」。
 * 回溯算法属于遍历的思路，它的关注点在节点间的「树枝」。
 * DFS 算法属于遍历的思路，它的关注点在单个「节点」。
 * @author wheat
 * @date 2024/04/11  14:36
 */
public class dp_backtrack_dfs {

    /**
     * 动态规划算法属于分解问题的思路，它的关注点在整棵「子树」
     * 输入一棵二叉树，返回这棵二叉树的节点总数
     *
     * 这就是动态规划分解问题的思路，它的着眼点永远是结构相同的整个子问题，类比到二叉树上就是「子树」。
     * @param root
     * @return
     */
    public int count(TreeNode root) {
        if (root == null) return 0;
        // 我这个节点关心的是我的两个子树的节点总数分别是多少
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        // 后序位置，左右子树节点数加上自己就是整棵树的节点数
        return leftCount + rightCount + 1;
    }

    /**
     * 可以画出斐波那契数列的树结构
     * @param N
     * @return
     */
    public int fib(int N) {
        if (N == 1 || N == 2) return 1;
        return fib(N - 1) + fib(N - 2);
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 给你一棵二叉树，请你用遍历的思路写一个 traverse 函数，打印出遍历这棵二叉树的过程
     * @param root
     */
    public void traverse(TreeNode root) {
        if (root == null) return;
        System.out.printf("从节点 %s 进入节点 %s", root, root.left);
        traverse(root.left);
        System.out.printf("从节点 %s 回到节点 %s", root.left, root);

        System.out.printf("从节点 %s 进入节点 %s", root, root.right);
        traverse(root.right);
        System.out.printf("从节点 %s 回到节点 %s", root.right, root);
    }

    /**
     * 多叉树节点
     */
    private class Node {
        int val;
        List<Node> children;
    }

    /**
     * 多叉树的遍历框架
     * @param root
     */
    public void traverse(Node root) {
        if (root == null) return;
        for (Node child : root.children) {
            System.out.printf("从节点 %s 进入节点 %s", root, child);
            traverse(child);
            System.out.printf("从节点 %s 回到节点 %s", child, root);
        }
    }

//    /**
//     * 回溯算法的框架
//     * 回溯算法遍历的思路，它的着眼点永远是在节点之间移动的过程，类比到二叉树上就是「树枝」。
//     * @param selectList
//     */
//    public void backtrack(List selectList) {
//        for (int i = 0; i < selectList.size(); i++) {
//            // 做选择
//
//            // 进入下一层决策树
//            backtrack(selectList);
//
//            // 撤销选择
//        }
//    }


    /**
     * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列
     * 回溯算法
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        this.res = new ArrayList<>();
        this.used = new boolean[nums.length];
        backtrack(new ArrayList<Integer>());

        return res;
    }

    private int[] nums;
    private List<List<Integer>> res;
    private boolean[] used;

    /**
     * 路径：记录在 work 中
     * 选择列表：nums 中不存在于 work 的那些元素（used[i] 为 false）
     * 结束条件：nums 中的元素全都在 track 中出现
     * @param work
     */
    private void backtrack(List<Integer> work) {
        // 结束条件
        if(work.size() == nums.length) {
            res.add(new ArrayList<>(work));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // 排除不合法的选择
            if(used[i]) continue;

            // 做选择
            work.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(work);
            // 撤销选择
            work.remove(work.size() - 1);
            used[i] = false;
        }
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * DFS 算法遍历的思路，它的着眼点永远是在单一的节点上，类比到二叉树上就是处理每个「节点」
     *
     * DFS 算法把「做选择」「撤销选择」的逻辑放在 for 循环外面
     * @param root
     */
    public void dfs(Node root) {
        if (root == null) return;
        // 做选择
        System.out.printf("我已经进入节点 %s 啦", root);
        for (Node child : root.children) {
            dfs(child);
        }
        // 撤销选择
        System.out.printf("我将要离开节点 %s 啦", root);
    }

}
