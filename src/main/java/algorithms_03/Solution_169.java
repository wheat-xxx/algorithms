package algorithms_03;

import com.sun.org.apache.xerces.internal.dom.PSVIAttrNSImpl;

import java.util.Random;

/**
 * @author wheat
 * @date 2023/12/07  17:05
 */
public class Solution_169 {

    /**
     * 由于该数的数量占比在一半以上，所以采用随机抽样，并判断该数在数组中的所占比例
     * 时间复杂度是O(n)
     * @param nums
     * @return
     */
    public int majorityElement(int[] nums) {
        int majorityCount = nums.length / 2;

        Random random = new Random();
        while(true) {
            int index = random.nextInt(nums.length);
            if (countOccurrence(nums, nums[index]) > majorityCount) return nums[index];
        }
    }

    private int countOccurrence(int[] nums, int num) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if(num == nums[i]) count++;
        }
        return count;
    }

    public static void main(String[] args) {
        // 创建一个 Random 对象
        Random random = new Random();

        // 生成随机整数
        int randomNumber = random.nextInt();
        System.out.println("Random Integer: " + randomNumber);

        // 生成指定范围的随机整数（例如，生成1到100之间的随机数）
        int randomInRange = random.nextInt(100) + 1;
        System.out.println("Random Integer in Range: " + randomInRange);

        // 生成随机浮点数（范围在0.0（包含）到1.0（不包含）之间）
        double randomDouble = random.nextDouble();
        System.out.println("Random Double: " + randomDouble);


    }

}
