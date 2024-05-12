package algorithms_02;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2023/09/01  16:41
 */
public class Solution_141 {
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode node1 = head;
        ListNode node2 = head.next;
        while(node1 != null && node2 != null && node2.next != null) {
            if(node1 == node2) return true;
            node1 = node1.next;
            node2 = node2.next.next;
        }
        return false;
    }
}
