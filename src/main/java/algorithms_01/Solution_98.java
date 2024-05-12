package algorithms_01;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/04  14:55
 */
public class Solution_98 {

//    private List<Integer> res = new ArrayList<Integer>();
//
//    // 先进行前序遍历 然后判断是否是递增序列
//    public boolean isValidBST(TreeNode root) {
//
//        inorderTraversal(root);
//
//        for(int i = 0; i < res.size() - 1; i++){
//            if(res.get(i) >= res.get(i + 1)) return false;
//        }
//
//        return true;
//
//    }
//
//    public void inorderTraversal(TreeNode root){
//
//        if(root != null){
//            inorderTraversal(root.left);
//            // 中序遍历进行的操作
//            res.add(root.val);
//            inorderTraversal(root.right);
//        }
//
//    }

    private long pre = Long.MIN_VALUE;

    public boolean isValidBST(TreeNode root){

        // 中序遍历 如果当前节点值小于等于上一个遍历的节点值 则不是BST
        return inorderTraversal(root);

    }

    public boolean inorderTraversal(TreeNode root){

        boolean left = true, right = true;

        if(root != null){
            left = inorderTraversal(root.left);
            if(root.val <= pre) return false;
            pre = root.val;
            right = inorderTraversal(root.right);
            return left && right;
        }
        return true;
    }

}
