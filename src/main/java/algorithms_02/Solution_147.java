package algorithms_02;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2023/09/02  17:04
 */
public class Solution_147 {

    public ListNode insertionSortList(ListNode head) {
        // 定义头头节点 保证处理链表中元素的一致性
        ListNode preHead = new ListNode();
        preHead.next = head;
        ListNode work = preHead;
        LABEL_OUT:
        while(work.next != null) {      // 当前要处理的节点是work.next
            if(work == preHead || work.val <= work.next.val) {
                work = work.next;
            } else{
                ListNode next = work.next.next;  // 下一个要处理的节点
                ListNode temp = work.next;
                work.next = next;
                // 从头开始寻找插入的位置
                ListNode p = preHead;
                while(p.next != next) {
                    if(temp.val <= p.next.val) {
                        temp.next = p.next;
                        p.next = temp;
                        continue LABEL_OUT;
                    }
                    p = p.next;
                }
            }
        }

        return preHead.next;
    }

}
