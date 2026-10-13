package algorithms_00;

import data_structure.ListNode;

/**
 * @Author: wheat
 * @Date: 2026/10/12 22:07
 * @Version: v1.0.0
 **/
public class Solution_02 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p1 = l1;
        ListNode p2 = l2;

        ListNode retVal = new ListNode();
        ListNode p3 = retVal;

        int carry = 0;
        while (p1 != null && p2 != null) {
            int temp = p1.val + p2.val + carry;
            p3.next = new ListNode();
            p3.next.val = temp % 10;

            carry = temp / 10;
            p3 = p3.next;
            p1 = p1.next;
            p2 = p2.next;
        }

        if (p2 != null) p1 = p2;
        while (p1 != null) {
            int temp = p1.val + carry;
            p3.next = new ListNode();
            p3.next.val = temp % 10;

            carry = temp / 10;
            p1 = p1.next;
            p3 = p3.next;
        }

        if (carry != 0) {
            p3.next = new ListNode();
            p3.next.val = carry;
        }

        return retVal.next;
    }

}
