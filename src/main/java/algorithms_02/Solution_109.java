package algorithms_02;

import data_structure.ListNode;
import data_structure.TreeNode;

/**
 * Description:
 *      有序链表转二叉搜索树
 * @author wheat
 * @date 2023/04/11  16:10
 */
public class Solution_109 {

    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;

        return buildTree(head, null);
    }

    // left right 采用左闭右开原则
    public TreeNode buildTree(ListNode left, ListNode right){
        if(left == right) return null;
        else{
            ListNode middle = findMiddle(left, right);
            TreeNode root = new TreeNode(middle.val);
            root.left = buildTree(left, middle);
            root.right = buildTree(middle.next, right);
            return root;
        }
    }

    // 通过快慢指针寻找链表的中间节点
    public ListNode findMiddle(ListNode left, ListNode right){
        ListNode fast = left, slow = left;
        // 左子树节点多
        while(fast != right && fast.next != right){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
