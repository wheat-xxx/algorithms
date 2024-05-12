package algorithms_02;

import data_structure.TreeNode;
import org.junit.Test;

import java.sql.Array;
import java.util.*;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/05  9:49
 */
public class Solution_101 {

//    public boolean isSymmetric(TreeNode root) {
//
//        return traverse(root);
//
//    }
//
//    public boolean traverse(TreeNode root){
//        if(root != null){
//            if(root.left != null && root.right != null){
//                if(root.left.val == root.right.val) return traverse(root.left) && traverse(root.right);
//                else return false;
//            }else if(root.left == null && root.right == null){
//                return true;
//            }else{
//                return false;
//            }
//        }else {
//            return true;
//        }
//    }

//    public boolean isSymmetric(TreeNode root){
//
//        List<Integer> nums = new ArrayList<Integer>();
//
//        inorderTraverse(root, nums);
//
//        int i = 0, j = nums.size() - 1;
//        while(i < j){
//            if(nums.get(i).equals(nums.get(j))) {
//                i++;
//                j--;
//            } else return false;
//        }
//
//        return true;
//    }
//
//    public boolean inorderTraverse(TreeNode root, List<Integer> nums){
//        inorderTraverse(root.left, nums);
//        nums.add(root.val);
//        inorderTraverse(root.right, nums);
//    }

    /**
     * 分析：首先判断树的结构是否是轴对称 然后对树进行中序遍历 判断遍历后的序列是否对称  错误：无法实现
     *      第二种方法 先前序遍历 后后序遍历 结果一样则是轴对称
     * @param root
     * @return
     */
//    public boolean isSymmetric(TreeNode root){
//        List<Integer> preorderList = new ArrayList<Integer>();
//        List<Integer> postorderList = new ArrayList<Integer>();
//
//        preorderTraversal(root, preorderList);
//        postorderTraversal(root, postorderList);
//
//        return preorderList.equals(postorderList);
//
//    }
//
//    public void preorderTraversal(TreeNode root, List<Integer> nums){
//        if(root != null){
//            preorderTraversal(root.left, nums);
//            nums.add(root.val);
//            preorderTraversal(root.right, nums);
//        }
//    }
//
//    public void postorderTraversal(TreeNode root, List<Integer> nums){
//        if(root != null){
//            postorderTraversal(root.right, nums);
//            nums.add(root.val);
//            postorderTraversal(root.right, nums);
//        }
//    }

    // 中序遍历的时候加入空节点
//    public boolean isSymmetric(TreeNode root){
//
//        List<Integer> nums = new ArrayList<Integer>();
//
//        inorderTraversal(root, nums);
//
//        int i = 0, j = nums.size() - 1;
//
//        while(i < j){
//            if(nums.get(i++) == nums.get(j--)) continue;
//            else return false;
//        }
//
//        return true;
//    }
//
//    public void inorderTraversal(TreeNode root, List<Integer> nums){
//        if(root != null){
//            if(root.right == null && root.left == null){
//                nums.add(root.val);
//                return;
//            }
//            inorderTraversal(root.left, nums);
//            nums.add(root.val);
//            inorderTraversal(root.right, nums);
//        }else{
//            nums.add(null);
//        }
//    }

//    public boolean isSymmetric(TreeNode root){
//        if(root == null){
//            return true;
//        }
//
//        return dfs(root.right, root.left);
//    }
//
//    public boolean dfs(TreeNode left, TreeNode right){
//        if(left == null && right == null){
//            return true;
//        }else if(left != null && right != null){
//            if(left.val == right.val){
//                return dfs(left.left, right.right) && dfs(left.right, right.left);
//            }else{
//                return false;
//            }
//        }else{
//            return false;
//        }
//    }

    // 使用队列
    public boolean isSymmetric(TreeNode root){
        if(root == null || root.left == null && root.right == null) return true;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root.left);
        queue.add(root.right);

        while(queue.size() != 0){
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();

            if(left == null && right == null){
                continue;
            }

            if(left == null || right == null){
                return false;
            }

            if(left.val == right.val){
                queue.add(left.left);
                queue.add(right.right);
                queue.add(left.right);
                queue.add(right.left);
            }else{
                return false;
            }
        }

        return true;
    }
}
