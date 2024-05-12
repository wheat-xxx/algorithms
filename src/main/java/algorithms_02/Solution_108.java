package algorithms_02;

import data_structure.TreeNode;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/04/11  9:57
 */
public class Solution_108 {

    private int[] nums;

    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums == null || nums.length == 0) return null;

        this.nums = nums;

        return recursive(0, nums.length - 1);
    }

    public TreeNode recursive(int left_index, int right_index){
        if(left_index <= right_index){
            int middle = (left_index + right_index) / 2;
            TreeNode root = new TreeNode(nums[middle]);
            root.left = recursive(left_index, middle - 1);
            root.right = recursive(middle + 1, right_index);
            return root;
        }else return null;
    }

}
