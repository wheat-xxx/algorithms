package algorithms_01;

import data_structure.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/03  17:07
 */
public class Solution_95 {

    public List<TreeNode> generateTrees(int n) {

        if(n == 0) return new LinkedList<TreeNode>();

        return generateTrees(1, n);

    }

    public List<TreeNode> generateTrees(int start, int end){
        LinkedList<TreeNode> allTrees = new LinkedList<TreeNode>();

        // dfs结束条件
        if(start > end){
            allTrees.add(null);
            return allTrees;
        }

        for(int i = start; i <= end; i++){
            // 左子树集合
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            // 右子树
            List<TreeNode> rightTrees = generateTrees(i + 1, end);

            // 生成以i为根节点的所有树
            for(TreeNode left : leftTrees){
                for(TreeNode right : rightTrees){
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }

        return allTrees;
    }

}
