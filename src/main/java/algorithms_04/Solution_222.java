package algorithms_04;

import data_structure.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author wheat
 * @date 2024/01/08  16:03
 */
public class Solution_222 {

    public int countNodes(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int count = 0;
        while(queue.size() > 0) {
            count++;
            TreeNode node = queue.poll();
            if(node.left != null) queue.add(node.left);
            if(node.right != null) queue.add(node.right);
        }
        return count;
    }

    /**
     * 完全二叉树节点的个数 完全二叉树最后一层只有右边没有节点 寻找最后一个节点的位置
     * @param root
     * @return
     */
    public int countNodes_2(TreeNode root) {
        if(root == null) return 0;
        int leftLevel = treeLevel(root.left);
        int rightLevel = treeLevel(root.right);

        if(leftLevel == rightLevel) {
            return countNodes(root.right) + (1 << leftLevel);
        } else {
            return countNodes(root.left) + (1 << rightLevel);
        }

    }

    private int treeLevel(TreeNode root) {
        int level = 0;
        while(root != null) {
            level++;
            root = root.left;
        }
        return level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);

        System.out.println(new Solution_222().countNodes_2(root));
    }

}
