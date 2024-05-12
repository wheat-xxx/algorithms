package data_structure;

import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/07  20:33
 */
public class ListNode {

    public int val;
    public ListNode next;
    public ListNode(){}
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    // 利用数组构建一个新的链表
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
