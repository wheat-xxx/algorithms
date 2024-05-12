package algorithms_00;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *      给你一个链表，两两交换其中相邻的节点，并返回交换后链表的头节点。
 * @author wheat
 * @date 2023/02/24  16:56
 */
public class Solution_24 {

    @Test
    public void test(){
        ListNode head = new ListNode(Arrays.asList(1, 2, 3, 4));
        swapPairs(head);
    }

    public ListNode swapPairs(ListNode head) {


        // 边界条件 没有节点或者只有一个节点
        if(head == null || head.next == null){
            return head;
        }

        // 借助双指针完成节点的交换
        ListNode first = head, second = head.next;
        ListNode ret = second;
        ListNode pre = null;

        while(first != null && second != null){

            ListNode temp = null;

            if(pre == null){
                temp = second.next;
                first.next = temp;
                second.next = first;
            }else{
                temp = second.next;
                pre.next = second;
                second.next = first;
                first.next = temp;
            }

            // 指针更新
            if(temp != null && temp.next != null){
                pre = first;
                first = temp;
                second = temp.next;
            }else{
                break;
            }

        }

        return ret;

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
