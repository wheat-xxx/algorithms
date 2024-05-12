package algorithms_02;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/05  16:24
 */
public class Solution_102 {

//    /**
//     * 使用队列实现对树的层序遍历
//     * @param root
//     * @return
//     */
//    public List<List<Integer>> levelOrder(TreeNode root) {
//
//        List<List<Integer>> res = new ArrayList<List<Integer>>();
//        List<Integer> level = null;
//        Queue<Data> queue = new LinkedList<Data>();
//
//        if(root == null) return res;
//
//        Data data = new Data(root, 1);
//        queue.add(data);
//        int pre = 1;
//
//        while(queue.size() != 0){
//            data = queue.poll();
//            if(data.root.left != null){
//                Data left = new Data(data.root.left, data.level + 1);
//                queue.add(left);
//            }
//            if(data.root.right != null){
//                Data right = new Data(data.root.right, data.level + 1);
//                queue.add(right);
//            }
//
//            if(data.level == 1 || data.level != pre){
//                if(level != null){
//                    res.add(level);
//                }
//                level = new ArrayList<Integer>();
//                pre = data.level;
//            }
//
//            level.add(data.root.val);
//        }
//
//        res.add(level);
//
//        return res;
//    }
//
//    private class Data{
//        public TreeNode root;
//        public int level;
//
//        public Data(){}
//
//        public Data(TreeNode root, int level){
//            this.root = root;
//            this.level = level;
//        }
//    }

    /**
     * 分析：借助bfs实现层序遍历
     */
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<TreeNode>();

        if(root == null) return res;

        queue.add(root);

        while(!queue.isEmpty()){
            int levelNums = queue.size();

            List<Integer> level = new ArrayList<Integer>();

            for(int i = 0; i < levelNums; i++){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }

            res.add(level);
        }

        return res;
    }
}
