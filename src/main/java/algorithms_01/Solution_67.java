package algorithms_01;

import org.junit.Test;

import java.util.jar.JarEntry;

/**
 * Description:
 *      给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
 * @author wheat
 * @date 2023/03/09  19:52
 */
public class Solution_67 {

    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();

        int min = a.length() < b.length() ? a.length() : b.length();

        int carry = 0;
        for(int i = 0; i < min; i++){
            if(a.charAt(a.length() - i - 1) == '1' && b.charAt(b.length() - i - 1) == '1'){
                sb.append(carry);
                carry = 1;
            }else if(a.charAt(a.length() - i - 1) == '1' || b.charAt(b.length() - i - 1) == '1'){
                if(carry == 0) sb.append(1);
                else{
                    sb.append(0);
                    carry = 1;
                }
            }else{
                sb.append(carry);
                carry = 0;
            }
        }

        int rest;
        if(min != a.length()){
            rest = a.length() - min;
            while(rest-- > 0){
                if(carry == 1 && a.charAt(rest) == '1'){
                    sb.append(0);
                    carry = 1;
                }else if(carry == 1 || a.charAt(rest) == '1'){
                    sb.append(1);
                    carry = 0;
                }else{
                    sb.append(0);
                    carry = 0;
                }
            }
        }else{
            rest = b.length() - min;
            while(rest-- > 0){
                if(carry == 1 && b.charAt(rest) == '1'){
                    sb.append(0);
                    carry = 1;
                }else if(carry == 1 || b.charAt(rest) == '1'){
                    sb.append(1);
                    carry = 0;
                }else{
                    sb.append(0);
                    carry = 0;
                }
            }
        }

        if(carry == 1) sb.append(1);
        return sb.reverse().toString();
    }

    @Test
    public void test(){
        String a =
                "1010";
        String b =
                "1011";
        String res = addBinary(a, b);

    }

}
