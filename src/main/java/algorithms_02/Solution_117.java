package algorithms_02;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/20  16:24
 */
public class Solution_117 {

    private class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

    /**
     * 利用二叉树的层序遍历实现
     * @param root
     * @return
     */
//    public Node connect(Node root){
//
//        if(root == null) return null;
//
//        Queue<Node> queue = new LinkedList<Node>();
//
//        queue.add(root);
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0; i < size; i++){
//                Node node = queue.poll();
//                if(i != size - 1){
//                    node.next = queue.peek();
//                }
//                if(node.left != null) queue.add(node.left);
//                if(node.right != null) queue.add(node.right);
//            }
//        }
//
//        return root;
//    }

//    public Node connect(Node root){
//
//    }

}
