package algorithms_02;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2023/10/09  15:04
 */
public class Solution_142 {

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head, slow = head;
        while(true) {
            if(fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

}
