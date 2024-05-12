package algorithms_02;

import data_structure.TreeNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/11  16:33
 */
public class Solution_110 {

//    public boolean isBalanced(TreeNode root) {
//        if(root == null) return true;
//        else{
//            int left = getTreeHeight(root.left);
//            int right = getTreeHeight(root.right);
//            if(Math.abs(left - right) > 1) return false;
//            else{
//                return isBalanced(root.left) && isBalanced(root.right);
//            }
//        }
//    }
//
//    public int getTreeHeight(TreeNode root){
//        if(root == null) return 0;
//        int left = 1 + getTreeHeight(root.left);
//        int right = 1 + getTreeHeight(root.right);
//        return left > right ? left : right;
//    }

    public boolean isBalanced(TreeNode root){
        return getTreeHeight(root) >= 0;
    }

    // 后序遍历只需把树遍历一遍
    public int getTreeHeight(TreeNode root){
        if(root == null) return 0;

        int left = getTreeHeight(root.left);
        int right = getTreeHeight(root.right);

        if(left == -1 || right == -1 || Math.abs(left - right) > 1) return -1;
        else return 1 + (left > right ? left : right);
    }
}
