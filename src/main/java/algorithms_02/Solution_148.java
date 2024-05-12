package algorithms_02;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2023/09/02  16:59
 */
public class Solution_148 {

    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        // 判断是否为空链表
        if(head == null) return null;
        // 只有一个节点
        if(head.next == tail) {
            head.next = null;   // 这里必须进行设置 要不然合并的时候会发生错误
            return head;
        }
        // 利用快慢指针寻找链表的中间节点
        ListNode fast = head, slow = head;
        while(fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if(fast != tail) {
                fast = fast.next;
            }
        }

        // 将链表分成两段分别进行归并递归 合并
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        return mergeList(list1, list2);
    }

    /**
     * 自底向上归并排序
     * @param head
     * @return
     */
    public ListNode sortList_2(ListNode head) {
        // 空链表
        if(head == null) return null;
        // 计算链表长度
        int length = 0;
        ListNode temp = head;
        while(temp != null) {
            length++;
            temp = temp.next;
        }
        // 利用链表长度对链表进行划分 自底向上进行归并
        ListNode preHead = new ListNode(0, head);
        for(int subLength = 1; subLength < length; subLength <<= 1){
            ListNode prev = preHead, curr = preHead.next;
            while(curr != null) {
                ListNode head1 = curr;
                for(int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode head2 = curr.next;
                curr.next = null;
                curr = head2;
                for(int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                ListNode next = null;
                if(curr != null){
                    next = curr.next;
                    curr.next = null;
                }
                ListNode merged = mergeList(head1, head2);
                prev.next = merged;
                while(prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return preHead.next;
    }

    private ListNode mergeList(ListNode head1, ListNode head2) {
        ListNode preHead = new ListNode();
        ListNode temp = preHead;
        while(head1 != null && head2 != null) {
            if(head1.val <= head2.val){
                temp.next = head1;
                head1 = head1.next;
            } else {
                temp.next = head2;
                head2 = head2.next;
            }
            temp = temp.next;
        }
        if(head1 != null) {
            temp.next = head1;
        } else if (head2 != null) {
            temp.next = head2;
        }
        return preHead.next;
    }

}
