package labuladong.ds.array_list;

import data_structure.ListNode;

import java.util.PriorityQueue;

/**
 * @author wheat
 * @date 2024/09/30  10:08
 */
public class Solution_148 {

    /**
     * 优先级队列
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1, node2) -> node1.val - node2.val);

        while (head != null) {
            pq.add(head);
            head = head.next;
        }

        ListNode preHead = new ListNode();
        ListNode work = preHead;
        while(!pq.isEmpty()) {
            work.next = pq.poll();
            work = work.next;
        }
        work.next = null;

        return preHead.next;
    }

}
