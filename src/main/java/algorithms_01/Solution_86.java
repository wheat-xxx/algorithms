package algorithms_01;

import data_structure.ListNode;
import org.junit.Test;

import java.util.Arrays;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/14  17:40
 */
public class Solution_86 {

    public ListNode partition(ListNode head, int x) {

        // 自定义新的头节点，对链表中节点进行同一处理
        ListNode preHead = new ListNode();
        preHead.next = head;

        // 遍历链表的指针
        ListNode left = preHead, right = preHead;

        // 遍历
        while(right.next != null){
            // 小于则向前插入
            if(right.next.val < x){
                // left == right 不需要插入
                if(left == right){
                    left = right.next;
                    right = right.next;
                    continue;
                }
                ListNode temp = right.next;
                right.next = temp.next;
                temp.next = left.next;
                left.next = temp;
                left = temp;
            }else{
                right = right.next;
            }
        }

        return preHead.next;
    }

    @Test
    public void test(){
        ListNode head  = new ListNode(Arrays.asList(1,4,3,2,5,2));
        ListNode res = partition(head, 3);
    }

}
