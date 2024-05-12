package algorithms_02;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2023/10/09  14:43
 */
public class Solution_143 {

    public void reorderList(ListNode head) {
        if(head == null) return;
        // 1. 先找到需要插入的后半段
        ListNode fast = head, slow = head;
        while(fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            }
        }
        ListNode list2 = slow.next;
        slow.next = null;
        // 2. 翻转后半段
        list2 = reverseList(list2);
        // 3. 逐个插入
        while(list2 != null) {
            ListNode temp = head.next;
            head.next = list2;
            list2 = list2.next;
            head.next.next = temp;
            head = temp;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode first = new ListNode();
        while(head != null) {
            ListNode rest = head.next;
            head.next = first.next;
            first.next = head;
            head = rest;
        }
        return first.next;
    }


}
