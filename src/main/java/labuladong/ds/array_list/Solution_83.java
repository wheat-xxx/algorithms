package labuladong.ds.array_list;

import data_structure.ListNode;

/**
 * 给定一个已排序的链表的头 head ， 删除所有重复的元素，使每个元素只出现一次 。返回 已排序的链表 。
 *
 * 问题核心：选择重复序列的第一个元素作为唯一元素
 * @author wheat
 * @date 2024/03/20  21:37
 */
public class Solution_83 {

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;

        ListNode slow = head, fast = head;
        while(fast != null) {
            if(fast.val != slow.val) {
                slow.next = fast;
                slow = slow.next;
            }
            fast = fast.next;
        }

        // 断开与后面重复元素的连接
        slow.next = null;
        return head;
    }

}
