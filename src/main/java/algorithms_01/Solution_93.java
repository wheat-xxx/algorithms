package algorithms_01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/31  11:37
 */
public class Solution_93 {

    private List<String> res = new ArrayList<>();
    private StringBuilder path = new StringBuilder();

    public List<String> restoreIpAddresses(String s) {

        // 边界条件
        if(s.length() < 4 || s.length() > 12) return res;

        dfs(s, 0, 1);

        return res;

    }

    private void dfs(String s, int index, int count){
        // 递归结束条件
        if(index == s.length()){
            if(count == 5) res.add(path.toString().substring(0, path.length() - 1));
            return;
        }

        // 递归体
        for(int i = 1; i <= 3 && (index + i) <= s.length(); i++){

            // 如果字段以0开头 直接排除
            if(i != 1 && s.charAt(index) == '0') return;

            if(i == 3){
                int temp = (s.charAt(index) - '0') * 100 + (s.charAt(index + 1) - '0') * 10 + (s.charAt(index + 2) - '0');
                if(temp <= 255){
                    path.append(s, index, index + 3);
                    path.append('.');
                    dfs(s, index + 3, count + 1);
                    path.deleteCharAt(path.length() - 1);
                    path.delete(path.length() - 3, path.length());
                }
            }else{
                path.append(s, index, index + i);
                path.append('.');
                dfs(s, index + i, count + 1);
                path.deleteCharAt(path.length() - 1);
                path.delete(path.length() - i, path.length());
            }
        }
    }

    @Test
    public void test(){
        restoreIpAddresses("25525511135");
    }

}
