package algorithms_02;

import data_structure.TreeNode;
import java.util.*;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/05  9:49
 */
public class Solution_101 {

    /**
     * 中序遍历解法
     * 错误：root = [5,4,1,null,1,null,4,2,null,2,null]
     * @param root
     * @return
     */
    public boolean isSymmetric_1(TreeNode root){

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
     * 分解问题思路
     *
     * @param root
     * @return
     */
    public boolean isSymmetric_2(TreeNode root) {
        if (root == null) return true;

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;

        if (p == null || q == null) return false;

        boolean cur = p.val == q.val;
        boolean flag1 = helper(p.left, q.right);
        boolean flag2 = helper(p.right, q.left);
        return cur && flag1 && flag2;
    }

    /*
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * bfs - 层序遍历
     * @param root
     * @return
     */
    public boolean isSymmetric_3(TreeNode root){
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
