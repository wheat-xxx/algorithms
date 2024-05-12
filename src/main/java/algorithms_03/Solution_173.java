package algorithms_03;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author wheat
 * @date 2023/12/12  15:15
 */
public class Solution_173 {

    class BSTIterator {

        private List<Integer> data;
        private int index;

        public BSTIterator(TreeNode root) {
            data = new ArrayList<>();
            index = 0;
            // 二叉树的中序遍历
            InorderTraversal(root);
        }

        public int next() {
            int val = data.get(index);
            index++;
            return val;
        }

        public boolean hasNext() {
            return index < data.size();
        }

        private void InorderTraversal(TreeNode root) {
            if(root != null) {
                InorderTraversal(root.left);
                data.add(root.val);
                InorderTraversal(root.right);
            }
        }
    }

}
