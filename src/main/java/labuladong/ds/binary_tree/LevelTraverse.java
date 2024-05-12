package labuladong.ds.binary_tree;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的层序遍历
 * @author wheat
 * @date 2024/04/11  15:06
 */
public class LevelTraverse {

    /**
     * 输入一棵二叉树的根节点，层序遍历这棵二叉树
     * @param root
     */
    void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        // 从上到下遍历二叉树的每一层
        while (!queue.isEmpty()) {
            int sz = queue.size();
            // 从左到右遍历每一层的每个节点
            for (int i = 0; i < sz; i++) {
                TreeNode cur = queue.poll();
                // 将下一层节点放入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }

}
