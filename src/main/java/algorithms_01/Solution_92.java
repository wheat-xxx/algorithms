package algorithms_01;

import data_structure.ListNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/31  11:19
 */
public class Solution_92 {

    public ListNode reverseBetween(ListNode head, int left, int right) {

        // 边界情况
        if(left == right) return head;

        // 把头节点当作普通节点 对所有节点进行同一处理
        ListNode preHead = new ListNode(); preHead.next = head;

        // 对节点进行遍历 找到 left 节点的前一个节点
        ListNode pre = preHead;
        for(int i = 0; i < left - 1; i++) pre = pre.next;

        int count = right - left;
        ListNode preCurrent = pre.next;
        for(int i = 0; i < count; i++){
            ListNode temp = preCurrent.next;
            preCurrent.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }

        return preHead.next;
    }

}
