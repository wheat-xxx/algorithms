package algorithms_00;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/02/23  17:17
 */
public class Solution_21 {

    @Test
    public void test(){
        ListNode list1 = new ListNode(Arrays.asList(1, 2, 4));
        ListNode list2 = new ListNode(Arrays.asList(1, 3, 4));

        ListNode ret = mergeTwoLists(list1, list2);

    }

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode head = null, tail = null;

        // 边界情况
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        // 都不为空
        while(list1 != null && list2 != null){
            // 第一次进入循环 给头节点赋值
            if(head == null){
                if(list1.val < list2.val){
                    head = tail = list1;
                    list1 = list1.next;
                }else{
                    head = tail = list2;
                    list2 = list2.next;
                }
                continue;
            }

            if(list1.val < list2.val){
                tail.next = list1;
                tail = list1;
                list1 = list1.next;
            }else{
                tail.next = list2;
                tail = list2;
                list2 = list2.next;
            }
        }

        while(list1 != null){
            tail.next = list1;
            tail = list1;
            list1 = list1.next;
        }
        while(list2 != null){
            tail.next = list2;
            tail = list2;
            list2 = list2.next;
        }

        return head;

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
