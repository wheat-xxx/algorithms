package algorithms_01;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/02  10:52
 */
public class Solution_94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();

        if(root != null){
            traversal(res, root);
        }

        return res;
    }

    private void traversal(List<Integer> res, TreeNode root){
        if(root != null){
            traversal(res, root.left);
            res.add(root.val);
            traversal(res, root.right);
        }
    }

}
