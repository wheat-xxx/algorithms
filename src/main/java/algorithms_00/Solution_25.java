package algorithms_00;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *      给你链表的头节点 head ，每 k 个节点一组进行翻转，请你返回修改后的链表。
 *
 * @author wheat
 * @date 2023/02/26  17:21
 */
public class Solution_25 {

    @Test
    public void test(){
        ListNode head = new ListNode(Arrays.asList(1,2,3,4,5));
        reverseKGroup(head, 2);
    }

    /**
     * 递归实现
     * @param head
     * @param k
     * @return
     */
//    public ListNode reverseKGroup(ListNode head, int k) {
//
//        // 边界条件
//        if(k < 2){
//            return head;
//        }
//
//        ListNode pre = new ListNode(0, head);
//        ListNode first = pre.next, tail = pre.next;
//        // 结束条件
//        for(int i = 0; i < k - 1; i++){
//            if(tail != null && tail.next != null){
//                tail = tail.next;
//            }else{
//                return first;
//            }
//        }
//
//        // 后续节点的交换
//        tail.next = reverseKGroup(tail.next, k);
//        // 交换当前链表
//        while(first != tail){
//            ListNode others = first.next;
//            first.next = tail.next;
//            tail.next = first;
//            first = others;
//        }
//        return tail;
//    }


    /**
     * 非递归实现
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        return null;
    }



    /**
     * 单链表的实现
     */
    public static class ListNode{
        int val;
        ListNode next;

        public ListNode() {}
        public ListNode(int val){
            this.val = val;
        }
        public ListNode(int val , ListNode next){
            this.val = val;
            this.next = next;
        }

        public ListNode(List<Integer> list){
            if(list != null && list.size() != 0){
                this.val = list.get(0);
                ListNode tail = this;
                for(int i = 1; i < list.size(); i++){
                    ListNode temp = new ListNode(list.get(i));
                    tail.next = temp;
                    tail = temp;
                }
            }
        }

    }

}
