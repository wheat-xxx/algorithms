package algorithms_04;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2023/12/19  16:36
 */
public class Solution_206 {

    /**
     * 使用头插法完成翻转
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode work = head;
        while(work != null) {
            ListNode temp = work.next;
            work.next = preHead.next;
            preHead.next = work;
            work = temp;
        }

        return preHead.next;
    }

}
