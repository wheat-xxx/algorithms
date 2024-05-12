package labuladong.ds.linked_list;

import data_structure.ListNode;

import java.lang.annotation.ElementType;
import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。
 * @author wheat
 * @date 2024/04/10  22:27
 */
public class Solution_234 {

    /**
     * 单链表只能向一个方向移动
     * 最简单的解法 链表转为数组
     * @param head
     * @return
     */
    public boolean isPalindrome(ListNode head) {
        ListNode work = head;
        List<Integer> array = new ArrayList<>();
        while(work != null) {
            array.add(work.val);
            work = work.next;
        }
        int left = 0, right = array.size() - 1;
        while(left < right) {
            if (!array.get(left).equals(array.get(right))) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

//    /**
//     * 链表后序遍历
//     * @param head
//     */
//    private void traverse(ListNode head) {
//        if (head == null) return;
//        // 前序遍历位置
//        traverse(head.next);
//        // 后序遍历位置
//    }

    /**
     * 借助二叉树后序遍历的思路，不需要显式翻转链表也可以倒序遍历链表
     * traverse实现后序遍历，全局变量实现正向遍历
     * @param head
     * @return
     */
    public boolean isPalindrome_2(ListNode head) {

        this.left = head;
        return traverse(head);
    }

    private ListNode left;

    /**
     * 链表的后序遍历
     * @param right
     * @return
     */
    private boolean traverse(ListNode right) {
        // 结束条件 链表遍历结束
        if (right == null) {
            return true;
        }
        // 前序遍历位置
        // 递归
        boolean res = traverse(right.next);
        // 后序遍历位置
        res = res && (left.val == right.val);
        left = left.next;
        return res;
    }

    /**
     * -----------------------------------------------------------------------------------------------------------------
     */

    /**
     * 找到中间节点 翻转链表的后半部分 然后比较
     * @param head
     * @return
     */
    public boolean isPalindrome_3(ListNode head) {
        // 边界情况
        if (head == null || head.next == null) return true;

        // 找到中间节点 奇偶分别讨论
        // 偶数指向后半部分的第一个节点 奇数指向中间节点
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 奇数
        if (fast != null) {
            slow = slow.next;
        }

        ListNode left = head;
        ListNode right = reverse(slow);

        while(right != null) {
            if (left.val != right.val) {
                return false;
            }
            left = left.next;
            right = right.next;
        }
        return true;
    }

    /**
     * 翻转链表
     * @param head
     * @return
     */
    private ListNode reverse(ListNode head) {
        ListNode preHead = new ListNode();
        ListNode cur = head;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = preHead.next;
            preHead.next = cur;
            cur = temp;
        }
        return preHead.next;
    }
}
