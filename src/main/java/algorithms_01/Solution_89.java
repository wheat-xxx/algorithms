package algorithms_01;

import java.util.ArrayList;
import java.util.List;

/**
 * Description:
 *
 * @author wheat
 * @date 2023/03/27  14:25
 */
public class Solution_89 {

    public List<Integer> grayCode(int n){
        List<Integer> res = new ArrayList<Integer>(){
            {
                super.add(0);
            }
        };
        int head = 1;
        for(int i = 0; i < n; i++){
            for(int j = res.size() - 1; j >= 0; j--)
                res.add(head + res.get(j));
            head <<= 1;
        }

        // 返回值
        return res;
    }

}

