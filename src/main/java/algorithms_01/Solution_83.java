package algorithms_01;

import data_structure.ListNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/14  14:50
 */
public class Solution_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode preHead = new ListNode(); preHead.next = head;
        ListNode pre = preHead, current = pre.next;

        while(current != null){
            while(current.next != null && current.val == current.next.val) current = current.next;

            pre.next = current;
            pre = current;
            current = current.next;
        }

        return preHead.next;
    }

}
