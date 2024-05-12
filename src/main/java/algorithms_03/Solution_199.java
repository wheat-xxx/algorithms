package algorithms_03;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author wheat
 * @date 2023/12/18  15:09
 */
public class Solution_199 {

    /**
     * 通过层序遍历 保存最后一个节点
     * 借助双队列实现
     * @param root
     * @return
     */
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();

        queue1.add(root);
        boolean flag = true;    // 用于区分不同层的遍历

        while(!queue1.isEmpty() || !queue2.isEmpty()) {
            if(flag) {
                TreeNode temp = queue1.poll();
                if(temp.left != null) queue2.add(temp.left);
                if(temp.right != null) queue2.add(temp.right);
                if(queue1.isEmpty()) {
                    res.add(temp.val);
                    flag = false;
                }
            }else {
                TreeNode temp = queue2.poll();
                if(temp.left != null) queue1.add(temp.left);
                if(temp.right != null) queue1.add(temp.right);
                if(queue2.isEmpty()) {
                    res.add(temp.val);
                    flag = true;
                }
            }
        }

        return res;
    }

    public List<Integer> rightSideView_2(TreeNode root) {
        List<Integer> res = new ArrayList<>();

        if(root == null) return res;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()) {
            int count = queue.size();
            TreeNode work = null;
            for (int i = 0; i < count; i++) {
                work = queue.poll();
                if(work.left != null) queue.add(work.left);
                if(work.right != null) queue.add(work.right);
            }
            res.add(work.val);
        }

        return res;
    }

}
