package algorithms_02;

import data_structure.TreeNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/06  15:08
 */
public class Solution_104 {

    // 使用深度优先遍历实现
    public int maxDepth(TreeNode root) {

        int[] max = new int[1];

        dfs(root, max, 1);

        return max[0];

    }

    public void dfs(TreeNode root, int[] max, int depth){
        if(root != null){
            if(depth > max[0]) max[0] = depth;
            dfs(root.left, max, depth + 1);
            dfs(root.right, max, depth + 1);
        }
    }

}
