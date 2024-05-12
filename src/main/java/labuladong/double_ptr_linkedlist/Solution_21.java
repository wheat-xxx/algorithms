package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

/**
 * 合并两个有序链表
 * 虚拟头节点：当你需要创造一条新链表的时候，可以使用虚拟头结点简化边界情况的处理
 * @author wheat
 * @date 2023/02/23  17:17
 */
public class Solution_21 {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // 虚拟头节点
        ListNode preHead = new ListNode();
        ListNode work = preHead;
        ListNode p1 = list1, p2 = list2;
        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                work.next = p1;
                p1 = p1.next;
            } else {
                work.next = p2;
                p2 = p2.next;
            }
            work = work.next;
        }

        // 处理剩余节点
        if(p1 != null) {
            work.next = p1;
        }
        if(p2 != null) {
            work.next = p2;
        }

        return preHead.next;
    }

}
