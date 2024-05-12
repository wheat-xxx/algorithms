package algorithms_00;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Description:
 *
 *      给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 *
 * @author wheat
 * @date 2023/03/04  20:34
 */
public class Solution_43 {

    public String multiply(String num1, String num2) {

        // 边界检查
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "0";
        if(num1.equals("0") || num2.equals("0")) return "0";

        // 将字符串转为数组进行存储
        char[] chs1 = num1.toCharArray();
        char[] chs2 = num2.toCharArray();

        // 利用动态数组保存运算结果
        List<Integer> res = new ArrayList<>();

        // 逐位相乘

        for(int i = 0; i < chs1.length; i++){
            int carry = 0;
            List<Integer> temp = new ArrayList<>();
            for(int j = 0; j < chs2.length; j++){
                // 利用乘法法则进行运算
                int sum = (chs1[chs1.length-1-i] - '0') * (chs2[chs2.length-1-j] - '0') + carry;
                carry = sum / 10;
                sum = sum % 10;
                temp.add(sum);
            }
            if(carry != 0) temp.add(carry);

            // 将temp保存进最终结果
            carry = 0;
            for(int k = 0; k < temp.size(); k++){
                if(i + k >= res.size()){
                    int sum = temp.get(k) + carry;
                    carry = sum / 10;
                    sum = sum % 10;
                    res.add(sum);
                }else{
                    int sum = res.get(i + k) + temp.get(k) + carry;
                    carry = sum / 10;
                    sum = sum % 10;
                    res.set(i + k, sum);
                }
            }
            if(carry != 0) res.add(carry);
        }

        Collections.reverse(res);

        StringBuilder sb = new StringBuilder();
        for(Integer elem : res){
            sb.append(elem);
        }

        return sb.toString();
    }

    @Test
    public void test(){
        String nums1 = "999";
        String nums2 = "999";

        System.out.println(multiply(nums1, nums2));
    }

}
