package algorithms_00;

import org.junit.Test;

/**
 * Description:
 *      给你两个整数，被除数 dividend 和除数 divisor。将两数相除，要求 不使用 乘法、除法和取余运算。
 * @author wheat
 * @date 2023/02/26  19:37
 */
public class Solution_29 {

    @Test
    public void test(){
        System.out.println(-(0x80000000 + 1) );
    }

    /**
     * 整体解决思路 处理掉所有的边界情况，然后取绝对值做减法处理
     * 超出时间限制
     * @param dividend
     * @param divisor
     * @return
     */
    public int divide(int dividend, int divisor) {

        // 结果的符号
        boolean flag = (dividend < 0) ^ (divisor < 0);  // false+ true-

        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int result = 0;
        while(dividend <= divisor) {
            result--;
            if(result == Integer.MIN_VALUE){
                return flag ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            dividend -= divisor;
        }

        result = flag ? result : -result;

        return result;

    }

    public int divide_2(int dividend, int divisor) {

        final int LIMIT = Integer.MIN_VALUE / 2;    // 小于LIMIT翻倍会溢出

        // 结果的符号
        boolean flag = (dividend < 0) ^ (divisor < 0);  // false+ true-

        // 全部转为负数进行处理 负数表示的范围更广
        dividend = dividend < 0 ? dividend : -dividend;
        divisor = divisor < 0 ? divisor : -divisor;

        int result = 0;
        while(dividend <= divisor) {
            int newDivisor = divisor, tempCount = -1;
            while(newDivisor >= LIMIT && tempCount >= LIMIT && newDivisor + newDivisor >= dividend) {
                newDivisor += newDivisor;
                tempCount += tempCount;
            }
            result += tempCount;
            dividend -= newDivisor;
        }

        if(!flag && result == Integer.MIN_VALUE) return Integer.MAX_VALUE;

        return flag ? result : -result;     // if result == -Integer.MIN_VALUE -result会溢出
    }

    public static void main(String[] args) {
        int a = 3343242;
        int b = -3232;
        System.out.println(new Solution_29().divide(a, b));
        System.out.println(a / b);
    }

}
