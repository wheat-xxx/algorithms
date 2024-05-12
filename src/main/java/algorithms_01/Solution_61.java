package algorithms_01;

import data_structure.ListNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/07  20:32
 */
public class Solution_61 {

    public ListNode rotateRight(ListNode head, int k) {
        // 边界条件
        if(head == null) return null;

        // 首先找到表尾
        ListNode tail = head;
        int count = 1;
        while(tail.next != null){
            tail = tail.next;
            count++;
        }

        // 形成循环链表
        tail.next = head;

        // 找到新的表头
        for(int i = 0; i < ( count - (k % count)); i++){
            head = head.next;
            tail = tail.next;
        }
        tail.next = null;
        return head;
    }

}
