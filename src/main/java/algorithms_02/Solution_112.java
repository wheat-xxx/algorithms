package algorithms_02;

import data_structure.TreeNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/11  17:26
 */
public class Solution_112 {

    private int targetSum;

    public boolean hasPathSum(TreeNode root, int targetSum) {

        if(root == null) return false;

        this.targetSum = targetSum;

        return recursive(root, 0);

    }

    public boolean recursive(TreeNode root, int sum){
        if(root.left == null && root.right == null){
            if(sum + root.val == this.targetSum) return true;
        }
        boolean left = false, right = false;
        if(root.left != null) left = recursive(root.left, sum + root.val);
        if(root.right != null) right = recursive(root.right, sum + root.val);
        return left || right;
    }

}
