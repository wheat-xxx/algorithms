package algorithms_03;

import data_structure.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @author wheat
 * @date 2023/12/03  19:31
 */
public class Solution_160 {

    /**
     * 空间换时间
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();
        ListNode work = headA;
        while(work != null) {
            visited.add(work);
            work = work.next;
        }

        work = headB;
        while(work != null) {
            if(visited.contains(work)) {
                return work;
            }
            work = work.next;
        }

        return null;
    }

    /**
     * 如果一个长一个短，将长的锯成短的，两者同时遍历一次，便可得到交叉的位置
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_2(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        int m = 0, n = 0;
        while(pA != null) {
            m++;
            pA = pA.next;
        }
        while(pB != null) {
            n++;
            pB = pB.next;
        }

        int diff_val = 0;
        pA = headA; pB = headB;
        if(m > n) {
            diff_val = m - n;
            for(int i = 0; i < diff_val; i++) {
                pA = pA.next;
            }
        } else {
            diff_val = n - m;
            for(int i = 0; i < diff_val; i++) {
                pB = pB.next;
            }
        }
        while(pA != null) {
            if (pA == pB) {
                return pA;
            }
            pA = pA.next;
            pB = pB.next;
        }
        return null;
    }

    /**
     * 天才操作
     * A-------B-----------------|----
     * B---------------------A---|----
     * | 是交叉部分出现的位置
     * @param headA
     * @param headB
     * @return
     */
    public ListNode getIntersectionNode_3(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;
        while(pA != pB) {
            pA = pA == null ? headB : pA.next;
            pB = pB == null ? headA : pB.next;
        }
        return pA;
    }

}
