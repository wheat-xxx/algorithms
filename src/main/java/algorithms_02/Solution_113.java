package algorithms_02;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/11  19:50
 */
public class Solution_113 {

//    private int targetSum;
//    private List<List<Integer>> res = new ArrayList<List<Integer>>();
//    private List<Integer> path = new ArrayList<Integer>();
//
//    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
//
//        if(root == null) return res;
//
//        this.targetSum = targetSum;
//        path.add(root.val);
//
//        recursive(root, 0);
//
//        return res;
//    }
//
//    public void recursive(TreeNode root, int sum){
//
//        // 结束条件
//        if(root.left == null && root.right == null){
//            if(sum + root.val == targetSum) res.add(new ArrayList<Integer>(path));
//            return;
//        }
//
//        if(root.left != null){
//            path.add(root.left.val);
//            recursive(root.left, sum + root.val);
//            path.remove(path.size() - 1);
//        }
//        if(root.right != null){
//            path.add(root.right.val);
//            recursive(root.right, sum + root.val);
//            path.remove(path.size() - 1);
//        }
//    }

    private int targetSum;
    private List<List<Integer>> res = new ArrayList<List<Integer>>();
    private List<Integer> path = new ArrayList<Integer>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum){
        if(root == null) return res;

        this.targetSum = targetSum;

        recursive(root, 0);

        return res;
    }

    public void recursive(TreeNode root, int sum){

        path.add(root.val);
        sum = sum + root.val;

        // 结束条件
        if(root.left == null && root.right == null && sum == this.targetSum) res.add(new ArrayList<Integer>(path));

        // 左子树
        if(root.left != null) recursive(root.left, sum);

        // 右子树
        if(root.right != null) recursive(root.right, sum);

        path.remove(path.size() - 1);
    }

}
