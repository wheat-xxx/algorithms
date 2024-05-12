package algorithms_03;

/**
 * @author wheat
 * @date 2023/12/07  17:29
 */
public class Solution_172 {

//    public int trailingZeroes(int n) {
//        // 边界情况
//        if(n < 0) throw new RuntimeException("阶乘不能小于0~~");
//
//        if(n == 0) return 0;
//
//        // 统计每个数的个位数中含5、2、4、6、8的个数，以及该数本身含0的个数
//        int count_0 = 0, count_5 = 0, count_2 = 0;
//        for (int i = 1; i <= n; i++) {
//            // 末尾0的个数
//            if(i % 10 == 0) {
//                int others = i;
//                while(others % 10 == 0) {
//                    count_0++;
//                    others /= 10;
//                }
//                continue;
//            }
//            // 统计末尾5的个数
//            if(i % 5 == 0) count_5++;
//            // 统计末尾是2的倍数的个数
//            if(i % 2 == 0) count_2++;
//        }
//
//        return count_0 + (count_2 < count_5 ? count_2 : count_5);
//    }

    /**
     * 10 = 2 * 5
     * @param n
     * @return
     */
    public int trailingZeroes(int n) {
        int ans = 0;

        // 质因子5的个数
        for(int i = 5; i <= n; i += 5) {
            for(int x = i; x % 5 == 0; x /= 5) {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        new Solution_172().trailingZeroes(30);
    }

}
