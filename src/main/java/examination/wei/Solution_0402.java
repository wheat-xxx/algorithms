package examination.wei;

import data_structure.ListNode;

/**
 * @author wheat
 * @date 2024/04/02  14:45
 */
public class Solution_0402 {

    public static void main(String[] args) {

    }
    // 双指针
    private boolean test(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) return true;
        }
        return false;
    }

}
