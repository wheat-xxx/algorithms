package labuladong.ds.linked_list;

import data_structure.ListNode;

/**
 * 给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
 *
 * 递归性质：子问题和原问题的结构完全相同
 * @author wheat
 * @date 2024/04/09  20:49
 */
public class Solution_25 {

    /**
     * 递归实现
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // 区间 [a, b) 包含 k 个待反转元素
        ListNode a = head, b = head;
        for (int i = 0; i < k; i++) {
            if (b != null) b = b.next;
            else return head;
        }
        // 翻转前k个元素
        ListNode newHead = reverse(a, b);
        // 递归反转后续链表并连接起来
        a.next = reverseKGroup(b, k);
        return newHead;
    }

    /**
     * 翻转[a,b)之间的元素
     * @param a
     * @param b
     * @return
     */
    private ListNode reverse(ListNode a, ListNode b) {
        // 边界情况
        if (a.next == b) return a;

        ListNode preHead = new ListNode();
        ListNode unprocessedList = a;
        while (unprocessedList != b) {
            ListNode temp = unprocessedList.next;
            unprocessedList.next = preHead.next;
            preHead.next = unprocessedList;
            unprocessedList = temp;
        }

        a.next = b;
        return preHead.next;
    }

}
