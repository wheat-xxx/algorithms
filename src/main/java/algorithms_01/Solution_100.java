package algorithms_01;

import data_structure.TreeNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/08  16:26
 */
public class Solution_100 {

    /**
     * 分析：
     *      随便使用一种二叉树的遍历操作进行判别
     * @param p
     * @param q
     * @return
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return traversal(p, q);
    }

    public boolean traversal(TreeNode p, TreeNode q){
        // 结束条件
        if(p == null && q == null) return true;

        if(p != null && q != null){
            if(p.val != q.val) return false;
            else return traversal(p.left, q.left) && traversal(p.right, q.right);
        }else return false;
    }

}
