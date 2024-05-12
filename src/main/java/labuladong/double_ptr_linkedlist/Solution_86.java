package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * @author wheat
 * @date 2024/03/20  13:44
 */
public class Solution_86 {

    /**
     * 由于需要移动链表中的元素，所以work应该指向被移动元素的前驱节点
     * @param head
     * @param x
     * @return
     */
    public ListNode partition(ListNode head, int x) {
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode slow = preHead;
        while(slow.next != null && slow.next.val < x) {
            slow = slow.next;
        }
        ListNode fast = slow;
        while(fast.next != null) {
            if(fast.next.val < x) {
                // val < x 前插
                ListNode temp = fast.next;
                fast.next = temp.next;
                temp.next = slow.next;
                slow.next = temp;
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }

        return preHead.next;
    }

    /**
     * 如果我们需要把原链表的节点接到新链表上，而不是 new 新节点来组成新链表的话，那么断开节点和原链表之间的链接可能是必要的
     * @param head
     * @param x
     * @return
     */
    public ListNode partition_2(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();

        ListNode p1 = dummy1, p2 = dummy2;
        ListNode p = head;
        while(p != null) {
            ListNode temp = p;
            p = p.next;
            temp.next = null;
            if(temp.val < x) {
                p1.next = temp;
                p1 = p1.next;
            } else {
                p2.next = temp;
                p2 = p2.next;
            }
        }
        p1.next = dummy2.next;
        return dummy1.next;
    }


    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,4,3,0,2,5,2);
        ListNode head = new ListNode(list);
        Solution_86 obj = new Solution_86();
        obj.partition(head, 3);
    }

}
