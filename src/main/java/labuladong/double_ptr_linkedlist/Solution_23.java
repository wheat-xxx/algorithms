package labuladong.double_ptr_linkedlist;

import data_structure.ListNode;

import java.util.PriorityQueue;

/**
 * 给你一个链表数组，每个链表都已经按升序排列。
 * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
 * @author wheat
 * @date 2024/03/20  15:09
 */
public class Solution_23 {

    /**
     * 两两合并
     * @param lists
     * @return
     */
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode result = null;

        for(int i = 0; i < lists.length; i++){
            result = mergeTwoLists(result, lists[i]);
        }

        return result;
    }


    /**
     * 递归实现两个链表合并
     * @param list1
     * @param list2
     * @return
     */
    private ListNode mergeTwoLists(ListNode list1, ListNode list2){

        // 边界条件
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }

        if(list1.val < list2.val){
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }else{
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }

    }

    /**
     * 使用优先级队列
     * @param lists
     * @return
     */
    public ListNode mergeKLists_2(ListNode[] lists) {
        // 边界情况
        if(lists == null || lists.length == 0) {
            return null;
        }

        // 虚拟头节点
        ListNode dummy = new ListNode();
        ListNode work = dummy;

        // 优先级队列，最小堆
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));
        for (ListNode list : lists) {
            if(list != null) {
                priorityQueue.offer(list);
            }
        }

        while(!priorityQueue.isEmpty()) {
            // 获取最小节点，接入链表
            ListNode node = priorityQueue.poll();
            work.next = node;
            if(node.next != null) {
                priorityQueue.offer(node.next);
            }
            work = work.next;
        }

        return dummy.next;
    }


    public static void main(String[] args) {
        // 优先级队列
        // 创建优先级队列
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        // 添加元素
        priorityQueue.offer(3);
        priorityQueue.offer(1);
        priorityQueue.offer(2);

        // 遍历并移除元素（按照优先级顺序）
        while(!priorityQueue.isEmpty()) {
            System.out.println(priorityQueue.poll());
        }
    }

}
