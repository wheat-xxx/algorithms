package algorithms_01;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/11  16:23
 */
public class Solution_71 {

    public String simplifyPath(String path){
        Deque<String> stack = new LinkedList<>();

        for(String item : path.split("/")){
            if("..".equals(item)){
                if(!stack.isEmpty()) stack.pop();
            }else if(!".".equals(item)){
                stack.push(item);
            }
        }
        String res = "";
        for(String item : stack) res = "/" + item + res;
        return res.isEmpty() ? "/" : res;
     }

}
