package labuladong.ds.linked_list;

import data_structure.ListNode;

/**
 * 将链表的前 n 个节点反转（n <= 链表长度）
 * @author wheat
 * @date 2024/04/09  10:16
 */
public class Solution_ReverseN {

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
