package algorithms_01;

import data_structure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/08  16:37
 */
public class Solution_99 {

    private List<Integer> nums = new ArrayList<Integer>();
    private int[] swapPosition;
    private int index = 1;

    public void inorderTraversal(TreeNode root){
        if(root != null){
            inorderTraversal(root.left);
            nums.add(root.val);
            inorderTraversal(root.right);
        }
    }

    public int[] findError(){
        int[] res = new int[2];
        for(int i = 0; i < nums.size() - 1; i++){
            // 寻找出错位置 第一个出错位置
            if(nums.get(i) > nums.get(i + 1)){
                if(res[0] == 0) res[0] = i + 1;
                else res[1] = i + 2;
            }
        }
        if(res[1] == 0) res[1] = res[0] + 1;
        return res;
    }

    public void recover(TreeNode root){
        if(root != null){
            recover(root.left);
            if(index == swapPosition[0]) root.val = nums.get(swapPosition[1] - 1);
            if(index == swapPosition[1]) root.val = nums.get(swapPosition[0] - 1);
            index++;
            recover(root.right);
        }
    }

    public void recoverTree(TreeNode root) {

        // 遍历二叉树
        inorderTraversal(root);

        // 寻找错误位置
        this.swapPosition = findError();

        // 恢复位置
        recover(root);
    }

}
