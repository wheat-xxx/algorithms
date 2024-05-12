package algorithms_01;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/08  16:51
 */
public class Solution_65 {

    public boolean isNumber(String s){
        int len = s.length();
        char[] cs = s.toCharArray();
        int index_e = -1;
        for(int i = 0; i < len; i++){
            if(cs[i] == 'e' || cs[i] == 'E'){
                if(index_e == -1) index_e = i;
                else return false;
            }
        }

        boolean ans = true;
        if(index_e != -1){
            ans &= check(cs, 0, index_e - 1, false);
            ans &= check(cs, index_e + 1, len - 1, true);
        }else{
            ans &= check(cs, 0, len-1, false);
        }
        return ans;
    }

    public boolean check(char[] cs, int start, int end, boolean mustInteger){
        if(start > end) return false;
        if(cs[start] == '+' || cs[start] == '-') start++;
        boolean hasDot = false, hasNum = false;
        for(int i = start; i <= end; i++){
            if(cs[i] == '.'){
                if(mustInteger || hasDot) return false;
                hasDot = true;
            }else if(cs[i] >= '0' && cs[i] <= '9'){
                hasNum = true;
            }else{
                return false;
            }
        }
        return hasNum;
    }

}
