package data_structure;

/**
 * 双链表实现
 * @author wheat
 * @date 2023/10/07  17:51
 */
public class DLinkedList<T> {

    private Node head, tail;
    private int size;

    public DLinkedList() {
        // 使用伪头部和伪尾部节点
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void removeNode(Node node) {   // 传入参数不能是伪头尾节点
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public void moveToFirst(Node node){
        this.removeNode(node);
        this.addFirst(node);
    }

    public Node removeLast(){
        // 如果链表为空
        if(head.next == tail){
            return null;
        }
        Node node = tail.prev;
        this.removeNode(node);
        return node;
    }

    public class Node{
        public T data;
        public Node prev;
        public Node next;
        public Node(){}
        public Node(T data) {
            this.data = data;
        }
    }

}
