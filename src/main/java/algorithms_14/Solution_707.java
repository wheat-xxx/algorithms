package algorithms_14;

/**
 * 设计链表
 * @author wheat
 * @date 2024/07/23  22:50
 */
public class Solution_707 {

    private class MyLinkedList {

        private Node head = new Node();
        private Node tail = new Node();
        private int size = 0;

        public MyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        public int get(int index) {
            if (index >= size) {
                return -1;
            }

            Node work = head;
            for (int i = 0; i <= index; i++) {
                work = work.next;
            }
            return work.val;
        }

        public void addAtHead(int val) {
            Node node = new Node();
            node.val = val;
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public void addAtTail(int val) {
            Node node = new Node();
            node.val = val;
            node.next = tail;
            node.prev = tail.prev;
            tail.prev.next = node;
            tail.prev = node;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if (index > size) {
                return;
            }

            Node node = new Node();
            node.val = val;

            Node pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }
            node.prev = pre;
            node.next = pre.next;
            pre.next.prev = node;
            pre.next = node;
            size++;
        }

        public void deleteAtIndex(int index) {
            if (index >= size) {
                return;
            }

            Node pre = head;
            for (int i = 0; i < index; i++) {
                pre = pre.next;
            }

            pre.next.next.prev = pre;
            pre.next = pre.next.next;
            size--;
        }

        private class Node {
            int val;
            Node prev;
            Node next;
        }
    }

}
