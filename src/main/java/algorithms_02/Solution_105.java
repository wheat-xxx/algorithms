package algorithms_02;

import data_structure.TreeNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/06  15:16
 */
public class Solution_105 {

//    public TreeNode buildTree(int[] preorder, int[] inorder) {
//
//        return recursive(preorder, inorder);
//
//    }
//
//    public TreeNode recursive(int[] preorder, int[] inorder){
//        if(preorder != null && preorder.length != 0){
//            TreeNode root = new TreeNode(preorder[0]);
//            int index = -1;
//            for(int i = 0; i < inorder.length; i++){
//                if(inorder[i] == preorder[0]){
//                    index = i;
//                    break;
//                }
//            }
//
//            int lengthOfLeft = index;
//            root.left = recursive(Arrays.copyOfRange(preorder, 1, lengthOfLeft + 1), Arrays.copyOfRange(inorder, 0, index));
//            root.right = recursive(Arrays.copyOfRange(preorder, lengthOfLeft + 1, preorder.length),
//                    Arrays.copyOfRange(inorder, index + 1, inorder.length));
//            return root;
//        }else{
//            return null;
//        }
//    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        // 边界情况
        if(preorder == null || preorder.length == 0) return null;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }

        return recursive(preorder, inorder, map, 0, preorder.length, 0, inorder.length);

    }

    // 左闭右开
    public TreeNode recursive(int[] preorder, int[] inorder, Map<Integer, Integer> map,
                              int preorder_left, int preorder_right, int inorder_left, int inorder_right){
        if(preorder_left < preorder_right && inorder_left < inorder_right){
            // 根节点是前序遍历的第一个节点
            TreeNode root = new TreeNode(preorder[preorder_left]);
            // 中序遍历中根节点的位置
            int root_position = map.get(preorder[preorder_left]);

            root.left = recursive(preorder, inorder, map, preorder_left + 1, preorder_left + 1 + root_position - inorder_left,
                    inorder_left, root_position);

            root.right = recursive(preorder, inorder, map, preorder_left + 1 + root_position - inorder_left, preorder_right,
                    root_position + 1, inorder_right);
            
            return root;
        }else return null;
    }


}
