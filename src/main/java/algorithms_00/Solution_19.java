package algorithms_00;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/23  16:37
 */
public class Solution_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {

        if(head == null) return null;

        ListNode first = head;
        ListNode second = head;

        // 用双指针确定倒数第n个节点与倒数第一个节点的距离
        for(int i = 0; i < n-1; i++){
            if(second.next == null) return null;
            second = second.next;
        }

        // first 和 second 同步遍历，当second到达最后时，first就是需要删除的节点
        // 如果删除的是头节点
        if(second.next == null){
            head = head.next;
            return head;
        }
        ListNode pre = null;
        while(second.next != null){
            pre = first;
            first = first.next;
            second = second.next;
        }

        pre.next = pre.next.next;

        return head;

    }

    /**
     * 单链表的实现
     */
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode(){}

        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }

    }

}


