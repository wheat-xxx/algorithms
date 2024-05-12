package algorithms_03;

import java.util.HashMap;
import java.util.Map;

/**
 * 结果有三种情况：整数、有限小数、无限循环小数  --- 都可以表示为分数
 * 无限不循环小数无法表示为分数
 * @author wheat
 * @date 2023/12/06  14:35
 */
public class Solution_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        // 边界情况
        if(denominator == 0) throw new IllegalArgumentException();

        // 防止计算过程中产生溢出
        long numeratorLong = (long) numerator;
        long denominatorLong = (long) denominator;

        // 整数
        if(numeratorLong % denominatorLong == 0) {
            return String.valueOf(numeratorLong/ denominatorLong);
        }

        // 处理运算结果的符号
        StringBuilder sb = new StringBuilder();
        if(numeratorLong < 0 ^ denominatorLong < 0) {
            sb.append('-');
        }

        // 整数部分
        numeratorLong = Math.abs(numeratorLong);
        denominatorLong = denominatorLong < 0 ? -denominatorLong : denominatorLong;
        long integerPart = numeratorLong / denominatorLong;
        sb.append(integerPart);
        sb.append('.');

        // 小数部分
        StringBuilder fractionPart = new StringBuilder();
        Map<Long, Integer> remainderIndexMap = new HashMap<>();
        long remainder = numeratorLong % denominatorLong;
        int index = 0;
        while(remainder != 0 && !remainderIndexMap.containsKey(remainder)) {
            remainderIndexMap.put(remainder, index);
            remainder *= 10;
            fractionPart.append(remainder / denominatorLong);
            remainder %= denominatorLong;
            index++;
        }

        // 有循环节
        if(remainder != 0) {
            int insertIndex = remainderIndexMap.get(remainder);
            fractionPart.insert(insertIndex, '(');
            fractionPart.append(')');
        }
        sb.append(fractionPart.toString());

        return sb.toString();
    }

}
