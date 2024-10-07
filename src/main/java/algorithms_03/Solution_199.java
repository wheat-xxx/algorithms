package algorithms_03;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值
 * @author wheat
 * @date 2023/12/18  15:09
 */
public class Solution_199 {

    /**
     * 通过层序遍历 保存最后一个节点
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode work = null;
            for (int i = 0; i < size; i++) {
                work = queue.poll();
                if(work.left != null) queue.add(work.left);
                if(work.right != null) queue.add(work.right);
            }
            res.add(work.val);
        }

        return res;
    }

}
