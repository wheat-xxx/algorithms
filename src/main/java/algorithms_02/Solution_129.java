package algorithms_02;

import data_structure.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @author wheat
 * @date 2023/10/13  16:16
 */
public class Solution_129 {

    // 深度优先搜索
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public int dfs(TreeNode root, int preSum){
        if(root == null) return 0;
        int res = preSum * 10 + root.val;
        if(root.right == null && root.left == null) {
            return res;
        }else {
            return dfs(root.left, res) + dfs(root.right, res);
        }
    }

}
