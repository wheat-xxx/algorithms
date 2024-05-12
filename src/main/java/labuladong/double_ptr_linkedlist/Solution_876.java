package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

/**
 * 给你单链表的头结点 head ，请你找出并返回链表的中间结点。
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author wheat
 * @date 2024/03/20  16:35
 */
public class Solution_876 {

    /**
     * 双指针法
     * @param head
     * @return
     */
    public ListNode middleNode_2(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

}
