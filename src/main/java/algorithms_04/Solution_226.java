package algorithms_04;

import data_structure.TreeNode;

/**
 * @author wheat
 * @date 2024/02/26  11:21
 */
public class Solution_226 {

    /**
     * 函数递归实现
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root) {
        if(root == null) {
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invert(root.left);
        invert(root.right);
    }

}
