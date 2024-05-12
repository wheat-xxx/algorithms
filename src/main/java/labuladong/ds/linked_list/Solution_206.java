package labuladong.ds.linked_list;

import data_structure.ListNode;

/**
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * @author wheat
 * @date 2024/04/09  8:45
 */
public class Solution_206 {

    /**
     * 迭代解法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        // 边界情况
        if (head == null || head.next == null) return head;

        // 头头节点
        ListNode preHead = new ListNode();

        // 将链表中的节点逐个插入头头节点之后
        ListNode unprocessedList = head;
        while(unprocessedList != null) {
            ListNode temp = unprocessedList.next;
            unprocessedList.next = preHead.next;
            preHead.next = unprocessedList;
            unprocessedList = temp;
        }

        return preHead.next;
    }

    /**
     * 递归实现
     * @param head
     * @return
     */
    public ListNode reverseList_2(ListNode head) {
        return reverse(head);
    }

    /**
     * 翻转单链表递归实现
     * 对于递归算法，最重要的就是明确递归函数的定义
     * 不要跳进递归（你的脑袋能压几个栈啊？）
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        // 结束条件
        if (head == null || head.next == null) return head;
        // 翻转链表之后的部分 并返回翻转之后的头节点
        ListNode last = reverse(head.next);
        // 将头节点插入到表尾
        head.next.next = head;
        head.next = null;

        return last;
    }

}
