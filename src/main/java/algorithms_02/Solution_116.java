package algorithms_02;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/14  14:33
 */
public class Solution_116 {

    private class Node {
        int val;
        Node left;
        Node right;
        Node next;
    }

//    public Node connect(Node root){
//        if(root == null) return null;
//
//        Queue<Node> queue = new LinkedList<Node>();
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

    public Node connect(Node root){

        return preorderTraverse(root);

    }

    public Node preorderTraverse(Node root){
        if(root == null) return null;

        if(root.left != null){
            root.left.next = root.right;
            if(root.next != null){
                root.right.next = root.next.left;
            }
        }

        // 左子树递归
        preorderTraverse(root.left);
        preorderTraverse(root.right);

        return root;
    }
}
