package algorithms_02;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author wheat
 * @date 2023/10/09  10:45
 */
public class Solution_145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        TreeNode work = root;
        TreeNode prev = null;
        while(!stack.isEmpty() || work != null) {
            while(work != null) {
                stack.push(work);
                work = work.left;
            }
            work = stack.pop();
            if(work.right == null || prev == work.right){
                list.add(work.val);
                prev = work;
                work = null;
            } else {
                stack.push(work);
                work = work.right;
            }
        }
        return list;
    }

}

/* 后续遍历非递归版本 存在一个重复的问题
public List<Integer> postorderTraversal(TreeNode root) {
    Deque<TreeNode> stack = new LinkedList<>();
    List<Integer> list = new ArrayList<>();
    TreeNode work = root;
    while(!stack.isEmpty() || work != null) {
        if(work != null) {
            stack.push(work);
            work = work.left;
        } else {
            work = stack.peek();
            if(work.right != null) {
                work = work.right;
                stack.push(work);
            }else {
                list.add(work.val);
                stack.pop();
            }
        }
    }

    return list;
}
 */
