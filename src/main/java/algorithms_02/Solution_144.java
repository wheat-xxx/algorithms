package algorithms_02;

import data_structure.TreeNode;

import java.util.*;

/**
 * 前序遍历----非递归版本
 *      使用stack
 * @author wheat
 * @date 2023/09/27  11:17
 */
public class Solution_144 {

    public List<Integer> preorderTraversal(TreeNode root) {

        List<Integer> list = new ArrayList<>();

        // 空二叉树
        if(root == null) return list;

        Stack<TreeNode> stack = new Stack<>();
//        Deque<Integer> stack = new LinkedList<>();

        TreeNode node = root;
        while(!stack.isEmpty() || node != null) {
            while(node != null){
                list.add(node.val);
                stack.push(node);
                node = node.left;
            }
            node = stack.pop();
            node = node.right;
        }

        return list;
    }

}

