package algorithms_04;

/**
 * @author wheat
 * @date 2023/12/18  17:09
 */
public class Solution_201 {

//    /**
//     * 超出时间限制
//     * @param left
//     * @param right
//     * @return
//     */
//    public int rangeBitwiseAnd(int left, int right) {
//        int res = left;
//        for(int i = left + 1; i <= right; i++) {
//            res &= i;
//        }
//        return res;
//    }

    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while(left < right) {
            left >>= 1;
            right >>= 1;
            shift++;
        }
        return left <<= shift;
    }

}
