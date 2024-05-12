package algorithms_04;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2023/12/19  14:42
 */
public class Solution_203 {

    public ListNode removeElements(ListNode head, int val) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode work = preHead;
        while(work.next != null) {
            if(work.next.val == val) {
                ListNode temp = work.next.next;
                work.next = temp;
            } else {
                work = work.next;
            }
        }

        return preHead.next;
    }

}
