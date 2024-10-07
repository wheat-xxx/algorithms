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

    /**
     * 错误：不仅是左右子节点对称，而是左右子树对称
     * @param root
     * @return
     */
    public boolean isSymmetric_1(TreeNode root) {

        return traverse(root);

    }

    public boolean traverse(TreeNode root){
        if(root != null){
            if(root.left != null && root.right != null){
                if(root.left.val == root.right.val) return traverse(root.left) && traverse(root.right);
                else return false;
            }else if(root.left == null && root.right == null){
                return true;
            }else{
                return false;
            }
        }else {
            return true;
        }
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 中序遍历解法
     * 错误：root = [5,4,1,null,1,null,4,2,null,2,null]
     * @param root
     * @return
     */
    public boolean isSymmetric_2(TreeNode root){

        List<Integer> res = new ArrayList<Integer>();

        inorderTraversal(root, res);

        int i = 0, j = res.size() - 1;

        while(i < j){
            if (res.get(i) == null && res.get(j) == null) {
                // 更新i j
            } else if (res.get(i) != null && res.get(j) != null) {
                if (!res.get(i).equals(res.get(j))) {
                    return false;
                }
            } else {
                return false;
            }
            i++; j--;
        }

        return true;
    }

    public void inorderTraversal(TreeNode root, List<Integer> res){
        if (root == null) {
            res.add(null);
            return;
        }

        if (root.left == null && root.right == null) {
            res.add(root.val);
            return;
        }

        inorderTraversal(root.left, res);
        res.add(root.val);
        inorderTraversal(root.right, res);
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 递归解法：
     * @param root
     * @return
     */
    public boolean isSymmetric_3(TreeNode root){
        if(root == null){
            return true;
        }

        return dfs(root.right, root.left);
    }

    public boolean dfs(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }else if(left != null && right != null){
            if(left.val == right.val){
                return dfs(left.left, right.right) && dfs(left.right, right.left);
            }else{
                return false;
            }
        }else{
            return false;
        }
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * bfs - 层序遍历
     * @param root
     * @return
     */
    public boolean isSymmetric_4(TreeNode root){
        if(root == null) return true;

        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        queue.add(root.left);
        queue.add(root.right);

        while(!queue.isEmpty()){
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
