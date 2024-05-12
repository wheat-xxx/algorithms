package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

/**
 * 判断链表是否包含环
 * @author wheat
 * @date 2024/03/20  19:32
 */
public class LinkedListHasCycle {

    /**
     * 快慢指针
     * @param head
     * @return
     */
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                return true;
            }
        }
        return false;
    }

}
