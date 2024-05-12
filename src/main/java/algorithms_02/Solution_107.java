package algorithms_02;

import data_structure.TreeNode;

import java.util.*;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/11  9:43
 */
public class Solution_107 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        // 边界情况
        if(root == null) return res;

        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> list = new ArrayList<Integer>();
            int size = queue.size();
            for(int i = 0; i < size; i++){
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(list);
        }

        Collections.reverse(res);

        return res;
    }

}
