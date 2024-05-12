package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

/**
 * 单链表的倒数第 k 个节点
 * @author wheat
 * @date 2024/03/20  16:06
 */
public class FindLinkedListKNodeFromEnd {

    /**
     * 双指针
     * @param head
     * @param k
     * @return
     */
    ListNode findFromEnd(ListNode head, int k) {
        ListNode slow = head, fast = head;
        for (int i = 0; i < k; i++) {
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

}
