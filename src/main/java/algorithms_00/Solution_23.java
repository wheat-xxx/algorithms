package algorithms_00;

import data_structure.ListNode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Description:
 *      合并k个升序链表
 *
 * @author wheat
 * @date 2023/02/24  14:07
 */
public class Solution_23 {


//    /**
//     * 两两合并
//     * @param lists
//     * @return
//     */
//    public ListNode mergeKLists(ListNode[] lists) {
//        ListNode result = null;
//
//        for(int i = 0; i < lists.length; i++){
//            result = mergeTwoLists(result, lists[i]);
//        }
//
//        return result;
//    }
//
//
//    // 递归实现
//    public ListNode mergeTwoLists(ListNode list1, ListNode list2){
//
//        // 边界条件
//        if(list1 == null){
//            return list2;
//        }
//        if(list2 == null){
//            return list1;
//        }
//
//        if(list1.val < list2.val){
//            list1.next = mergeTwoLists(list1.next, list2);
//            return list1;
//        }else{
//            list2.next = mergeTwoLists(list1, list2.next);
//            return list2;
//        }
//
//    }


    public ListNode mergeKLists(ListNode[] lists) {

        if(lists == null) return null;

        // 定义一个优先级队列
        PriorityQueue<Status> queue = new PriorityQueue<>();

        for(ListNode node : lists){
            if(node != null){
                queue.offer(new Status(node.val, node));
            }
        }

        ListNode head = new ListNode(0);
        ListNode tail = head;
        while(!queue.isEmpty()){
            Status temp = queue.poll();
            tail.next = temp.ptr;
            tail = temp.ptr;
            if(temp.ptr.next != null){
                queue.offer(new Status(temp.ptr.next.val, temp.ptr.next));
            }
        }

        return head.next;

    }


    /**
     * 定义一个优先级队列需要的数据类型
     */
    public static class Status implements Comparable<Status> {

        int val;
        ListNode ptr;

        Status(int val, ListNode ptr){
            this.val = val;
            this.ptr = ptr;
        }

        @Override
        public int compareTo(Status o) {
            return this.val - o.val;
        }
    }

}
