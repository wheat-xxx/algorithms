package algorithms_02;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wheat
 * @date 2023/11/29  16:02
 */
public class Solution_138 {

    private class Node{
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Node dummyHead = new Node(-1);  // 假头节点
        Node pre = dummyHead;
        Node work = head;

        Map<Node, Node> map = new HashMap<>();

        // 构造新的链表 给节点的next赋值
        while(work != null) {
            Node temp = new Node(work.val);
            map.put(work, temp); // 保存新旧节点的对应关系
            pre.next = temp;
            pre = pre.next;
            work = work.next;
        }

        // 节点的random如何赋值？空间换时间，使用map集合保存新节点和新节点的对应关系
        work = dummyHead.next;
        while(head != null) {
            Node node = map.get(head.random);
            work.random = node;

            head = head.next;
            work = work.next;
        }

        return dummyHead.next;
    }

}
