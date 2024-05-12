package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2024/03/20  16:14
 */
public class Solution_19 {

    /**
     * 双指针
     * 有可能会删除头节点，统一处理所有情况，添加虚拟头节点
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

}
