package algorithms_02;

import data_structure.TreeNode;

import java.util.*;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/06  14:55
 */
public class Solution_103 {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root == null) return res;

        queue.add(root);

        boolean flag = true;        // 通过flag实现翻转
        while(!queue.isEmpty()){
            List<Integer> nums = new ArrayList<Integer>();
            int count = queue.size();
            for(int i = 0; i < count; i++){
                TreeNode node = queue.poll();
                nums.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            if(flag){
                res.add(nums);
                flag = false;
            }else{
                Collections.reverse(nums);
                res.add(nums);
                flag = true;
            }
        }

        return res;
    }

}
