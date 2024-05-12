package algorithms_01;

import org.junit.Test;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/13  21:35
 */
public class Solution_80 {

    public int removeDuplicates(int[] nums){
        return process(nums, 2);
    }

    public int process(int[] nums, int k){
        int index = 0;
        for(int elem : nums){
            if(index < k || nums[index - k] != elem) nums[index++] = elem;
        }
        return index;
    }
}
