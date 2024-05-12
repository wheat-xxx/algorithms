package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

/**
 * 给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
 * @author wheat
 * @date 2024/03/20  20:31
 */
public class Solution_160 {


    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null) p1 = headB;
        if(p2 == null) p2 = headA;
        while(p1 != null && p2 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        if(p1 == null) p1 = headB;
        if(p2 == null) p2 = headA;
        while(p1 != null && p2 != null) {
            if(p1 == p2) return p1;
            p1 = p1.next;
            p2 = p2.next;
        }
        return null;
    }

    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }

        return p1;
    }

}
