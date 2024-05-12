package algorithms_01;

import data_structure.ListNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/14  14:11
 */
public class Solution_82 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode preHead = new ListNode(); preHead.next = head;
        ListNode pre = preHead, current = head;

        while(current != null){
            while(current.next != null && current.val == current.next.val) current = current.next;

            if(pre.next == current){
                pre = current;
            }else{
                pre.next = current.next;
            }
            current = current.next;
        }

        return preHead.next;
    }

}
