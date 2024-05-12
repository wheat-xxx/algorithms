package labuladong.ds.linked_list;

import data_structure.ListNode;

/**
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @author wheat
 * @date 2024/04/03  11:20
 */
public class Solution_92 {

    /**
     * 迭代解法
     * @param head
     * @param left
     * @param right
     * @return
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        // 头头节点
        ListNode preHead = new ListNode();
        preHead.next = head;

        // 找到left和right
        ListNode work = preHead;
        while(--left != 0) {
            work = work.next;
            --right;
        }
        ListNode preNodeOfLeft = work;
        while(right-- != 0) {
            work = work.next;
        }
        ListNode rightNode = work;

        // 提取需要翻转的链表部分
        ListNode listTail = rightNode.next;
        ListNode tempHead = preNodeOfLeft.next;
        rightNode.next = null;
        preNodeOfLeft.next = reverseLinkedList(tempHead);
        work = preNodeOfLeft;
        while(work.next != null) {
            work = work.next;
        }
        work.next = listTail;

        return preHead.next;
    }

    private ListNode reverseLinkedList(ListNode head) {
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
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 给一个索引区间 [m, n]（索引从 1 开始），仅仅反转区间中的链表元素。
     * 递归实现
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween_2(ListNode head, int m, int n) {

        return reverse(head, m, n);

    }

    private ListNode reverse(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }

        // 前进到反转的起点触发 base case
        head.next = reverse(head.next, m - 1, n - 1);   // 前m-1个节点啥也不做

        return head;
    }

    private ListNode tail = null;

    /**
     * 递归只需要考虑当前这一步需要干什么
     * 只需要知道递归调用那一步的作用是什么以及返回结果是什么 不要跳进递归
     * @param head
     * @param n
     * @return
     */
    public ListNode reverseN(ListNode head, int n) {
        // 结束条件
        if (n == 1) {
            // 记录不需要翻转的部分
            tail = head.next;
            return head;
        }
        // 以 head.next 为起点，需要反转前 n - 1 个节点
        ListNode last = reverseN(head.next, n - 1);
        // 将head节点接入到翻转之后的表尾
        head.next.next = head;
        // 让反转之后的 head 节点和后面的节点连起来
        head.next = tail;
        return last;
    }

}
