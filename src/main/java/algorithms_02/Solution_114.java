package algorithms_02;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Description:
 *      二叉树展开为链表 使用什么遍历？后序遍历
 * @author wheat
 * @date 2023/04/11  21:34
 */
public class Solution_114 {

//    private ArrayList<TreeNode> res = new ArrayList<TreeNode>();
//
//    public void flatten(TreeNode root) {
//
//        postorderTraverse(root);
//
//        for(int i = 0; i < res.size() - 1; i++){
//            res.get(i).right = res.get(i + 1);
//            res.get(i).left = null;
//        }
//
//
//    }
//
//    public void postorderTraverse(TreeNode root){
//
//        if(root != null){
//            // 先序遍历进行的操作
//            res.add(root);
//
//            postorderTraverse(root.left);
//            postorderTraverse(root.right);
//        }
//
//    }


    public void flatten(TreeNode root){

        while(root != null){
            if(root.left == null){
                root = root.right;
            }else{
                TreeNode pre = root.left;
                while(pre.right != null) pre = pre.right;
                pre.right = root.right;
                root.right = root.left;
                root.left = null;
                root = root.right;
            }
        }

    }

}
