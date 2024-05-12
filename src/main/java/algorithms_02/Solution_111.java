package algorithms_02;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *      如果是最小深度 则利用层序遍历最为方便
 *
 * @author wheat
 * @date 2023/04/11  17:07
 */
public class Solution_111 {

    public int minDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);

        int minDepth = 0;

        label:
        while(!queue.isEmpty()){
            int size = queue.size();
            minDepth++;
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                if(node.left == null && node.right == null) break label;
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
        }

        return minDepth;
    }

}
