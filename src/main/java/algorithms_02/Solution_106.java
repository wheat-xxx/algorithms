package algorithms_02;

import data_structure.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/11  8:38
 */
public class Solution_106 {

    private int[] inorder;
    private int[] postorder;
    private Map<Integer, Integer> map = new HashMap<Integer, Integer>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {

        // 边界条件
        if(inorder == null || inorder.length == 0) return null;

        this.inorder = inorder;
        this.postorder = postorder;
        for(int i = 0; i < inorder.length; i++){
            this.map.put(inorder[i], i);
        }

        return recursive(0, inorder.length - 1, 0, postorder.length - 1);
    }

    public TreeNode recursive(int inorder_left, int inorder_right, int postorder_left, int postorder_right){
        if(inorder_left <= inorder_right){

            TreeNode root = new TreeNode(this.postorder[postorder_right]);

            int root_inorder_index = this.map.get(this.postorder[postorder_right]);

            root.left = recursive(inorder_left, root_inorder_index - 1,
                    postorder_left, postorder_left + (root_inorder_index - inorder_left) - 1);
            root.right = recursive(root_inorder_index + 1, inorder_right,
                    postorder_left + (root_inorder_index - inorder_left), postorder_right - 1);

            return root;

        }else return null;
    }

}
